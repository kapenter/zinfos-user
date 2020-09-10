package com.api.dingdang.user.dto.req.template;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api(value = "模板新增信息")
public class TemplateQueryReqDTO {

    @ApiModelProperty(example = "模板名称")
    private String name;
}
