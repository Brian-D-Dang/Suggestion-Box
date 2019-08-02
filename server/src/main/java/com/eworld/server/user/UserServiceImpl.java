package com.eworld.server.user;

import com.eworld.server.exception.UserExceptions;
import com.eworld.server.password.PasswordEntity;
import com.eworld.server.password.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordRepository passwordRepository;

    public UserServiceImpl() {

    }

    @Override
    public boolean createUserLogin(CreateUserAccount createUserAccount) throws UserExceptions {
        // This function creates users
        Date todayDate = new Date();
        String emailPattern = "^[\\w\\-_\\.+]+\\@([\\w]+\\.)+[\\w]+[\\w]$";
        Pattern pat = Pattern.compile(emailPattern);
        Matcher matcher = pat.matcher(createUserAccount.getEmail());
        String userUsername = createUserAccount.getUsername();
        String userEmail = createUserAccount.getEmail();
        String userPassword = createUserAccount.getPassword();
        String userConfirmPassword = createUserAccount.getConfirmPassword();
        String userFirstName = createUserAccount.getFirstName();
        String userLastName = createUserAccount.getLastName();
        boolean userManagerId = createUserAccount.getManager();
                // The emailPattern is used to match up certain email requirements i.e @ signs, periods, letters, and when to end.
        List<UserAccountEntity> usernameCheckExist = userRepository.findUserAccountEntityByUsername(userUsername);
        List<UserAccountEntity> emailCheckExist = userRepository.findUserAccountEntityByEmail(userEmail);
        // This list checks if the username and email exists in the data base. It could return at least one user.
        if ((userPassword.equals(userConfirmPassword) && (matcher.matches()))) {
            // This checks if the password is the same as the confirm password input and checks if the email matches the email pattern before allowing user to be created
            if (usernameCheckExist.isEmpty() && emailCheckExist.isEmpty()) {
                int failedLoginAttempts = 0;
                // This checks to see if the usernameCheckExist found a username that already exists in the data base, but if it doesn't it creates the user.
                UserAccountEntity userAccountEntity = new UserAccountEntity(userFirstName, userLastName, userEmail, userUsername, userManagerId, failedLoginAttempts, null);
                userAccountEntity = userRepository.save(userAccountEntity);
                PasswordEntity passwordEntity = new PasswordEntity(userAccountEntity.getUserAccountId(), userPassword, todayDate);
                passwordEntity = passwordRepository.save(passwordEntity);
                return (userAccountEntity != null) && (passwordEntity != null);
            } else if ((usernameCheckExist.size() == 1) && emailCheckExist.size() == 1) {
                // If two users exist in the CheckExist then the function will throw an error to the UI side declaring that the username and email exists.
                throw new UserExceptions("Email and Username already exists");
            } else {
                // If there is one item in the CheckExist list then it will be ran through here to see if the username or email exists.
                if (usernameCheckExist.size() == 1) {
                    throw new UserExceptions("Username already exists");
                }
                if (emailCheckExist.size() == 1) {
                    throw new UserExceptions("Email already exists");
                }
            }
        }
        else {
            // This runs if the password or email doesn't match the requirements at the start of the function.
            if(!(userPassword.equals(userConfirmPassword))) {
                if(!matcher.matches()) {
                    throw new UserExceptions("Email does not exist and the password confirmation is incorrect");
                }
                throw new UserExceptions("Incorrect password confirmation");
            }
            else if(!matcher.matches()) {
                if(!(userPassword.equals(userConfirmPassword))) {
                    throw new UserExceptions("Email does not exist and the password confirmation is incorrect");
                }
                throw new UserExceptions("Email does not exist");
            }
        }
        // return false if everything fails to run in general. This is used to show that the entirety of the code broke.
        return false;
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
                    User userData = new User();
                    while (iterator.hasNext()) {
                        UserAccountEntity nextFirstLastName = iterator.next();
                        //this creates a new object and iterates through the list of firstnames and lastnames
                        if (userAccountId == nextFirstLastName.getUserAccountId()) {
                            // if the userAccountId from the passwordEntity matches with the iterated nextFirstLastname account id
                            // then the data from that iteration will be saved into the object and returned.
                            userData.setUserAccountId(nextFirstLastName.getUserAccountId());
                            userData.setManager(nextFirstLastName.getManager());
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

