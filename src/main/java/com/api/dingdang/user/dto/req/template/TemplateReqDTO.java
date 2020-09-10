package com.api.dingdang.user.dto.req.template;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api(value = "模板新增信息")
public class TemplateReqDTO {

    @ApiModelProperty(example = "模板名称",required = true)
    private String name;

    @ApiModelProperty(example = "模板内容",required = true)
    private String context;

    @ApiModelProperty(example = "签名",required = true)
    private String signature;
}
