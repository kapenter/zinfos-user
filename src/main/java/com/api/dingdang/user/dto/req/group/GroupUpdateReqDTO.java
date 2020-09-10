package com.api.dingdang.user.dto.req.group;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api("分组修改信息")
public class GroupUpdateReqDTO {

    @ApiModelProperty(example = "分组id",required = true)
    private Integer id ;

    @ApiModelProperty(example = "分组名称" ,required = true)
    private String groupName;


}
