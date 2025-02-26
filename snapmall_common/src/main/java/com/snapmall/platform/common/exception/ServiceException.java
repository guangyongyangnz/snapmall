package com.snapmall.platform.common.exception;

import com.snapmall.platform.common.response.StatusEnum;
import lombok.Data;

import java.io.Serial;

/**
 * @author chunming.ygy@gmail.com
 * @date 26/02/2025 22:31
 */
@Data
public class ServiceException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1116867455532704116L;

    private final StatusEnum statusEnum;

    public ServiceException(StatusEnum statusEnum, String message) {
        super(message);
        this.statusEnum = statusEnum;
    }

    public ServiceException(StatusEnum statusEnum) {
        this(statusEnum, statusEnum.msg);
    }
}
