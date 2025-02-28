package com.snapmall.platform.dao;

import com.snapmall.platform.dao.bean.UserAddrPO;

import java.util.List;

/**
 * @author chunming.ygy@gmail.com
 * @date 27/02/2025 23:14
 */
public interface UserAddrDAO {

    Boolean insert(UserAddrPO userAddrPO);

    List<UserAddrPO> getUserAddr(UserAddrPO userAddrPO);

    Integer updateUserAddr(UserAddrPO userAddrPO);

    Integer deleteUserAddr(Long id);
}
