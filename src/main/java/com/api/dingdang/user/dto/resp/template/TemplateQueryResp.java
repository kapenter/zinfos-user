package com.api.dingdang.user.dto.resp.template;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class TemplateQueryResp {

    @ApiModelProperty(example = "模板id")
    private Integer id;

    @ApiModelProperty(example = "模板名称")
    private String name;

    @ApiModelProperty(example = "模板内容")
    private String context;

    @ApiModelProperty(example = "签名")
    private String signature;

    @ApiModelProperty(example = "模板类型")
    private Integer sort;

    @ApiModelProperty(example = "所属企业")
    private String nature;

    @ApiModelProperty(example = "创建时间")
    private Date createTime;

}


