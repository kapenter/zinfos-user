package com.api.dingdang.user.controller;

import com.api.dingdang.user.dto.req.api.NoticeSentReqDTO;
import com.api.dingdang.user.dto.req.api.SmsSentReqDTO;
import com.api.dingdang.user.utils.JsonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags="通知管理模块")
public class ApiSentController {


    @PostMapping("/smsApi/sent")
    @ApiOperation(value = "短信发送")
    public JsonResponse add(@RequestBody SmsSentReqDTO smsSentReqDTO){
        return JsonResponse.success();
    }


    @PostMapping("/noticeApi/sent")
    @ApiOperation(value = "语音发送")
    public JsonResponse update(@RequestBody NoticeSentReqDTO noticeSentReqDTO){
        return JsonResponse.success();
    }



}
