package com.eworld.server;

import com.eworld.server.entity.UserAccountEntity;
import com.eworld.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public int getUserAccountId(String username, String password) {
        UserAccountEntity userAccountEntity = userRepository.getUserAccountEntityByUsername(username);
        if (userAccountEntity != null) {
            return userAccountEntity.getUserAccountId();
        }
        return 0;
    }

}

