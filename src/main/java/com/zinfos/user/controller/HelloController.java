package com.zinfos.user.controller;

import com.zinfos.user.mapstruct.UserMapStruct;
import com.zinfos.user.vo.UserDO;
import com.zinfos.user.vo.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private UserMapStruct userMapStruct;


    @RequestMapping("/hello")
    public String  sayHello(){
        UserDO userDO=new UserDO();
        UserDTO userDTO= new  UserDTO();
        userDTO.setUserName("zhangsna");
        userDTO.setAge(18);
        userDTO.setPhone("17688917168");
        System.out.println(userMapStruct.dto2do(userDO,userDTO));
        return  "hello ";
    }

}
