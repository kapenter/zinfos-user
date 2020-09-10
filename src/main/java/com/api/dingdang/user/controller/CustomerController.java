package com.api.dingdang.user.controller;

import com.api.dingdang.user.dto.req.customer.CustomerQueryReqDTO;
import com.api.dingdang.user.dto.req.customer.CustomerReqDTO;
import com.api.dingdang.user.dto.req.customer.CustomerUpdateReqDTO;
import com.api.dingdang.user.dto.resp.customer.CustomerQueryResp;
import com.api.dingdang.user.utils.JsonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags="客户管理模块")
@RequestMapping(value = "/customer")
public class CustomerController {


    @PostMapping("/add")
    @ApiOperation(value = "客户新增")
    public JsonResponse add(@RequestBody CustomerReqDTO customerReqDTO){
        return JsonResponse.success();
    }


    @PutMapping("/update")
    @ApiOperation(value = "客户修改")
    public JsonResponse update(@RequestBody CustomerUpdateReqDTO customerUpdateReqDTO){
        return JsonResponse.success();
    }


    @DeleteMapping(value = "/delete/{id}")
    @ApiImplicitParam(name = "id",required=true,value = "客户ID")
    @ApiOperation(value = "客户信息删除")
    public JsonResponse delete(@PathVariable("id") String id){
        return JsonResponse.success();
    }

    @PostMapping("/list")
    @ApiOperation(value = "客户列表查询")
    public JsonResponse list(@RequestBody CustomerQueryReqDTO customerQueryReqDTO){
        List<CustomerQueryResp> list=new ArrayList<>();
        CustomerQueryResp customerQueryResp=new CustomerQueryResp();
        customerQueryResp.setId(1);
        customerQueryResp.setGroupId(10);
        customerQueryResp.setMobile("13871805288");
        customerQueryResp.setRemark("张三");

        CustomerQueryResp customerQueryResp1=new CustomerQueryResp();
        customerQueryResp1.setId(2);
        customerQueryResp1.setGroupId(11);
        customerQueryResp1.setMobile("13871805290");
        customerQueryResp1.setRemark("李四");

        list.add(customerQueryResp);
        list.add(customerQueryResp1);
        return JsonResponse.success(list);
    }




}
