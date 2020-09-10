package com.api.dingdang.user.dto.req.customer;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerQueryReqDTO {

    @ApiModelProperty(example = "用户手机号码", required = true)
    private String mobile;

    @ApiModelProperty(example = "客户名称", required = true)
    private String name;

}
