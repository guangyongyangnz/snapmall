package com.snapmall.platform.service;

import com.snapmall.platform.service.bean.UserAddrDO;

import java.util.Optional;

/**
 * @author chunming.ygy@gmail.com
 * @date 23/02/2025 17:27
 */
public interface UserAddrService {

    Optional<UserAddrDO> getDefaultUserAddr(String userId);

    void updateDefaultUserAddr(Long id, String userId);

    Optional<UserAddrDO> getUserAddrById(Long id);

}
