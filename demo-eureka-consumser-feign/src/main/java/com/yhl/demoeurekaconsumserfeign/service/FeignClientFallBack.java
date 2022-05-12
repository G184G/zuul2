package com.yhl.demoeurekaconsumserfeign.service;

import org.springframework.stereotype.Component;

@Component
public class FeignClientFallBack implements UserClient{
    @Override
    public String hello() {
        return "";
    }

    @Override
    public String hello(int sleep_seconds) {
        return "Hi,容错保护机制已启动";
    }
}
