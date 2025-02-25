package com.snapmall.platform.security.common.bean;

import lombok.Data;

import java.util.Set;

/**
 * @author chunming.ygy@gmail.com
 * @date 25/02/2025 21:15
 */
@Data
public class UserInfoInTokenBO {

    private String userId;

    private String openId;

    private String userType;

    private Boolean isEnabled;

    private Long shopId;

    private String nickName;

    /**
     * @see com.snapmall.platform.security.common.enums.SysTypeEnum
     */
    private Integer sysType;

    private Boolean isAdmin;

    private String bizUserId;

    private Set<String> perms;

    private Long otherId;
}
