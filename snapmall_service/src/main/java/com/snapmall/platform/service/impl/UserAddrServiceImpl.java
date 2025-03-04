package com.snapmall.platform.service.impl;

import com.snapmall.platform.dao.UserAddrDAO;
import com.snapmall.platform.dao.bean.UserAddrPO;
import com.snapmall.platform.service.UserAddrService;
import com.snapmall.platform.service.bean.UserAddrDO;
import com.snapmall.platform.service.enums.StatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author chunming.ygy@gmail.com
 * @date 27/02/2025 23:13
 */
@Slf4j
@Service
public class UserAddrServiceImpl implements UserAddrService {

    private UserAddrDAO userAddrDAO;

    public UserAddrServiceImpl(UserAddrDAO userAddrDAO) {

        this.userAddrDAO = userAddrDAO;
    }

    @Override
    public List<UserAddrDO> getUserAddrs(String userId) {

        return null;
    }

    @Override
    public Optional<UserAddrDO> getDefaultUserAddr(String userId) {
        UserAddrPO userAddrQuery = new UserAddrPO();
        userAddrQuery.setUserId(userId);
        userAddrQuery.setIsDefaultAddr(StatusEnum.TRUE.getCode());
        List<UserAddrPO> userAddrList = userAddrDAO.getUserAddrs(userAddrQuery);

        if (CollectionUtils.isEmpty(userAddrList)) {
            log.warn("getDefaultUserAddr, no data, userId:{}", userId);
            return Optional.empty();
        }

        return UserAddrDO.convertToDO(userAddrList.get(0));
    }

    @Override
    public void updateDefaultUserAddr(Long id, String userId) {
        UserAddrPO userAddrQuery = new UserAddrPO();
        userAddrQuery.setId(id);
        List<UserAddrPO> userAddrList = userAddrDAO.getUserAddrs(userAddrQuery);
        if (CollectionUtils.isEmpty(userAddrList)) {
            log.warn("updateDefaultUserAddr, no data, id:{}", id);
        }

        UserAddrPO userAddrPO = userAddrList.get(0);
        userAddrPO.setIsDefaultAddr(StatusEnum.TRUE.getCode());
        if (userAddrDAO.updateUserAddr(userAddrPO) <= 0) {
            log.error("updateDefaultUserAddr, updateUserAddr error. userId:{}", userId);
        }
    }

    @Override
    public Optional<UserAddrDO> getUserAddrById(Long id) {
        UserAddrPO userAddrQuery = new UserAddrPO();
        userAddrQuery.setId(id);
        List<UserAddrPO> userAddrList = userAddrDAO.getUserAddrs(userAddrQuery);

        if (CollectionUtils.isEmpty(userAddrList)) {
            log.warn("getDefaultUserAddr, no data, id:{}", id);
            return Optional.empty();
        }

        return UserAddrDO.convertToDO(userAddrList.get(0));
    }
}
