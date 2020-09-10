package com.api.dingdang.user.dto.req.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserUpdateReqDTO {

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
