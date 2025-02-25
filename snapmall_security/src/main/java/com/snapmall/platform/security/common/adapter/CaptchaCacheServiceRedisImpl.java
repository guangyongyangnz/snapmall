package com.snapmall.platform.security.common.adapter;

import com.anji.captcha.service.CaptchaCacheService;

/**
 * @author chunming.ygy@gmail.com
 * @date 24/02/2025 21:30
 */
public class CaptchaCacheServiceRedisImpl implements CaptchaCacheService {

    @Override
    public void set(String s, String s1, long l) {

    }

    @Override
    public boolean exists(String s) {
        return false;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public String get(String s) {
        return null;
    }

    @Override
    public String type() {
        return null;
    }
}
