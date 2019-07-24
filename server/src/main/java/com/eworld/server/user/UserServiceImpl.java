package com.eworld.server.user;

import com.eworld.server.password.PasswordEntity;
import com.eworld.server.password.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordRepository passwordRepository;

    public UserServiceImpl() {

    }

    @Override
    public boolean createUserLogin(CreateUserAccount createUserAccount) {
        Date todayDate = new Date();
        UserAccountEntity userAccountEntity = new UserAccountEntity(createUserAccount.getFirstName(), createUserAccount.getLastName(), createUserAccount.getEmail(), createUserAccount.getUsername());
        userAccountEntity = userRepository.save(userAccountEntity);
        PasswordEntity passwordEntity = new PasswordEntity(userAccountEntity.getUserAccountId(), createUserAccount.getPassword(), todayDate);
        passwordEntity = passwordRepository.save(passwordEntity);
        return (userAccountEntity != null) && (passwordEntity != null);
    }

    @Override
    public User getUserAccountId(String username, String password) {
        UserAccountEntity userAccountEntity = userRepository.getUserAccountEntityByUsername(username);
        if (userAccountEntity != null) {
            PasswordEntity passwordEntity = passwordRepository.getPasswordEntityByUserAccountId(userAccountEntity.getUserAccountId());
            if (passwordEntity != null) {
                if (password.equals(passwordEntity.getPassword())) {
//                  Password and username gets checked with the database if true the data is then put into an object list
                    int userAccountId = passwordEntity.getUserAccountId();
                    Iterable<UserAccountEntity> userAccounts = userRepository.findAll();
                    Iterator<UserAccountEntity> iterator = userAccounts.iterator();
                    User userData= new User();
                    while (iterator.hasNext()) {
                        UserAccountEntity nextFirstLastName = iterator.next();
                        //this creates a new object and iterates through the list of firstnames and lastnames
                        if (userAccountId == nextFirstLastName.getUserAccountId()) {
                            // if the userAccountId from the passwordEntity matches with the iterated nextFirstLastname account id
                            // then the data from that iteration will be saved into the object and returned.
                            userData.setUserAccountId(nextFirstLastName.getUserAccountId());
                            userData.setManagerId(nextFirstLastName.getManager());
                            userData.setUsername(nextFirstLastName.getUsername());
                            userData.setEmail(nextFirstLastName.getEmail());
                            userData.setFirstName(nextFirstLastName.getFirstName());
                            userData.setLastName(nextFirstLastName.getLastName());
                        }
                    }
                    return userData;
                }
            }
        }
        // if nothing in the if statements work then return null = nothing.
        return null;
    }

}

