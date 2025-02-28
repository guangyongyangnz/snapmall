package com.snapmall.platform.service.enums;

/**
 * @author chunming.ygy@gmail.com
 * @date 28/02/2025 22:24
 */
public enum StatusEnum {
    FALSE(0, "false"),

    TRUE(1, "true");

    StatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
