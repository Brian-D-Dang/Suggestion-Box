package com.eworld.server.user;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "USER_ACCOUNT")
public class UserAccountEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "USER_ACCOUNT_ID")
    private int userAccountId;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "MANAGER")
    private boolean manager;

    @Column(name = "USERNAME")
    private String username;

//    @Column(name = "FAILED_LOGIN_ATTEMPTS")
//    private int failedLoginAttempts;
//
//    @Column(name = "LAST_LOGIN_ATTEMPT")
//    private Date lastLoginAttempt;

    public UserAccountEntity() {}
//    public UserAccountEntity(String firstName, String lastName, String email, String username, boolean manager, int failedLoginAttempts, Date lastLoginAttempt) {
    public UserAccountEntity(String firstName, String lastName, String email, String username, boolean manager) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.manager = manager;
//        this.failedLoginAttempts = failedLoginAttempts;
//        this.lastLoginAttempt = lastLoginAttempt;
    }

    public int getUserAccountId() {
        return userAccountId;
    }
    public void setUserAccountId(int userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName( String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean getManager() {
        return manager;
    }
    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

//    public int getFailedLoginAttempts() {
//        return failedLoginAttempts;
//    }
//    public void setFailedLoginAttempts(int failedLoginAttempts) {
//        this.failedLoginAttempts = failedLoginAttempts;
//    }
//
//    public Date getLastLoginAttempt() {
//        return lastLoginAttempt;
//    }
//    public void setLastLoginAttempt(Date lastLoginAttempt) {
//        this.lastLoginAttempt = lastLoginAttempt;
//    }
}

