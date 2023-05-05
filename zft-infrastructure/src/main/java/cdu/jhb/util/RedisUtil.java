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
     * 设置Redis
     * @param key
     * @param value
     */
    public static void setRedis(String key,String value){
        Jedis jedis = new Jedis();
        jedis.set(key,value);
    }

    /**
     * 从redis获取当前登录租户ID
     * @return
     */
    public static Long getLocalTenantId(){
        Jedis jedis = new Jedis();
        return Long.valueOf(jedis.get(Constant.TENANT_ID));
    }

    /**
     * 返回字符串
     * @param key
     * @return
     */
    public static String getString(String key){
        Jedis jedis = new Jedis();
        return jedis.get(key);
    }

    /**
     * 返回Long类型
     * @param key
     * @return
     */
    public static Long getLong(String key){
        Jedis jedis = new Jedis();
        return Long.valueOf(jedis.get(key));
    }

    /**
     * 返回Integer类型
     * @param key
     * @return
     */
    public static Integer getInteger(String key){
        Jedis jedis = new Jedis();
        return Integer.valueOf(jedis.get(key));
    }
}
