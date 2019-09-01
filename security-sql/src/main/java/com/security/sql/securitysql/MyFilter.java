package com.security.sql.securitysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/test")
public class MyFilter implements Filter{

    private static final Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Hello Filtering....");
    }

    @Override
    @Order(10000)
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, IOException {
        logger.info("filter:"+ ((HttpServletRequest)servletRequest).getRequestURL());
        HttpServletRequest servletRequest1  = (HttpServletRequest)servletRequest;
        String token = servletRequest1.getHeader("myTokrn");
        System.out.println("token = " + token);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
