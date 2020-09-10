//package com.api.dingdang.user.controller;
//
//import com.api.dingdang.user.dto.req.user.UserReq;
//import com.api.dingdang.user.mapstruct.UserMapStruct;
//import com.api.dingdang.user.module.User;
//import com.api.dingdang.user.service.IUserService;
//import com.api.dingdang.user.vo.UserDTO;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@Api(tags="用户模块")
//public class HelloController {
//
//    @Autowired
//    private UserMapStruct userMapStruct;
//
//    @Autowired
//    private IUserService userService;
//
//    @GetMapping("/hello")
//    public String  sayHello(){
//        UserDTO userDTO= new  UserDTO();
//        userDTO.setUserName("zhangsna");
//        userDTO.setAge(18);
//        userDTO.setPhone("17688917168");
//        System.out.println(userMapStruct.dto2do(userDTO));
//        return  "hello ";
//    }
//
//    @PostMapping("/addUser")
//    @ApiOperation(value = "添加用户")
//    public String addUser(@RequestBody UserReq userReq){
//        User user=   userMapStruct.req2do(userReq);
//        boolean reverse=userService.insert(user);
//        return  "success";
//    }
//
//}
