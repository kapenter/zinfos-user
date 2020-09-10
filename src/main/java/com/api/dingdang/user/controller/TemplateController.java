package com.api.dingdang.user.controller;

import com.api.dingdang.user.dto.req.template.TemplateQueryReqDTO;
import com.api.dingdang.user.dto.req.template.TemplateReqDTO;
import com.api.dingdang.user.dto.req.template.TemplateUpdateReqDTO;
import com.api.dingdang.user.dto.resp.template.TemplateQueryResp;
import com.api.dingdang.user.utils.JsonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Api(tags="模板管理模块")
@RequestMapping(value = "/template")
public class TemplateController {


    @PostMapping("/add")
    @ApiOperation(value = "新增模板")
    public JsonResponse add(@RequestBody TemplateReqDTO templateReqDTO){
        return JsonResponse.success();
    }


    @PutMapping("/update")
    @ApiOperation(value = "修改模板")
    public JsonResponse update(@RequestBody TemplateUpdateReqDTO templateUpdateReqDTO){
        return JsonResponse.success();
    }


    @DeleteMapping(value = "/delete/{id}")
    @ApiImplicitParam(name = "id",required=true,value = "模板ID")
    @ApiOperation(value = "模板信息删除")
    public JsonResponse delete(@PathVariable("id") String id){
        return JsonResponse.success();
    }

    @PostMapping("/list")
    @ApiOperation(value = "模板查询")
    public JsonResponse list(@RequestBody TemplateQueryReqDTO templateQueryReqDTO){
        List<TemplateQueryResp> list=new ArrayList<>();
        TemplateQueryResp templateQueryResp=new TemplateQueryResp();
        templateQueryResp.setId(1);
        templateQueryResp.setContext("您的验证码为:10086");
        templateQueryResp.setName("短信模板1");
        templateQueryResp.setNature("顺丰快递");
        templateQueryResp.setCreateTime(new Date());

        TemplateQueryResp templateQueryResp1=new TemplateQueryResp();
        templateQueryResp1.setId(2);
        templateQueryResp1.setContext("您的验证码为:10010");
        templateQueryResp1.setName("短信模板2");
        templateQueryResp1.setNature("圆通快递");
        templateQueryResp1.setCreateTime(new Date());

        list.add(templateQueryResp);
        list.add(templateQueryResp1);
        return JsonResponse.success(list);
    }



}
