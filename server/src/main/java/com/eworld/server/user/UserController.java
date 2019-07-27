package com.eworld.server.user;

import com.eworld.server.exception.UsernameException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/User")
public class UserController {
    // Used to retrieve user data for login
    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping(method = RequestMethod.POST, value = "/createUserAccount", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean createUser(@RequestBody CreateUserAccount createUserAccount) throws UsernameException {
        return userServiceImpl.createUserLogin(createUserAccount);
    }

    @RequestMapping(value = "/returnUserAccountId", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@RequestParam(value="username") String username, @RequestParam(value="password") String password) {
        return userServiceImpl.getUserAccountId(username, password);
    }
}
