package com.tst.fanzhapian.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("url"+request.getRequestURI());
        if (request.getRequestURI().endsWith("index.jsp")||request.getRequestURI().endsWith("login.action") || request.getRequestURI().endsWith("admin.action")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            Object userid = request.getSession().getAttribute("userid");
            System.out.println(userid);
            if (userid != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                request.getRequestDispatcher("index.jsp").forward(servletRequest, servletResponse);
            }
        }
    }
}
