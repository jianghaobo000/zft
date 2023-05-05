package cdu.jhb.prescription;

import cdu.jhb.charge.database.ChargeDetailMapper;
import cdu.jhb.charge.database.ChargeMapper;
import cdu.jhb.charge.database.dataobject.ChargeDO;
import cdu.jhb.charge.database.dataobject.ChargeDetailDO;
import cdu.jhb.common.Constant;
import cdu.jhb.common.DictException;
import cdu.jhb.domain.patient.Patient;
import cdu.jhb.domain.prescription.Advice;
import cdu.jhb.domain.prescription.Prescription;
import cdu.jhb.domain.prescription.gateway.PrescriptionGateway;
import cdu.jhb.inventory.database.InventoryMapper;
import cdu.jhb.inventory.database.InventoryOutDetailMapper;
import cdu.jhb.inventory.database.InventoryOutMapper;
import cdu.jhb.inventory.database.dataobject.InventoryDO;
import cdu.jhb.inventory.database.dataobject.InventoryOutDO;
import cdu.jhb.inventory.database.dataobject.InventoryOutDetailDO;
import cdu.jhb.patient.database.PatientMapper;
import cdu.jhb.patient.database.VisitMapper;
import cdu.jhb.patient.database.dataobject.PatientDO;
import cdu.jhb.patient.database.dataobject.VisitDO;
import cdu.jhb.prescription.database.AdviceMapper;
import cdu.jhb.prescription.database.PrescriptionDetailMapper;
import cdu.jhb.prescription.database.PrescriptionMapper;
import cdu.jhb.prescription.database.dataobject.AdviceDO;
import cdu.jhb.prescription.database.dataobject.PrescriptionDO;
import cdu.jhb.prescription.database.dataobject.PrescriptionDetailDO;
import cdu.jhb.util.Calculate;
import cdu.jhb.util.Convert;
import cdu.jhb.util.RedisUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* @description: TODO
* @author jhb
* @date 2023/05/04 21:08
* @version 1.0
*/
@Component
@RequiredArgsConstructor
public class PrescriptionGatewayImpl implements PrescriptionGateway {

    private final PatientMapper patientMapper;

    private final AdviceMapper adviceMapper;

    private final PrescriptionMapper prescriptionMapper;

    private final PrescriptionDetailMapper prescriptionDetailMapper;

    private final InventoryMapper inventoryMapper;

    private final InventoryOutMapper inventoryOutMapper;

    private final InventoryOutDetailMapper inventoryOutDetailMapper;

    private final ChargeMapper chargeMapper;

    private final ChargeDetailMapper chargeDetailMapper;

    private final VisitMapper visitMapper;

