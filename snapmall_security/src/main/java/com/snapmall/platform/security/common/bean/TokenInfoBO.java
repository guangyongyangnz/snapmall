package com.snapmall.platform.security.common.bean;

import lombok.Data;

/**
 * @author chunming.ygy@gmail.com
 * @date 25/02/2025 21:26
 */
@Data
public class TokenInfoBO {
    private UserInfoInTokenBO userInfoInTokenBO;

    private String accessToken;

    private String refreshToken;

    private Integer expiresIn;
}
