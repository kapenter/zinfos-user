package com.api.dingdang.user.dto.req.express;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api(value = "快件信息")
public class ExpressRecordQueryReqDTO {

    @ApiModelProperty(example = "开始时间")
    private String startTime;

    @ApiModelProperty(example = "结束时间")
    private String endTime;

    @ApiModelProperty(example = "发送方式 1:短信 2:群呼")
    private Integer type;

    @ApiModelProperty(example = "发送状态 0:已发送，1，接受 2:失败 3:回复")
    private Integer status;

}
