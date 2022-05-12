package com.example.demoeurekaauth_server.service;


import com.example.demoeurekaauth_server.pojo.User;

public interface UserService {
    public User getUser(String username);
}
