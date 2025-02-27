package com.snapmall.platform.dao;

import com.snapmall.platform.dao.bean.UserAddrPO;

/**
 * @author chunming.ygy@gmail.com
 * @date 27/02/2025 23:14
 */
public interface UserAddrDAO {

    UserAddrPO getDefaultUserAddr(String userId);

    Boolean removeDefaultUserAddr(String userId);

    Integer setDefaultUserAddr(Long id, String userId);

    UserAddrPO getUserAddrById(Long id);
}
