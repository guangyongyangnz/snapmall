package com.snapmall.platform;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
@MapperScan("com.snapmall.platform.dao")
@Slf4j
public class ApiApplication {
    public static void main(String[] args) {
        log.info("ApiApplication Starting.....");
        SpringApplication.run(ApiApplication.class, args);
    }
}
