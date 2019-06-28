package com.eworld.server;

import java.util.ArrayList;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {
    // Used to retrieve user data for login
    @Autowired
    private UserServiceImpl UserServiceImpl;

    @RequestMapping(value = "/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean hardCodeUsers(@RequestParam(value="brian") String brian) {
        boolean exist = false;
        ArrayList<User> users = new ArrayList<>();
        users.add(new User ("brian", "12345q"));
        users.add(new User ("david", "1"));
        users.add(new User ("alan", "boto"));
        for (User user : users) {
            if (brian.equals(user.getUsername())) {
                exist = true;
            }
        }
        return exist;
//
//        exist = users.get(0);
//        if (!exist) {
//            throw new Error("Incorrect username or password");
//        }
//        return exist;
    }

//    @RequestMapping(value = "/getHelloWorld", produces = MediaType.APPLICATION_JSON_VALUE)
//    public String helloWorld() {
//        return UserServiceImpl.getHelloWorld();
//    }
//    public static void main(String[] args) {
//
//    }
}
