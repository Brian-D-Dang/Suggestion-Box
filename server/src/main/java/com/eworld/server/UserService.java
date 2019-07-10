package com.eworld.server;

public interface UserService {
    String getHelloWorld();
    int getUserAccountId(String username, String password);
}
