package com.risk.common.redis;

import com.risk.common.utils.DateTimeHelper;
import redis.clients.jedis.JedisCluster;

import javax.annotation.Resource;
import java.util.Date;

/**
 */

public class BaseRedis {

    @Resource
    private JedisCluster jedisCluster;

    /**
     * 添加缓存对象键值
     *
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        jedisCluster.set(key, value);
    }


    /**
     * 根据指定的关键字获取对象
     *
     * @param key
     * @return
     */
    public String get(String key) {
        String value = jedisCluster.get(key);
        return value;
    }

    /**
     * 指定redis过期时间间隔，单位是“秒”
     *
     * @param key
     * @param seconds
     */
    public void expire(String key, int seconds) {
        jedisCluster.expire(key, seconds);
    }

    /**
     * 指定redis过期时间点，如：默认在23:59:59:999过期
     *
     * @param key
     */
    public void expireAt(String key, Date date) {
        long unixTime = 0;
        if (date == null) {
            unixTime = DateTimeHelper.getRedisExpireTime().getTime();
        } else {
            unixTime = date.getTime();
        }

        jedisCluster.expireAt(key, unixTime/1000);
    }

    /**
     * 删除redis键值
     *
     * @param key
     */
    public void delete(String key) {
        jedisCluster.del(key);
    }

    /**
     * 判断redis键值是否存在
     *
     * @param key
     */
    public boolean exists(String key) {
        return jedisCluster.exists(key);
    }
}
