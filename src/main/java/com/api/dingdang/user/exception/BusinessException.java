package com.api.dingdang.user.exception;

import com.api.dingdang.user.exception.enums.BizCodeEnum;

/**
 * @program: zxtcredit-front-service
 * @description:
 * @author: xn086532
 * @create: 2019-06-24 11:48
 **/
public class BusinessException extends RuntimeException {

    private BizCodeEnum bizCode;

    public BusinessException() {
        super();
    }

    public BusinessException(BizCodeEnum bizCodeEnum) {
        super(bizCodeEnum.getMessage());
        this.bizCode = bizCodeEnum;
    }

    public BusinessException(BizCodeEnum bizCodeEnum, String message) {
        super(message);
        this.bizCode = bizCodeEnum;
    }

    public BizCodeEnum getBizCode() {
        return bizCode;
    }
}
