package com.snapmall.platform.api.controller;

import com.google.common.collect.Lists;
import com.snapmall.platform.api.bean.AddrParamVO;
import com.snapmall.platform.api.bean.UserAddrDto;
import com.snapmall.platform.common.response.ResponseResult;
import com.snapmall.platform.security.api.util.SecurityUtil;
import com.snapmall.platform.service.UserAddrService;
import com.snapmall.platform.service.bean.UserAddrDO;
import jakarta.validation.Valid;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/list")
    public ResponseResult<List<UserAddrDto>> fetchAllUserAddrs() {
        String userId = SecurityUtil.getUser().getUserId();
        List<UserAddrDO> userAddrDOList = userAddrService.getUserAddrs(userId);
        if (CollectionUtils.isEmpty(userAddrDOList)) {
            return ResponseResult.success(Lists.newArrayList());
        }

        List<UserAddrDto> userAddrDtoList =
            userAddrDOList.stream().map(UserAddrDto::convertToDto).collect(Collectors.toList());
        return ResponseResult.success(userAddrDtoList);
    }

    @PostMapping("/addAddr")
    public ResponseResult<String> addAddr(@Valid @RequestBody AddrParamVO addrParamVO) {
        String userId = SecurityUtil.getUser().getUserId();

        return ResponseResult.success("");
    }

}
