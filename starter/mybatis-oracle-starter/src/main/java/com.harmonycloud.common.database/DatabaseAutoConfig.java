package com.harmonycloud.common.database;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Usage: MybatisPlus相关配置
 * @Author: gjq
 * @Date: 2019/3/21 4:38 PM
 */
@Configuration
@MapperScan("com.harmonycloud.*.adapter.outbound.database")
public class DatabaseAutoConfig {
    /**
     * 逻辑删除
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.addUrlMappings("/database/*");
//        servletRegistrationBean.addInitParameter("loginUsername","harmony");
//        servletRegistrationBean.addInitParameter("loginPassword","12345678");
        return servletRegistrationBean;
    }
}
