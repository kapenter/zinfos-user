package com.api.dingdang.user.filter;


import com.api.dingdang.user.constants.Constants;
import com.api.dingdang.user.exception.enums.BizCodeEnum;
import com.api.dingdang.user.utils.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@WebFilter(filterName = "servletFilter",urlPatterns = "/*")
@Slf4j
public class ServletFilter  implements Filter{


    private List<String>  excludeUrlList= Arrays.asList("/user/doLogin,/user/reg".split(","));

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 1.验证 nonce 是否有传值 是否唯一
        // 2.timestamp 是否有传2分钟之类
        // 3.验证token是否是登录时候生成的token
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;

        String pathUrl=request.getServletPath();
        // 如果是excludeUrl 直接通过
        if(excludeUrlList.contains(pathUrl)||
                pathUrl.endsWith(".html")||
                pathUrl.endsWith(".js")||
                pathUrl.startsWith("/webjars/")||
                pathUrl.startsWith("/swagger-resources")||
                pathUrl.contains("/v2/api-docs")||
                pathUrl.contains("/favicon.ico")||
                pathUrl.contains("/doc.html")
                ){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        String nonce=request.getParameter("nonce");
        if(ZuStringUtil.isBlank(nonce)|| redisUtil.hasKey(nonce)){
            servletFilterException(response,BizCodeEnum.NONCE_INVALID);
            return;
        }

        long timestamp= Long.parseLong(request.getParameter("timestamp"));
        int interval=60*2;
        if(!ZuDateUtil.checkTime(timestamp,interval)){
            servletFilterException(response,BizCodeEnum.TIME_STAMP_INVALID);
            return;
        }

        String  encryptedMobile;
        try {
              encryptedMobile= AESUtil.aesEncrypt(request.getHeader("mobile"));
        } catch (Exception e) {
            log.error("encryptedMobile error",e);
            servletFilterException(response,BizCodeEnum.ENCRYPTED_DATA_EXCEPTION);
            return;
        }
        //token不存在 或者 token不满足登录的token
        String accessToken=request.getHeader("accessToken");
        if(ZuStringUtil.isBlank(accessToken)||redisUtil.get(Constants.LOGIN_ACCESS_TOKEN+encryptedMobile)==null){
            servletFilterException(response,BizCodeEnum.TOKEN_INVALID);
            return ;
        }
        redisUtil.set(nonce,nonce,Constants.DAY);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    private  void servletFilterException(HttpServletResponse response,BizCodeEnum bizCodeEnum){
        ServletOutputStream outputStream=null;
        try {
            outputStream=response.getOutputStream();
            String returnResult=new ObjectMapper().writeValueAsString(JsonResponse.failure(bizCodeEnum));
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            outputStream.write(returnResult.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            log.error("IOException error");
        }finally {
           if(outputStream!=null){
               try {
                   outputStream.close();
               } catch (IOException e) {
                   log.error("servletFilterException error",e);
               }
           }
        }


    }

    @Override
    public void destroy() {

    }
}
