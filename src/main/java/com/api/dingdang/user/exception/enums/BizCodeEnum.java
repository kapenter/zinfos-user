package com.api.dingdang.user.exception.enums;

import lombok.Getter;

/**
 * @description:
 * @author: xn086532
 * @create: 2019-06-24 11:49
 **/
@Getter
public enum BizCodeEnum {

    SERVICE_EXCEPTION("10003","服务异常[S]"),
    RPC_CALL_EXCEPTION("5205001","调用商户验签接口异常"),
    PARAM_SIGN_EXCEPTION("5205002","参数(signature)-签名-错误"),
    PARAM_SIGNATURENONCE_EXCEPTION("5205003","参数(signatureNonce)-签名-错误"),
    PARAM_FORMAT_EXCEPTION("5205004","参数(format)-语言类型-错误"),
    PARAM_SIGNATURE_METHOD_EXCEPTION("5205005","参数(signatureMethod)-签名方式-错误"),
    SIGN_FAIL("10003","签名错误");
    private String code;
    private String message;
    BizCodeEnum(String code,String message){
        this.code = code;
        this.message = message;
    }


}
