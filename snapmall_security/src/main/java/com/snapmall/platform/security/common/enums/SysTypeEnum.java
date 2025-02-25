package com.snapmall.platform.security.common.enums;

/**
 * @author chunming.ygy@gmail.com
 * @date 25/02/2025 21:23
 */
public enum SysTypeEnum {

    ORDINARY(0),

    ADMIN(1);

    SysTypeEnum(Integer value) {
        this.value = value;
    }

    private final Integer value;

    public Integer getValue() {
        return value;
    }
}
