package com.harmonycloud.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
//@EnableSwagger2
public class FrameworkApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FrameworkApplication.class, args);
    }

}

