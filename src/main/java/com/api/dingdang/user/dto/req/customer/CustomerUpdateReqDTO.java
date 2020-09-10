package com.api.dingdang.user.dto.req.customer;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerUpdateReqDTO {

    @ApiModelProperty(example = "客户id",required = true)
    private Integer id ;

    @ApiModelProperty(example = "分组ID")
    private Integer groupId;

    @ApiModelProperty(example = "用户手机号码", required = true)
    private String mobile;

    @ApiModelProperty(example = "客户名称", required = true)
    private String name;

    @ApiModelProperty(example = "备注")
    private String remark;
}
