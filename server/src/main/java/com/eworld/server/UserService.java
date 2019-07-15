package com.eworld.server;

import java.util.List;

public interface UserService {
     List<User> getUserAccountId (String username, String password);
}
