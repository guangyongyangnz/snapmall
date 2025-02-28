package com.snapmall.platform.api.bean;

import com.snapmall.platform.dao.bean.UserAddrPO;
import com.snapmall.platform.service.bean.UserAddrDO;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Optional;

/**
 * @author chunming.ygy@gmail.com
 * @date 28/02/2025 22:55
 */
@Data
@Builder
public class UserAddrDto {

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

    public static Optional<UserAddrDto> convertToDO(UserAddrBO userAddrBO) {
        if (userAddrBO == null) {
            return Optional.empty();
        }

        UserAddrDto userAddrDto = UserAddrDO.builder()
                .id(userAddrBO.getId())
                .gmtCreate(userAddrBO.getGmtCreate())
                .gmtModified(userAddrBO.getGmtModified())
                .userId(userAddrBO.getUserId())
                .receiver(userAddrBO.getReceiver())
                .province(userAddrBO.getProvince())
                .city(userAddrBO.getCity())
                .cityId(userAddrBO.getCityId())
                .area(userAddrBO.getArea())
                .areaId(userAddrBO.getAreaId())
                .postCode(userAddrBO.getPostCode())
                .addr(userAddrBO.getAddr())
                .mobile(userAddrBO.getMobile())
                .status(userAddrBO.getStatus())
                .version(userAddrBO.getVersion())
                .build();

        return Optional.of(userAddrDto);
    }

}
