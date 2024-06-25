package com.xzit.module.filter_interceptor;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-05-20 15:10
 */
@Component
public class FilterA implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器-前置处理");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器-业务处理");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器-后置处理");
    }
}
