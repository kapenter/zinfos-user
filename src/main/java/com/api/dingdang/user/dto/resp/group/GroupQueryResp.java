package com.api.dingdang.user.dto.resp.group;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class GroupQueryResp {
    @ApiModelProperty(example = "id")
    private Integer id;

    @ApiModelProperty(example = "所属账户")
    private String groupName;

    @ApiModelProperty(example = "所属用户ID")
    private Integer userId;

    @ApiModelProperty(example = "所属账户")
    private String nature;

    @ApiModelProperty(example = "创建时间")
    private Date createTime;

    @ApiModelProperty(example = "修改时间")
    private Date modifyTime;
}
