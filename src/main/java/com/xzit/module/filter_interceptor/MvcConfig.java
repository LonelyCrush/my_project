package com.xzit.module.filter_interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-05-20 15:16
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 将自定义好的拦截器处理类进行注册
        // 通过addPathPatterns、excludePathPatterns等属性设置需要拦截或需要排除的URL
        registry.addInterceptor(new HandlerInterceptorA()).addPathPatterns("/**");
    }
}
