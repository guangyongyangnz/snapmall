package com.snapmall.platform.common.response;

import lombok.Data;

/**
 * @author chunming.ygy@gmail.com
 * @date 26/02/2025 22:20
 */
@Data
public class ResponseResult<T> {

    private String code;

    private String msg;

    private T data;

    public static <T> ResponseResult<T> success(T data) {
        ResponseResult<T> response = new ResponseResult<>();
        response.setData(data);
        response.setCode(StatusEnum.SUCCESS.code);
        return response;
    }

    public static <T> ResponseResult<T> error(StatusEnum statusEnum, String errorMsg) {
        ResponseResult<T> response = new ResponseResult<>();
        response.setCode(statusEnum.code);
        response.setMsg(errorMsg);
        return response;
    }

    public static <T> ResponseResult<T> error(StatusEnum statusEnum) {
        return error(statusEnum, statusEnum.msg);
    }

}