    /**
     * 完成接诊
     * @param patient
     * @param advice
     * @param prescription
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveVisit(Patient patient, Advice advice, Prescription prescription) {
        PatientDO patientDO = Convert.entityConvert(patient,PatientDO.class);
        AdviceDO adviceDO = Convert.entityConvert(advice,AdviceDO.class);
        PrescriptionDO prescriptionDO = Convert.entityConvert(prescription,PrescriptionDO.class);
        List<PrescriptionDetailDO> prescriptionDetailDOList = Convert.listConvert(prescription.getPrescriptionDetailList(),PrescriptionDetailDO.class);

        // 新增或修改患者信息
        if(patientDO!=null){
            // 不存在即新增，反之则修改
            if(patientDO.getPatientId()==null){
                if(patientMapper.insert(patientDO)!=1){
                    throw new RuntimeException(DictException.INSERT_PATIENT_FAILED);
                }
            }else{
                if(patientMapper.updateById(patientDO)!=1){
                    throw new RuntimeException(DictException.UPDATE_PATIENT_FAILED);
                }
            }

            if(prescriptionDO!=null){
                // 新增处方单,处方单涉及出库数据，每次都只能新增
                if(prescriptionMapper.insert(prescriptionDO)!=1){
                    throw new RuntimeException(DictException.INSERT_PRESCRIPTION_FAILED);
                }

//                // 生成销售出库单
//                InventoryOutDO inventoryOutDO = AssemblyOutData(prescriptionDO);
//                // 新增销售出库单
//                inventoryOutMapper.insert(inventoryOutDO);
//                List<InventoryOutDetailDO> inventoryOutDetailDOList = AssemblyOutDetailData(prescriptionDetailDOList,inventoryOutDO);
//                // 组装销售出库数据并新增出库明细
//                AssemblyData(inventoryOutDetailDOList,inventoryOutDO,1);
//
                // 新增处方明细单
                prescriptionDetailDOList.forEach(prescriptionDetailDO -> {
                    prescriptionDetailDO.setPrescriptionId(prescriptionDO.getPrescriptionId());
                    if(prescriptionDetailMapper.insert(prescriptionDetailDO)!=1){
                        throw new RuntimeException(DictException.INSERT_PRESCRIPTION_DETAIL_FAILED);
                    }
                });

                // 新增收费单
                AssemblyChargeData(prescriptionDO,prescriptionDetailDOList);

                // 新增或修改病历单
                if(adviceDO!=null){
                    adviceDO.setAdvicePatientId(patientDO.getPatientId());
                    adviceDO.setAdvicePrescriptionId(prescriptionDO.getPrescriptionId());
                    // 不存在即新增，反之修改
                    if(adviceDO.getAdviceId()!=null){
                        if(adviceMapper.insert(adviceDO)!=1){
                            throw new RuntimeException(DictException.INSERT_ADVICE_FAILED);
                        }
                    }else{
                        if(adviceMapper.updateById(adviceDO)!=1){
                            throw new RuntimeException(DictException.UPDATE_ADVICE_FAILED);
                        }
                    }

                    // 新增就诊记录
                    AssemblyVisitData(patientDO,adviceDO);

                }else{
                    throw new RuntimeException(DictException.INSERT_ADVICE_FAILED);
                }
            }
            else{
                throw new RuntimeException(DictException.INSERT_PRESCRIPTION_FAILED);
            }
        }
        else{
            throw new RuntimeException(DictException.INSERT_PATIENT_FAILED);
        }

        return true;
    }

    /**
     * 组装数据
     * @param outDetailDOList
     * @param inventoryOutDO
     * @param status
     */
    @Transactional(rollbackFor = Exception.class)
    public void AssemblyData(List<InventoryOutDetailDO> outDetailDOList, InventoryOutDO inventoryOutDO, int status){
        // 将涉及到的商品ID的库存信息查出来
        QueryWrapper<InventoryDO> inventoryDOQueryWrapper = new QueryWrapper<>();
        inventoryDOQueryWrapper.lambda().in(InventoryDO::getInventoryCommodityId,outDetailDOList.stream().map(InventoryOutDetailDO::getInventoryOutCommodityId).collect(Collectors.toList()));
        List<InventoryDO> inventoryDOList = inventoryMapper.selectList(inventoryDOQueryWrapper);

        // 对库存数量进行处理
        inventoryDOList.forEach(inventoryDO -> {
            // 将商品ID相同的对象匹配起来
            InventoryOutDetailDO inventoryOutDetailDO = outDetailDOList.stream().filter(detail -> detail.getInventoryOutCommodityId().equals(inventoryDO.getInventoryCommodityId())).findFirst().orElse(null);
            assert inventoryOutDetailDO != null;
            // 设置明细表的主表ID
            inventoryOutDetailDO.setInventoryOutId(inventoryOutDO.getInventoryOutId());
            // 出库明细单设置出库操作之前的库存数量
            inventoryOutDetailDO.setInventoryOutBeforeLargeNum(inventoryDO.getInventoryLargeNum());
            inventoryOutDetailDO.setInventoryOutBeforeSmallNum(inventoryDO.getInventorySmallNum());

            // 通过大小转换单位比计算出出库数量
            Map<String, Integer> map1 = Calculate.inventoryQuantity(
                    inventoryOutDetailDO.getInventoryOutLargeNum(),
                    inventoryOutDetailDO.getInventoryOutSmallNum(),
                    inventoryDO.getInventoryDosageForm());
            // 出库明细单设置出库操作的库存数量
            inventoryOutDetailDO.setInventoryOutLargeNum(map1.get(Constant.LARGE_NUM));
            inventoryOutDetailDO.setInventoryOutSmallNum(map1.get(Constant.SMALL_NUM));


            // 通过大小转换单位比计算之后库存
            Map<String, Integer> map2 = Calculate.inventoryQuantity(
                    inventoryDO.getInventoryLargeNum() - inventoryOutDetailDO.getInventoryOutLargeNum(),
                    inventoryDO.getInventorySmallNum() - inventoryOutDetailDO.getInventoryOutSmallNum(),
                    inventoryDO.getInventoryDosageForm());
            if(map2.get(Constant.LARGE_NUM) < 0){
                throw new RuntimeException(DictException.OUT_OF_STACK_PREFIX +inventoryDO.getInventoryCommodityId()+DictException.OUT_OF_STACK_SUFFIX);
            }
            // 库存主表设置出库操作之后的库存数
            inventoryDO.setInventoryLargeNum(map2.get(Constant.LARGE_NUM));
            inventoryDO.setInventorySmallNum(map2.get(Constant.SMALL_NUM));
            // 出库明细单设置出库操作之后的库存数量
            inventoryOutDetailDO.setInventoryOutAfterLargeNum(map2.get(Constant.LARGE_NUM));
            inventoryOutDetailDO.setInventoryOutAfterSmallNum(map2.get(Constant.SMALL_NUM));

            // 更新库存主表的信息
            inventoryMapper.updateById(inventoryDO);
            // 新增出库明细表信息,清空主键id
            inventoryOutDetailDO.setInventoryOutDetailId(null);
            inventoryOutDetailMapper.insert(inventoryOutDetailDO);
        });
    }

