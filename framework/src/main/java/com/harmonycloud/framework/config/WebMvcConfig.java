package com.harmonycloud.framework.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Usage: MVC方面全局配置
 * @Author: gjq
 * @Date: 2019/3/4 5:28 PM
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${project.default-view}")
    String defaultView;

    /**
     * 视图控制器配置
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName(defaultView);
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    /**
     * 跨域CORS配置
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("POST", "GET")
                .allowedOrigins("*")
                .allowCredentials(true);
    }
}