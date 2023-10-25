package com.eworld.server.password;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "PASSWORD")
public class PasswordEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "PASSWORD_ID")
    private int passwordId;

    @Column(name = "USER_ACCOUNT_ID")
    private int userAccountId;

    @Column(name = "PASSWORD")
    private String password;

//    @Column(name = "EFFECTIVE_DATE")
//    private Date effectiveDate;

    public PasswordEntity() {
    }

//    public PasswordEntity(int userAccountId, String password, Date effectiveDate) {
    public PasswordEntity(int userAccountId, String password) {
        this.userAccountId = userAccountId;
        this.password = password;
//        this.effectiveDate = effectiveDate;
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

//    public Date getEffectiveDate() {
//        return effectiveDate;
//    }
//    public void setEffectiveDate(Date effectiveDate) {
//        this.effectiveDate = effectiveDate;
//    }
}