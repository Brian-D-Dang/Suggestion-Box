package com.eworld.server.user;


import com.eworld.server.exception.UserExceptions;

public interface UserService {
     User getUserAccountId (String username, String password);
     boolean createUserLogin(CreateUserAccount createUserAccount) throws UserExceptions;
}
