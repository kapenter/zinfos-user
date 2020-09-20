package com.api.dingdang.user.filter;


import com.api.dingdang.user.exception.enums.BizCodeEnum;
import com.api.dingdang.user.utils.JsonResponse;
import com.api.dingdang.user.utils.ZuStringUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

@WebFilter(filterName = "servletFilter",urlPatterns = "/*")
@Slf4j
public class ServletFilter  implements Filter{


    private List<String>  excludeUrlList= Collections.singletonList("/user/login,/user/reg,/doc.html");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 1.验证 announce 是否有传值 是否唯一
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
                pathUrl.contains("/favicon.ico")
                ){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        String accessToken=request.getHeader("accessToken");
        if(ZuStringUtil.isBlank(accessToken)){
            servletFilterException(response,BizCodeEnum.TOKEN_INVALID);
            return ;
        }
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


//        JSONArray responseJSONObject = JSONArray.fromObject(bizCodeEnum);
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json; charset=utf-8");
//        PrintWriter out = null;
//        try {
//            out = response.getWriter();
//            out.append(responseJSONObject.toString());
//            log.debug("返回是\n");
//            log.debug(responseJSONObject.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (out != null) {
//                out.close();
//            }
//        }
    }

    @Override
    public void destroy() {

    }
}
