package com.snapmall.platform.common.exception;

import com.snapmall.platform.common.response.ResponseResult;
import com.snapmall.platform.common.response.StatusEnum;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chunming.ygy@gmail.com
 * @date 26/02/2025 22:35
 */
@Slf4j
@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResponseResult<Void> handleServiceExceptioin(ServiceException serviceException, HttpServletRequest request) {
        log.error("request {} throw ServiceExcepton", request, serviceException);
        return ResponseResult.error(serviceException.getStatusEnum());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult<Void> handleException(Exception ex, HttpServletRequest request) {
        log.error("request {} throw Exception", request, ex);
        return ResponseResult.error(StatusEnum.SERVICE_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseResult<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        try {
            List<ObjectError> errorList = ex.getBindingResult().getAllErrors();
            String message = errorList.stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(","));
            log.error("param illegal: {}", message);
            return ResponseResult.error(StatusEnum.INVALID_PARAM, message);
        } catch (Exception e) {
            return ResponseResult.error(StatusEnum.SERVICE_ERROR);
        }
    }

}
