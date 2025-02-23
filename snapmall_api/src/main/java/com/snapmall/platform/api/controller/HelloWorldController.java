package com.snapmall.platform.api.controller;

import com.snapmall.platform.service.HelloWorldService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chunming.ygy@gmail.com
 * @date 21/02/2025 22:39
 */
@RestController
@RequestMapping("/api/")
public class HelloWorldController {
    private final HelloWorldService helloWorldService;

    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping("hello_world")
    public String helloWorld() {
        return helloWorldService.hello();
    }
}
