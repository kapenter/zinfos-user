package com.api.dingdang.user.controller;

import com.api.dingdang.user.dto.req.user.UserLoginReqDTO;
import com.api.dingdang.user.dto.req.user.UserLoginVerifyReqDTO;
import com.api.dingdang.user.dto.req.user.UserRegReqDTO;
import com.api.dingdang.user.dto.req.user.UserUpdateReqDTO;
import com.api.dingdang.user.dto.resp.user.UserLoginResp;
import com.api.dingdang.user.dto.resp.user.UserQueryResp;
import com.api.dingdang.user.exception.enums.UserCodeEnum;
import com.api.dingdang.user.mapstruct.UserMapStruct;
import com.api.dingdang.user.module.User;
import com.api.dingdang.user.service.IUserService;
import com.api.dingdang.user.utils.JsonResponse;
import com.api.dingdang.user.utils.RedisUtil;
import com.api.dingdang.user.utils.ZuStringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags="用户模块")
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserMapStruct userMapStruct;


    @Autowired
    private RedisUtil redis;

    @PostMapping("/reg")
    @ApiOperation(value = "用户注册")
    public JsonResponse userReg(@RequestBody UserRegReqDTO userRegReqDTO){
        redis.set("userName","zhouwei");
        System.out.println(redis.get("userName"));
        return JsonResponse.success();
    }


    @PostMapping("/doLogin")
    @ApiOperation(value = "用户密码登录")
    public JsonResponse doLogin(@RequestBody UserLoginReqDTO userLoginReqDTO){
        User user= userService.selectOne(userMapStruct.loginReq2do(userLoginReqDTO));
        if(user!=null){
            return JsonResponse.success(new UserLoginResp(ZuStringUtil.getAccessToken()));
        }
        return JsonResponse.failure(UserCodeEnum.LOGIN_EXCEPTION);
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
