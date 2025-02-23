package com.snapmall.platform.service.impl;

import com.snapmall.platform.dao.HelloWorldDAO;
import com.snapmall.platform.service.HelloWorldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author chunming.ygy@gmail.com
 * @date 21/02/2025 22:28
 */
@Slf4j
@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    private final HelloWorldDAO helloWorldDAO;

    public HelloWorldServiceImpl(HelloWorldDAO helloWorldDAO) {
        this.helloWorldDAO = helloWorldDAO;
    }


    @Override
    public String hello() {
        log.info("hello");
        return helloWorldDAO.queryList().stream().findFirst().get().getName();
    }
}
