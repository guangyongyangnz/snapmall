package com.snapmall.platform.service.impl;

import com.snapmall.platform.service.UserAddrService;
import com.snapmall.platform.service.bean.UserAddrDO;
import org.springframework.stereotype.Service;

/**
 * @author chunming.ygy@gmail.com
 * @date 27/02/2025 23:13
 */
@Service
public class UserAddrServiceImpl implements UserAddrService {

    @Override
    public UserAddrDO getDefaultUserAddr(String userId) {
        return null;
    }

    @Override
    public void updateDefaultUserAddr(Long id, String userId) {

    }

    @Override
    public UserAddrDO getUserAddrById(Long id, String userId) {
        return null;
    }
}
