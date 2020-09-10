package com.api.dingdang.user.controller;

import com.api.dingdang.user.dto.req.group.GroupReqDTO;
import com.api.dingdang.user.dto.req.group.GroupUpdateReqDTO;
import com.api.dingdang.user.dto.resp.group.GroupQueryResp;
import com.api.dingdang.user.utils.JsonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags="分组管理模块")
@RequestMapping(value = "/group")
public class GroupController {


    @PostMapping("/add")
    @ApiOperation(value = "新增分组")
    public JsonResponse add(@RequestBody GroupReqDTO groupReqDTO){
        return JsonResponse.success();
    }


    @PutMapping("/update")
    @ApiOperation(value = "修改分组")
    public JsonResponse update(@RequestBody GroupUpdateReqDTO groupUpdateReqDTO){
        return JsonResponse.success();
    }


    @DeleteMapping(value = "/delete/{id}")
    @ApiImplicitParam(name = "id",required=true,value = "分组ID")
    @ApiOperation(value = "删除分组")
    public JsonResponse delete(@PathVariable("id") String id){
        return JsonResponse.success();
    }



    @PostMapping("/list")
    @ApiOperation(value = "分组列表")
    public JsonResponse list(){
        List<GroupQueryResp> list=new ArrayList<>();
        GroupQueryResp groupQueryResp=new GroupQueryResp();
        groupQueryResp.setId(1);
        groupQueryResp.setNature("宝安区分销商");
        groupQueryResp.setUserId(10);
        groupQueryResp.setGroupName("麻布新村");

        GroupQueryResp groupQueryResp1=new GroupQueryResp();
        groupQueryResp1.setId(2);
        groupQueryResp1.setNature("福田区分销商");
        groupQueryResp1.setUserId(10);
        groupQueryResp1.setGroupName("上沙");

        list.add(groupQueryResp1);
        list.add(groupQueryResp);
        return JsonResponse.success(list);
    }

}
