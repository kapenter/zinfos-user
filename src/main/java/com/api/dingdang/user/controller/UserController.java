package com.api.dingdang.user.controller;

import com.api.dingdang.user.dto.req.user.UserLoginReqDTO;
import com.api.dingdang.user.dto.req.user.UserLoginVerifyReqDTO;
import com.api.dingdang.user.dto.req.user.UserRegReqDTO;
import com.api.dingdang.user.dto.req.user.UserUpdateReqDTO;
import com.api.dingdang.user.utils.JsonResponse;
import com.api.dingdang.user.dto.resp.user.UserLoginResp;
import com.api.dingdang.user.dto.resp.user.UserQueryResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags="用户模块")
@RequestMapping(value = "/user")
public class UserController {


    @PostMapping("/reg")
    @ApiOperation(value = "用户注册")
    public JsonResponse userReg(@RequestBody UserRegReqDTO userRegReqDTO){
        return JsonResponse.success();
    }


    @PostMapping("/doLogin")
    @ApiOperation(value = "用户密码登录")
    public JsonResponse doLogin(@RequestBody UserLoginReqDTO userLoginReqDTO){
        String accessToken="32325d-s2dae-2-3-32-23-32323";
        return JsonResponse.success(new UserLoginResp(accessToken));
    }


    @PostMapping("/verifyLogin")
    @ApiOperation(value = "用户验证码登录")
    public JsonResponse verifyLogin(@RequestBody UserLoginVerifyReqDTO userLoginVerifyReqDTO){
        String accessToken="32325d-s2dae-2-3-32-23-32323";
        return JsonResponse.success(new UserLoginResp(accessToken));
    }


    @PutMapping("/updateInfo")
    @ApiOperation(value = "用户信息修改")
    public JsonResponse userReg(@RequestBody UserUpdateReqDTO userUpdateReqDTO){
        return JsonResponse.success();
    }


    @GetMapping(value = "/getUserInfo/{id}")
    @ApiImplicitParam(name = "id",required=true,value = "用户ID")
    @ApiOperation(value = "用户信息查询")
    public JsonResponse getUserInfo(@PathVariable("id") String id){
        UserQueryResp userQueryResp=new UserQueryResp();
        userQueryResp.setId(1);
        userQueryResp.setAddress("深圳市");
        userQueryResp.setSex(0);
        userQueryResp.setUserArea("宝安区");
        userQueryResp.setUserFace("xxx.img");
        return JsonResponse.success(userQueryResp);
    }

}
