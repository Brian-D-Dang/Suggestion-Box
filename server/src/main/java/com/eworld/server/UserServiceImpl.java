package com.eworld.server;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    public UserServiceImpl() {

    }
    @Override
    public String getHelloWorld() {
        return "Hello World";
    }

}

