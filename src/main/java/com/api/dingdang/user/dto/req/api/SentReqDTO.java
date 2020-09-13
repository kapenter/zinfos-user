package com.api.dingdang.user.dto.req.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api(value = "发送内容")
public class SentReqDTO {
    @ApiModelProperty(example = "0", required = true,value = "货架号模式")
    private Integer itemNumberMode;

    @ApiModelProperty(example = "0", required = true,value = "货架号模式 0:草稿 1:定时")
    private Integer type;

    @ApiModelProperty(example = "0", required = true,value = "货架号模式 0:不开启群呼 1:开启群呼")
    private Integer openCall;

    @ApiModelProperty(example = "1", required = true,value = "模板id")
    private Integer tempId;

    @ApiModelProperty(example = "1", required = true,value = "发送类型 0:短信发送 1:语音发送")
    private Integer sentType;
}
