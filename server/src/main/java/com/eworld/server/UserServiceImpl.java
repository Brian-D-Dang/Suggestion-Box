package com.eworld.server;

import com.eworld.server.entity.UserAccountEntity;
import com.eworld.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl() {

    }
    @Override
    public String getHelloWorld() {
        return "Hello World";
    }
    @Override
    public boolean getUser(String username, String password) {
        UserAccountEntity userAccountEntity = userRepository.getUserAccountEntityByUsername(username);
        if(userAccountEntity == null) {
            return false;
        }
        return username.equals(userAccountEntity.getUsername());
    }

}

