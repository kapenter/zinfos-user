package com.api.dingdang.user.dto.req.express;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api(value = "快件信息")
public class ExpressQueryReqDTO {

    @ApiModelProperty(example = "运单号")
    private String expressNo;

    @ApiModelProperty(example = "手机号")
    private String mobile;

    @ApiModelProperty(example = "货架号")
    private String pickupNo;


}
