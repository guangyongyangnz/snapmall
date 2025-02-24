package com.snapmall.platform.service.bean;

import java.util.Date;

/**
 * @author chunming.ygy@gmail.com
 * @date 23/02/2025 18:08
 */
public record UserAddrBO(Long id, String userId, String receiver, String province, String city, Long cityId,
                         String area, Long areaId, String postCode, String addr, String mobile, Integer status,
                         Date gmtCreated, Integer version, Date gmtUpdated) {
}
