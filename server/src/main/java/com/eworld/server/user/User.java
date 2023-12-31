package com.eworld.server.user;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private int userAccountId;
    private boolean manager;

    public User() {
    }
    public User(String firstName, String lastName, String email, String username, int userAccountId, boolean manager) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.userAccountId = userAccountId;
        this.manager = manager;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserAccountId() {
        return userAccountId;
    }
    public void setUserAccountId(int userAccountId) {
        this.userAccountId = userAccountId;
    }

    public boolean getManager() {
        return manager;
    }
    public void setManager(boolean manager) {
        this.manager = manager;
    }
}
