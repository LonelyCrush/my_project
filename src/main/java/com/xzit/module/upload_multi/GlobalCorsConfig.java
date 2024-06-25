package com.xzit.module.upload_multi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * <p>
 * 该类用于：全局跨域配置
 * </p>
 *
 * @author leizf
 * @since 2023-09-06 17:01
 */
@Configuration
public class GlobalCorsConfig {

    /**
     * 允许跨域调用的过滤器
     */
    @Bean
    public CorsFilter corsFilter() {
        // 1、添加CORS配置信息
        CorsConfiguration config = new CorsConfiguration();
        // （1）允许的域名进行跨域调用
        config.addAllowedOriginPattern("*");
        // （2）允许跨越发送cookie
        config.setAllowCredentials(true);
        // （3）放行的原始头信息
        config.addAllowedHeader("*");
        // （4）允许的请求方法跨域调用
        config.addAllowedMethod("*");

        // 2、添加映射路径
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        // 3、返回新的CorsFilter
        return new CorsFilter(source);
    }
}