    /**
     * 组装销售出库数据
     * @param prescriptionDO
     * @return
     */
    public InventoryOutDO AssemblyOutData(PrescriptionDO prescriptionDO){
        InventoryOutDO inventoryOutDO = new InventoryOutDO();
        // 设置为销售出库
        inventoryOutDO.setInventoryOutStatus(Constant.SALE_OUTBOUND);
        inventoryOutDO.setInventoryOutTime(prescriptionDO.getPrescriptionTime());
        inventoryOutDO.setInventoryOutCreateTime(prescriptionDO.getPrescriptionTime());
        inventoryOutDO.setInventoryOutCategory(Constant.ALREADY_OUTBOUND);
        inventoryOutDO.setInventoryOutOperatorId(prescriptionDO.getPrescriptionDoctorId());
        inventoryOutDO.setInventoryOutRemarks(Constant.SALE_OUTBOUND_REMARKS);
        inventoryOutDO.setInventoryOutTenantId(RedisUtil.getLocalTenantId());
        return inventoryOutDO;
    }

    /**
     * 组装销售出库明细数据
     * @return
     */
    public List<InventoryOutDetailDO> AssemblyOutDetailData(List<PrescriptionDetailDO> prescriptionDetailDOList,InventoryOutDO inventoryOutDO){
        List<InventoryOutDetailDO> inventoryOutDetailDOList = new ArrayList<>();
        prescriptionDetailDOList.forEach(prescriptionDetailDO -> {
            InventoryOutDetailDO inventoryOutDetailDO = new InventoryOutDetailDO();
            inventoryOutDetailDO.setInventoryOutId(inventoryOutDO.getInventoryOutId());
            inventoryOutDetailDO.setInventoryOutCommodityId(prescriptionDetailDO.getPrescriptionDetailCommodityId());
            inventoryOutDetailDO.setInventoryOutCommodityName(prescriptionDetailDO.getPrescriptionDetailCommodityName());
            inventoryOutDetailDO.setInventoryOutSplitSaleStatus(prescriptionDetailDO.getPrescriptionDetailSplitSaleStatus());
            inventoryOutDetailDO.setInventoryOutDosageForm(prescriptionDetailDO.getPrescriptionDetailDosageForm());
            inventoryOutDetailDO.setInventoryOutCommodityLargeSalePrice(prescriptionDetailDO.getPrescriptionDetailLargePrice());
            inventoryOutDetailDO.setInventoryOutCommoditySmallSalePrice(prescriptionDetailDO.getPrescriptionDetailSmallPrice());
            inventoryOutDetailDO.setInventoryOutLargeUnit(prescriptionDetailDO.getPrescriptionDetailLargeUnit());
            inventoryOutDetailDO.setInventoryOutSmallUnit(prescriptionDetailDO.getPrescriptionDetailSmallUnit());
            inventoryOutDetailDO.setInventoryOutLargeNum(prescriptionDetailDO.getPrescriptionDetailLargeNum());
            inventoryOutDetailDO.setInventoryOutSmallNum(prescriptionDetailDO.getPrescriptionDetailSmallNum());
            inventoryOutDetailDOList.add(inventoryOutDetailDO);
        });
        return inventoryOutDetailDOList;
    }

