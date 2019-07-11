package com.eworld.server.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "PASSWORD")
public class PasswordEntity {
    @Id
    @GeneratedValue
    @Column(name = "PASSWORD_ID")
    private int passwordId;

    @Column(name = "USER_ACCOUNT_ID")
    private int userAccountId;

    @Column(name = "PASSWORD")
    private String password;

    public PasswordEntity() {
    }


    public int getPasswordId() {
        return passwordId;
    }
    public void setPasswordId(int passwordId) {
        this.passwordId = passwordId;
    }

    public int getUserAccountId() {
        return userAccountId;
    }
    public void setUserAccountId(int userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}