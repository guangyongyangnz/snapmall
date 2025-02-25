package com.snapmall.platform.security.api.model;

import lombok.Data;

/**
 * @author chunming.ygy@gmail.com
 * @date 25/02/2025 20:55
 */
@Data
public class User {

    private String userId;

    private String userType;

    private String openId;

    private String bizUserId;

    private Boolean isEnabled;

    private Long stationId;

    private Long shopId;
}
