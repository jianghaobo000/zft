package cdu.jhb.common;

/**
* @description: TODO
* @author jhb
* @date 2023/04/15 15:27
* @version 1.0
*/
public class DictException {

    public final static String COUNTRY_CODE_NOT_EXIST = "当前国家码不存在！";

    public final static String ACCOUNT_NOT_EXIST = "当前账号不存在！";

    public final static String VALID_CODE_ERROR = "输入验证码错误！";

    public final static String ACCOUNT_PASSWORD_ERROR = "输入账号或密码错误！";

    public final static String BOOK_INVENTORY_CHANGE = "账面库存已经变动，盘点单无效";

    public final static String UPDATE_PRODUCT_ENABLE_FAILED = "更改商品状态失败，请刷新重试";

    public final static String INSERT_TENANT_FAILED = "添加诊所信息失败";

    public final static String UPDATE_TENANT_FAILED = "修改诊所信息失败";

    public final static String DELETE_EMPLOYEE_FAILED = "删除员工详情失败";

    public final static String DELETE_ACCOUNT_FAILED = "删除账号详情失败";

    public final static String DELETE_PRACTICE_FAILED = "删除执业详情失败";

    public final static String DELETE_DEPARTMENT_FAILED = "删除科室详情失败";

    public final static String DELETE_EQUIPMENT_FAILED = "删除设备详情失败";
}
