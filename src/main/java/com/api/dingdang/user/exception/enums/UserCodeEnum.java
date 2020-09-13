package com.api.dingdang.user.exception.enums;

import lombok.Getter;

@Getter
public enum UserCodeEnum {

   LOGIN_EXCEPTION("80810001","用户名或密码错误")
            ;
    private String code;
    private String message;
    UserCodeEnum(String code,String message){
        this.code = code;
        this.message = message;
    }
}
