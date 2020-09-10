package com.api.dingdang.user.dto.req.template;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api(value = "模板修改信息")
public class TemplateUpdateReqDTO {

    @ApiModelProperty(example = "模板id",required = true)
    private Integer id;

    @ApiModelProperty(example = "模板名称")
    private String name;

    @ApiModelProperty(example = "模板内容")
    private String context;

    @ApiModelProperty(example = "签名")
    private String signature;
}
