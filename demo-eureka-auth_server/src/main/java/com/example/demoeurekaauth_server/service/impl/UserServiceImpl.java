package com.example.demoeurekaauth_server.service.impl;

import com.example.demoeurekaauth_server.mapper.UserMapper;
import com.example.demoeurekaauth_server.pojo.User;
import com.example.demoeurekaauth_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUser(String username) {
        return userMapper.findByUsername(username);
    }
//    public User getUser(String username) {
//
//    }
}
