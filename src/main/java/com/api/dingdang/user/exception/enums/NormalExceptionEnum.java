package com.api.dingdang.user.exception.enums;


import lombok.Getter;

/**
 * @program: zxtcredit-front-service
 * @description:
 * @author: xn086532
 * @create: 2019-06-24 13:44
 **/
@Getter
public enum NormalExceptionEnum {
    PARAM_EXCEPTION("400","参数异常") ,
    PAGE_NOT_FOUND_ERROR("404","SYSTEM_FORBIDDEN") ,
    SYSTEM_EXCEPTION("500","系统异常")
            ;

    private String code;
    private String message;
    NormalExceptionEnum(String code,String message){
        this.code = code;
        this.message = message;
    }


}
