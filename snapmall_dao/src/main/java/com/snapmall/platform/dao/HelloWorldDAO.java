package com.snapmall.platform.dao;

import com.snapmall.platform.dao.bean.HelloWorldPO;

import java.util.List;

/**
 * @author chunming.ygy@gmail.com
 * @date 23/02/2025 13:51
 */
public interface HelloWorldDAO {
    List<HelloWorldPO> queryList();
}
