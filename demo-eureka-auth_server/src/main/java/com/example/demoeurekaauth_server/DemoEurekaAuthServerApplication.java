package com.example.demoeurekaauth_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableAuthorizationServer
@SpringBootApplication
public class DemoEurekaAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaAuthServerApplication.class, args);
    }

}
