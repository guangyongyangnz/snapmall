package com.snapmall.platform.service;

import com.snapmall.platform.service.bean.UserAddrDO;

/**
 * @author chunming.ygy@gmail.com
 * @date 23/02/2025 17:27
 */
public interface UserAddrService {

    UserAddrDO getDefaultUserAddr(String userId);

    void updateDefaultUserAddr(Long id, String userId);

    UserAddrDO getUserAddrById(Long id, String userId);

}
