package com.api.dingdang.user.controller;

import com.api.dingdang.user.exception.BusinessException;
import com.api.dingdang.user.exception.enums.NormalExceptionEnum;
import com.api.dingdang.user.utils.JsonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BindException.class)
    public Object validExceptionHandler(BindException e){
        FieldError fieldError = e.getBindingResult().getFieldError();
        assert fieldError != null;
        log.error(fieldError.getField() + ":" + fieldError.getDefaultMessage());
        // 将错误的参数的详细信息封装到统一的返回实体
        return  JsonResponse.failure(NormalExceptionEnum.PARAM_EXCEPTION.getCode(),fieldError.getDefaultMessage()) ;
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object validExceptionHandler(MethodArgumentNotValidException e){
        FieldError fieldError = e.getBindingResult().getFieldError();
        assert fieldError != null;
        log.error(fieldError.getField() + ":" + fieldError.getDefaultMessage());
        return JsonResponse.failure(NormalExceptionEnum.PARAM_EXCEPTION.getCode(),fieldError.getDefaultMessage()) ;
    }

    @ExceptionHandler(Throwable.class)
    JsonResponse handleException(Throwable throwable){
        if(throwable instanceof  NullPointerException ){
            return  JsonResponse.failure(NormalExceptionEnum.PARAM_EXCEPTION.getCode(),throwable.getMessage());
        }if(throwable instanceof BusinessException){
            BusinessException businessException=(BusinessException)throwable;
            return JsonResponse.failure(businessException.getBizCode().getCode(),businessException.getMessage()) ;
        }
        log.error("异常信息:{}",throwable);
        return    JsonResponse.failure(NormalExceptionEnum.SYSTEM_EXCEPTION.getCode(), NormalExceptionEnum.SYSTEM_EXCEPTION.getMessage()) ;
    }
}
