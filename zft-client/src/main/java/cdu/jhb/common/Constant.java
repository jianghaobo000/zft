package cdu.jhb.common;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
* @description: 常量池
* @author jhb
* @date 2023/04/12 21:41
* @version 1.0
*/
public class Constant {

    // 空字符串
    public final static String NULL_STRING = "";

    // 开始时分秒
    public final static String BEGIN_TIME = " 00:00:00";

    // 结束时分秒
    public final static String END_TIME = " 23:59:59";

    // 租户ID字段
    public final static String TENANT_ID = "tenantId";

    // 租户名
    public final static String TENANT_NAME = "tenantName";

    // 账户名字段
    public final static String ACCOUNT_NAME = "accountName";

    // 验证码字段
    public final static String VALID_CODE = "validCode";

    // 权限ID
    public final static String ROLE_ID = "roleId";

    // 账号实体
    public final static String ACCOUNT = "account";

    // 员工实体
    public final static String EMPLOYEE = "employee";

    // 错误信息
    public final static String ERROR_INFO = "errorInfo";

    // 字体1
    public final static String FONT_TIMES_NEW_ROMAN = "Times New Roman";

    // 已入库
    public final static String ALREADY_WAREHOUSING = "已入库";

    // 待入库
    public final static String WAIT_WAREHOUSING = "待入库";

    // 已出库
    public final static String ALREADY_OUTBOUND = "已出库";

    // 待出库
    public final static String WAIT_OUTBOUND = "未出库";

    // 已盘点
    public final static String ALREADY_CHECK = "已盘点";

    // 待盘点
    public final static String WAIT_CHECK = "未盘点";

    // 盘盈
    public final static String CHECK_PROFIT = "盘盈";

    // 盘亏
    public final static String CHECK_LOSS = "盘亏";

    // 盘平
    public final static String CHECK_EQUAL = "盘平";

    // 大单位数量
    public final static String LARGE_NUM = "largeNum";

    // 小单位数量
    public final static String SMALL_NUM = "smallNum";

    // 年月日时分秒 格式
    public final static String YMDHMS = "yyyy-MM-dd HH-mm-ss";

    // 年月日 格式
    public final static String YMD = "yyyy-MM-dd";

    // 分页开始下标
    public final static String START_INDEX = "startIndex";

    // 分页结束下标
    public final static String END_INDEX = "endIndex";
}
