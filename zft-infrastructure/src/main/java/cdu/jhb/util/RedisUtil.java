package cdu.jhb.util;

import cdu.jhb.common.Constant;
import redis.clients.jedis.Jedis;

/**
* @description: Redis工具类
* @author jhb
* @date 2023/04/15 15:19
* @version 1.0
*/
public class RedisUtil {
    /**
     * 从redis获取当前登录租户ID
     * @return
     */
    public static Long getLocalTenantId(){
        Jedis jedis = new Jedis();
        return Long.valueOf(jedis.get(Constant.TENANT_ID));
    }
}
