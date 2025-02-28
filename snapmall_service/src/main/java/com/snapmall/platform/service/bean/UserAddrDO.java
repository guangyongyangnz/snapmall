package com.snapmall.platform.service.bean;

import com.snapmall.platform.dao.bean.UserAddrPO;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Optional;

/**
 * @author chunming.ygy@gmail.com
 * @date 23/02/2025 18:08
 */
@Data
@Builder
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

    public static Optional<UserAddrDO> convertToDO(UserAddrPO userAddrPO) {
        if (userAddrPO == null) {
            return Optional.empty();
        }

        UserAddrDO userAddrDO = UserAddrDO.builder()
                .id(userAddrPO.getId())
                .gmtCreate(userAddrPO.getGmtCreate())
                .gmtModified(userAddrPO.getGmtModified())
                .userId(userAddrPO.getUserId())
                .receiver(userAddrPO.getReceiver())
                .province(userAddrPO.getProvince())
                .city(userAddrPO.getCity())
                .cityId(userAddrPO.getCityId())
                .area(userAddrPO.getArea())
                .areaId(userAddrPO.getAreaId())
                .postCode(userAddrPO.getPostCode())
                .addr(userAddrPO.getAddr())
                .mobile(userAddrPO.getMobile())
                .status(userAddrPO.getStatus())
                .version(userAddrPO.getVersion())
                .build();

        return Optional.of(userAddrDO);
    }
}
