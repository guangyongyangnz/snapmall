package com.snapmall.platform.security.common.manager;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSON;
import com.snapmall.platform.common.constants.OauthCacheNamesConstant;
import com.snapmall.platform.common.exception.ServiceException;
import com.snapmall.platform.common.response.StatusEnum;
import com.snapmall.platform.security.common.bean.TokenInfoBO;
import com.snapmall.platform.security.common.bean.UserInfoInTokenBO;
import com.snapmall.platform.security.common.enums.SysTypeEnum;
import jodd.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author chunming.ygy@gmail.com
 * @date 26/02/2025 21:21
 */
@Slf4j
@Component
public class TokenStore {

    private final RedisTemplate<String, Object> redisTemplate;

    public TokenStore(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public TokenInfoBO storeAccessToken(UserInfoInTokenBO userInfoInTokenBO) {
        int timeoutSecond = getExpiresIn(userInfoInTokenBO.getSysType());
        String uid = getUid(userInfoInTokenBO.getSysType().toString(), userInfoInTokenBO.getUserId());
        StpUtil.login(uid, timeoutSecond);
        String token = StpUtil.getTokenValue();
        String keyName = OauthCacheNamesConstant.USER_INFO + token;
        redisTemplate.delete(keyName);
        redisTemplate.opsForValue().set(keyName, JSON.toJSONString(userInfoInTokenBO), timeoutSecond, TimeUnit.SECONDS);

        TokenInfoBO tokenInfoBO = new TokenInfoBO();
        tokenInfoBO.setUserInfoInTokenBO(userInfoInTokenBO);
        tokenInfoBO.setExpiresIn(timeoutSecond);
        tokenInfoBO.setAccessToken(token);
        tokenInfoBO.setRefreshToken(token);
        return tokenInfoBO;
    }

    public UserInfoInTokenBO getUserInfoByAccessToken(String accessToken, boolean needDecrypt) {
        if (StringUtil.isEmpty(accessToken)) {
            throw new ServiceException(StatusEnum.UNAUTHORIZED);
        }

        String keyName = OauthCacheNamesConstant.USER_INFO + accessToken;
        Object redisCache = redisTemplate.opsForValue().get(keyName);
        if (redisCache == null) {
            throw new ServiceException(StatusEnum.UNAUTHORIZED);
        }

        return JSON.parseObject(redisCache.toString(), UserInfoInTokenBO.class);
    }

    private int getExpiresIn(int sysType) {
        int expiresIn = 3600;
        if (Objects.equals(sysType, SysTypeEnum.ORDINARY.getValue())) {
            expiresIn = expiresIn * 24 * 30;
        }

        if (Objects.equals(sysType, SysTypeEnum.ADMIN.getValue())) {
            expiresIn = expiresIn * 24 * 30;
        }

        return expiresIn;
    }

    private String getUid(String sysType, String userId) {
        return sysType + ":" + userId;
    }

}
