package com.eworld.server;

import com.eworld.server.entity.PasswordEntity;
import com.eworld.server.entity.UserAccountEntity;
import com.eworld.server.repository.PasswordRepository;
import com.eworld.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordRepository passwordRepository;

    public UserServiceImpl() {

    }

    @Override
    public List<User> getUserAccountId(String username, String password) {
        UserAccountEntity userAccountEntity = userRepository.getUserAccountEntityByUsername(username);
        if (userAccountEntity != null) {
            PasswordEntity passwordEntity = passwordRepository.getPasswordEntityByUserAccountId(userAccountEntity.getUserAccountId());
            if (passwordEntity != null) {
                if (password.equals(passwordEntity.getPassword())) {
//                    Password and username gets checked with the database if true the data is then put into an object list
                    int userAccountId = passwordEntity.getUserAccountId();
                    Iterable<UserAccountEntity> firstLastName = userRepository.findAll();
                    Iterator<UserAccountEntity> iterator = firstLastName.iterator();
                    List<User> returnUserData = new ArrayList<>();
                    while (iterator.hasNext()) {
                        User userData = new User();
                        UserAccountEntity nextFirstLastName = iterator.next();
                        //this creates a new object and iterates through the list of firstnames and lastnames
                        if (userAccountId == nextFirstLastName.getUserAccountId()) {
                            // if the useraccountId from the passwordEntity matches with the iterated nextFirstLastname account id
                            // then the data from that iteration will be saved into the object and returned.
                            userData.setUserAccountId(nextFirstLastName.getUserAccountId());
                            userData.setUsername(nextFirstLastName.getFirstName());
                            userData.setPassword(nextFirstLastName.getLastName());
                            returnUserData.add(userData);
                        }
                    }
                    return returnUserData;
                }
            }
        }
        // if nothing in the if statements work then return null = nothing.
        return null;
    }

}

