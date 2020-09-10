package com.api.dingdang.user.dto.req.express;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api(value = "快件更新信息")
public class ExpressUpdateReqDTO {

    @ApiModelProperty(example = "快件id",required = true)
    private Integer id ;

    @ApiModelProperty(example = "快件状态",required = true)
    private String status;

    @ApiModelProperty(example = "备注")
    private String remark;

}
