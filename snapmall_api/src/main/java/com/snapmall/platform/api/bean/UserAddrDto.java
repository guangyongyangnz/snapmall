package com.snapmall.platform.api.bean;

import com.snapmall.platform.common.exception.ServiceException;
import com.snapmall.platform.common.response.StatusEnum;
import com.snapmall.platform.service.bean.UserAddrDO;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

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

    public static UserAddrDto convertToDto(UserAddrDO userAddrDO) {
        if (userAddrDO == null) {
            throw new ServiceException(StatusEnum.INVALID_PARAM_CONVERT);
        }

        UserAddrDto userAddrDto = UserAddrDto.builder()
                .id(userAddrDO.getId())
                .gmtCreate(userAddrDO.getGmtCreate())
                .gmtModified(userAddrDO.getGmtModified())
                .userId(userAddrDO.getUserId())
                .receiver(userAddrDO.getReceiver())
                .province(userAddrDO.getProvince())
                .city(userAddrDO.getCity())
                .cityId(userAddrDO.getCityId())
                .area(userAddrDO.getArea())
                .areaId(userAddrDO.getAreaId())
                .postCode(userAddrDO.getPostCode())
                .addr(userAddrDO.getAddr())
                .mobile(userAddrDO.getMobile())
                .status(userAddrDO.getStatus())
                .version(userAddrDO.getVersion())
                .build();

        return userAddrDto;
    }

}
