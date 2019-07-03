package com.eworld.server.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ACCOUNT")
public class UserAccountEntity {
    @Id @GeneratedValue
    @Column(name = "USER_ACCOUNT_ID")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "Manager")
    private int manager;

    @Column(name = "username")
    private String username;

    public UserAccountEntity() {}

    public int getId() {
        return id;
    }
    public void setIt(int id) {
        this.id = id;
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

    public int getManager() {
        return manager;
    }
    public void setManager(int manager) {
        this.manager = manager;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}
