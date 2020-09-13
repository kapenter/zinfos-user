package com.api.dingdang.user.utils;

import com.api.dingdang.user.constants.ResultEnums;
import com.api.dingdang.user.exception.enums.UserCodeEnum;
import lombok.Data;


@Data
public class JsonResponse {

    private  String  code ;

    private  String  message;

    private  Object data;

    private JsonResponse() {
    }

    public static JsonResponse success(Object obj){
        JsonResponse jsonResponse=new JsonResponse();
        jsonResponse.setCode(ResultEnums.SUCCESS.getCode());
        jsonResponse.setMessage(ResultEnums.SUCCESS.getValue());
        jsonResponse.setData(obj);
        return jsonResponse;
    }


    public static JsonResponse success(){
        JsonResponse jsonResponse=new JsonResponse();
        jsonResponse.setCode(ResultEnums.SUCCESS.getCode());
        jsonResponse.setMessage(ResultEnums.SUCCESS.getValue());
        return jsonResponse;
    }

    public static JsonResponse failure(String code,String message){
        JsonResponse jsonResponse=new JsonResponse();
        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        return jsonResponse;
    }

    public static JsonResponse failure(UserCodeEnum userCodeEnum){
        JsonResponse jsonResponse=new JsonResponse();
        jsonResponse.setCode(userCodeEnum.getCode());
        jsonResponse.setMessage(userCodeEnum.getMessage());
        return jsonResponse;
    }

}
