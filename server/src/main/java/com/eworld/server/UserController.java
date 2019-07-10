package com.eworld.server;

import java.util.ArrayList;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.eworld.server.repository.UserRepository;

@RestController
@RequestMapping("/User")
public class UserController {
    // Used to retrieve user data for login
    @Autowired
    private UserServiceImpl userServiceImpl;


    @RequestMapping(value = "/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public int returnUserAccountId(@RequestParam(value="username") String username, @RequestParam(value="password") String password) {
        return userServiceImpl.getUserAccountId(username, password);
    }
}
