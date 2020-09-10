package com.api.dingdang.user.dto.resp.express;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@Api(value = "快件查询信息")
public class ExpressRecordQueryResp {

    @ApiModelProperty(example = "快件id")
    private Integer id;

    @ApiModelProperty(example = "运单号")
    private String expressNo;

    @ApiModelProperty(example = "手机号")
    private String mobile;

    @ApiModelProperty(example = "货架号")
    private String pickupNo;

    @ApiModelProperty(example = "快件状态 0:已发送，1，接受 2:失败 3:回复")
    private Integer status;

    @ApiModelProperty(example = "发送账号")
    private String account;

    @ApiModelProperty(example = "创建时间")
    private Date createTime;

    @ApiModelProperty(example = "取件时间")
    private Date pickTime;

    @ApiModelProperty(example = "模板Id")
    private Integer templateId;

    @ApiModelProperty(example = "发送方式  1:短信 2:群呼")
    private Integer type;

}