    /**
     * 生成收费单
     */
    @Transactional(rollbackFor = Exception.class)
    public void AssemblyChargeData(PrescriptionDO prescriptionDO,List<PrescriptionDetailDO> prescriptionDetailDOList){
        // 新增收费单主表
        ChargeDO chargeDO = new ChargeDO();
        chargeDO.setChargePrescriptionId(prescriptionDO.getPrescriptionId());
        chargeDO.setChargeTime(prescriptionDO.getPrescriptionTime());
        chargeDO.setChargePatientId(prescriptionDO.getPrescriptionPatientId());
        chargeDO.setChargePatientName(prescriptionDO.getPrescriptionPatientName());
        chargeDO.setChargeMoney(prescriptionDO.getPrescriptionMoney());
        chargeDO.setChargePayMoney(BigDecimal.ZERO);
        chargeDO.setChargePreferentialMoney(BigDecimal.ZERO);
        chargeDO.setChargeStatus(Constant.WAIT_CHARGE);
        chargeDO.setChargeTenantId(RedisUtil.getLocalTenantId());
        chargeMapper.insert(chargeDO);

        // 新增收费单明细表
        prescriptionDetailDOList.forEach(prescriptionDetailDO -> {
            ChargeDetailDO chargeDetailDO = new ChargeDetailDO();
            chargeDetailDO.setChargeId(chargeDO.getChargeId());
            chargeDetailDO.setChargeDetailCommodityId(prescriptionDetailDO.getPrescriptionDetailCommodityId());
            chargeDetailDO.setChargeDetailCommodityName(prescriptionDetailDO.getPrescriptionDetailCommodityName());
            chargeDetailDO.setChargeDetailSplitSaleStatus(prescriptionDetailDO.getPrescriptionDetailSplitSaleStatus());
            chargeDetailDO.setChargeDetailDosageForm(prescriptionDetailDO.getPrescriptionDetailDosageForm());
            chargeDetailDO.setChargeDetailLargePrice(prescriptionDetailDO.getPrescriptionDetailLargePrice());
            chargeDetailDO.setChargeDetailSmallPrice(prescriptionDetailDO.getPrescriptionDetailSmallPrice());
            chargeDetailDO.setChargeDetailLargeNum(prescriptionDetailDO.getPrescriptionDetailLargeNum());
            chargeDetailDO.setChargeDetailSmallNum(prescriptionDetailDO.getPrescriptionDetailSmallNum());
            chargeDetailDO.setChargeDetailLargeUnit(prescriptionDetailDO.getPrescriptionDetailLargeUnit());
            chargeDetailDO.setChargeDetailSmallUnit(prescriptionDetailDO.getPrescriptionDetailSmallUnit());
            chargeDetailMapper.insert(chargeDetailDO);
        });
    }

    /**
     * 组装就诊记录并新增
     * @param patientDO
     * @param adviceDO
     */
    @Transactional(rollbackFor = Exception.class)
    public void AssemblyVisitData(PatientDO patientDO,AdviceDO adviceDO){
        VisitDO visitDO = new VisitDO();
        visitDO.setVisitPatientId(patientDO.getPatientId());
        visitDO.setVisitPatientName(patientDO.getPatientName());
        visitDO.setVisitDoctorId(adviceDO.getAdviceDoctorId());
        visitDO.setVisitDoctorName(adviceDO.getAdviceDoctorName());
        visitDO.setVisitAdviceId(adviceDO.getAdviceId());
        visitDO.setVisitSymptom(adviceDO.getAdviceDiagnosis());
        visitDO.setVisitTenantId(RedisUtil.getLocalTenantId());
        visitDO.setVisitTime(adviceDO.getAdviceTime());
        visitMapper.insert(visitDO);
    }
}
