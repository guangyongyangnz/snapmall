package com.snapmall.platform.service.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author chunming.ygy@gmail.com
 * @date 23/02/2025 18:08
 */
@Data
public class UserAddrDO {

    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String userId;

    private String receiver;

    private String province;

    private String city;

    private Long cityId;

    private String area;

    private Long areaId;

    private String postCode;

    private String addr;

    private String mobile;

    private Integer status;

    private Integer version;
}
