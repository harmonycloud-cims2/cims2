package com.harmonycloud.framework.adapter.outbound.ws;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.xml.ws.Endpoint;

@Component
public class Publish {
    /*@Override
    public void run(ApplicationArguments args) throws Exception {
        String url = "http://192.168.5.229:8081/wsServeice";
        Endpoint.publish(url, new UserServiceImpl());
        System.out.println("发布webService成功！");
    }*/
    @Autowired
    private Bus bus;

    @Autowired
    UserService userService;

    @Bean
    public ServletRegistrationBean disServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/soap/*");
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, userService);
        endpoint.publish("/user");
        return endpoint;
    }
}
