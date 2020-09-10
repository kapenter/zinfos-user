package com.api.dingdang.user.dto.resp.user;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api(value = "个人用户信息")
public class UserQueryResp {

    @ApiModelProperty(example = "用户性别")
    private Integer sex;

    @ApiModelProperty(example = "用户图片")
    private String userFace ;

    @ApiModelProperty(example = "用户所在区")
    private String userArea;

    @ApiModelProperty(example = "用户地址")
    private String address;

    @ApiModelProperty(example = "用户id")
    private Integer id ;
}
