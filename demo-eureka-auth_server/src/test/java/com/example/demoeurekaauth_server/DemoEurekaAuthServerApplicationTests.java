package com.example.demoeurekaauth_server;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.demoeurekaauth_server.service.UserService;
import com.example.demoeurekaauth_server.service.impl.UserDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoEurekaAuthServerApplicationTests {
    @Autowired
    private DruidDataSource druidDataSource;
    @Autowired
    private UserService userService;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Test
    void contextLoads() {
        System.out.println(druidDataSource);
    }
    @Test
    void testUserService(){
        System.out.println(userService.getUser("admin"));

    }
    @Test
    void testUserService1(){
        System.out.println(userDetailsService.loadUserByUsername("admin"));

    }

}
