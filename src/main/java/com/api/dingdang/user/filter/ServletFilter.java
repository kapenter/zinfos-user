package com.api.dingdang.user.filter;


import com.api.dingdang.user.utils.ZuStringUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebFilter(filterName = "servletFilter",urlPatterns = "/*")
public class ServletFilter  implements Filter{


    private List<String>  excludeUrlList= Collections.singletonList("/user/login,/user/reg,/doc.html");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        String accessToken=request.getHeader("accessToken");
        if(ZuStringUtil.isBlank(accessToken)){

        }


        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
