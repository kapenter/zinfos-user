package com.api.dingdang.user.controller;

import com.api.dingdang.user.dto.req.UserReq;
import com.api.dingdang.user.mapstruct.UserMapStruct;
import com.api.dingdang.user.module.User;
import com.api.dingdang.user.service.IUserService;
import com.api.dingdang.user.vo.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private UserMapStruct userMapStruct;

    @Autowired
    private IUserService userService;

    @RequestMapping("/hello")
    public String  sayHello(){
        UserDTO userDTO= new  UserDTO();
        userDTO.setUserName("zhangsna");
        userDTO.setAge(18);
        userDTO.setPhone("17688917168");
        System.out.println(userMapStruct.dto2do(userDTO));
        return  "hello ";
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestBody UserReq userReq){
        User user=   userMapStruct.req2do(userReq);
        boolean reverse=userService.insert(user);
        return  "success";
    }

}
