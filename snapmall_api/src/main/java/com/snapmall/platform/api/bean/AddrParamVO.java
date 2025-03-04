package com.snapmall.platform.api.bean;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author chunming.ygy@gmail.com
 * @date 04/03/2025 22:56
 */
@Data
public class AddrParamVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 4029464733097380752L;

    private Long id;

    @NotEmpty(message = "receiver cannot be empty")
    private String receiver;

    @NotEmpty(message = "addr cannot be empty")
    private String addr;

    private String postCode;

    @NotEmpty(message = "mobile cannot be empty")
    private String mobile;

    @NotNull(message = "provinceId cannot be null")
    private Long provinceId;

    @NotNull(message = "cityId cannot be null")
    private Long cityId;

    @NotNull(message = "areaId cannot be null")
    private Long areaId;

    @NotEmpty(message = "province cannot be empty")
    private String province;

    @NotEmpty(message = "city cannot be empty")
    private String city;

    @NotEmpty(message = "area cannot be empty")
    private String area;
}
