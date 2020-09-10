package com.api.dingdang.user.dto.req.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserRegReqDTO {


    @NotNull
    @ApiModelProperty(example = "驿站名称",required=true)
    private String stationName;

    /**
     * 手机号
     */
    @NotNull
    @ApiModelProperty(example = "用户手机号码",required=true)
    private String mobile;
    /**
     * 地址
     */
    @NotNull
    @ApiModelProperty(example = "地址",required=true)
    private String address;
    /**
     * 密码
     */
    @NotNull
    @ApiModelProperty(example = "密码",required=true)
    private String password;
}
