package com.api.dingdang.user.dto.req.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserLoginVerifyReqDTO {
    @ApiModelProperty(example = "手机号码",required = true)
    private String mobile;
    @ApiModelProperty(example = "验证码",required = true)
    private String verifyCode;
}
