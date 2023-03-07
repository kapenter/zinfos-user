package com.api.dingdang.user.controller;

import cn.hutool.core.io.FileUtil;
import com.api.dingdang.user.dto.req.user.UserReq;
import com.api.dingdang.user.mapstruct.UserMapStruct;
import com.api.dingdang.user.module.User;
import com.api.dingdang.user.service.IUserService;
import com.api.dingdang.user.vo.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@RestController
@Api(tags="用户模块")
public class HelloController {

    @Autowired
    private UserMapStruct userMapStruct;

    @Autowired
    private IUserService userService;

    @GetMapping("/hello")
    public String  sayHello(HttpServletResponse response){
        OutputStream os;//新建一个输出流对象
        String fileName = System.currentTimeMillis()+".docx";//找到跟参数一致的文件
        try {
            if(StringUtils.isNotEmpty(fileName)){
                response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
                response.setContentType("application/octet-stream");
                byte[] bytes = FileUtil.readBytes("d:/abc.docx");//通过文件的路径读取文件字节流
                os = response.getOutputStream();//通过response的输出流返回文件
                os.write(bytes);
                os.flush();
                os.close();
            }
        }catch (Exception e){
            System.out.println("文件下载失败");
        }
        return  "hello ";
    }

    @PostMapping("/addUser")
    @ApiOperation(value = "添加用户")
    public String addUser(@RequestBody UserReq userReq){
        User user=   userMapStruct.req2do(userReq);
        boolean reverse=userService.insert(user);
        return  "success";
    }

}
