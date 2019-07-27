package com.eworld.server.user;


import com.eworld.server.exception.UsernameException;

public interface UserService {
     User getUserAccountId (String username, String password);
     boolean createUserLogin(CreateUserAccount createUserAccount) throws UsernameException;
}
