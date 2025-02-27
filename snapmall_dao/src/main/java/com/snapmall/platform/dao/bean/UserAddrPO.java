package com.snapmall.platform.dao.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author chunming.ygy@gmail.com
 * @date 27/02/2025 23:14
 */
@Data
public class UserAddrPO implements Serializable {

    @Serial
    private static final long serialVersionUID = -5358098297982995929L;

    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;

    private String userId;

    private String receiver;

    private Long provinceId;

    private String province;

    private String city;

    private Long cityId;

    private String area;

    private Long areaId;

    private String postCode;

    private String addr;

    private String mobile;

    private Integer status;

    private Integer isDefaultAddr;

    private Integer version;
}
