package com.eworld.server;

import com.eworld.server.entity.PasswordEntity;
import com.eworld.server.entity.UserAccountEntity;
import com.eworld.server.repository.PasswordRepository;
import com.eworld.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.util.Password;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordRepository passwordRepository;

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
            PasswordEntity passwordEntity = passwordRepository.getPasswordEntityByUserAccountId(userAccountEntity.getUserAccountId());
            if (passwordEntity != null) {
                if (password.equals(passwordEntity.getPassword())) {
                    return userAccountEntity.getUserAccountId();
                }
            }
        }
        return 0;
    }

}

