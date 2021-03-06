package com.api.dingdang.user.dto.req.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Api(value = "语音发送信息")
@Data
public class NoticeSentReqDTO {

    @ApiModelProperty(example = "1", required = true)
    private Integer tempId;

    @ApiModelProperty(example = "内容", required = true)
    private String contextParam;


    @ApiModelProperty(example = "企业账户", required = true)
    private String company;

    @ApiModelProperty(example = "时间戳", required = true)
    private String keyTime;

    @ApiModelProperty(example = "加密key", required = true)
    private String key;

    @ApiModelProperty(example = "被叫号码", required = true)
    private String callingLine;

    @ApiModelProperty(example = "主叫号码", required = true)
    private String telNo;

    @ApiModelProperty(example = "声音类型")
    private String sex;

    @ApiModelProperty(example = "快件id", required = true)
    private String expressId;

    @ApiModelProperty(example = "用户id", required = true)
    private String userId;


    @ApiModelProperty(example = "ivr参数")
    private String ivr;

    @ApiModelProperty(example = "绑定ip", required = true)
    private String svBip;

    @ApiModelProperty(example = "播报次数")
    private String playNum;
}
