package com.api.dingdang.user.dto.req.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserLoginReqDTO {

    @NotNull(message = "手机号码不能为空")
    @ApiModelProperty(example = "手机号码",required = true)
    private String  mobile;

    @NotNull(message = "密码不能为空")
    @ApiModelProperty(example = "密码",required = true)
    private  String  password;
}
