package com.snapmall.platform.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author chunming.ygy@gmail.com
 * @date 24/02/2025 21:53
 */
@Slf4j
public class RedisUtil {
    private static RedisTemplate<String, Object> redisTemplate =
        SpringContextUtil.getBean("redisTemplate", RedisTemplate.class);

    public static final StringRedisTemplate STRING_REDIS_TEMPLATE =
        SpringContextUtil.getBean("stringRedisTemplate", StringRedisTemplate.class);

    /**
     * set cache expire time
     *
     * @param key
     * @param time
     *            (second)
     * @return
     */
    public static boolean expire(String key, Long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }

            return true;
        } catch (Exception e) {
            log.error("set cache error. key:{}", key, e);
        }

        return false;
    }

    /**
     * get cache time with key
     *
     * @param key
     *            (second)
     * @return
     */
    public static Long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    public static boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            log.error("haskey error. key:{}", key, e);
        }

        return false;
    }

    public static void deleteKey(String... keys) {
        Optional.ofNullable(keys).filter(arr -> arr.length > 0)
            .map(arr -> arr.length == 1 ? List.of(arr[0]) : Arrays.asList(arr)).ifPresent(redisTemplate::delete);
    }

    public static <T> T get(String key) {
        return key == null ? null : (T) redisTemplate.opsForValue().get(key);
    }

    public static boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            log.error("set cache error. key: {}, value: {}", key, value, e);
        }

        return false;
    }

    public static boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Long incr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("delta must greater than 0.");
        }
        return STRING_REDIS_TEMPLATE.opsForValue().increment(key, delta);
    }

    public static Long decr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        return STRING_REDIS_TEMPLATE.opsForValue().increment(key, -delta);
    }

}
