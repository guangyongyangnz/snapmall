package com.snapmall.platform.api.controller;

import com.snapmall.platform.service.UserAddrService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chunming.ygy@gmail.com
 * @date 23/02/2025 17:23
 */
@RestController
@RequestMapping("/p/address")
public class AddrController {

    private UserAddrService userAddrService;

    public AddrController(UserAddrService userAddrService) {
        this.userAddrService = userAddrService;
    }


    public ResponseResult<List<UserAddr>>
}
