package com.snapmall.platform.common.response;

/**
 * @author chunming.ygy@gmail.com
 * @date 26/02/2025 22:25
 */
public enum StatusEnum {
    SUCCESS("200", "success"),
    UNAUTHORIZED("401", "authorized failed"),
    FORBIDDEN("403", "forbidded"),
    SERVICE_ERROR("500", "server error"),
    INVALID_PARAM("1000", "invalid parameter"),
    INVALID_PARAM_CONVERT("1001", "invalid parameter convert"),

    ;

    public final String code;

    public final String msg;


    StatusEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
