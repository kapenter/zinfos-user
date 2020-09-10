package com.api.dingdang.user.dto.req.express;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api(value = "快件信息")
public class ExpressReqDTO {

    @ApiModelProperty(example = "运单号",required = true)
    private String expressNo;

    @ApiModelProperty(example = "手机号",required = true)
    private String mobile;

    @ApiModelProperty(example = "货架号",required = true)
    private String pickupNo;


}
