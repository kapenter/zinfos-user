package com.api.dingdang.user.dto.req.group;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GroupReqDTO {

    @ApiModelProperty(example = "分组名称" ,required = true)
    private String groupName;


}
