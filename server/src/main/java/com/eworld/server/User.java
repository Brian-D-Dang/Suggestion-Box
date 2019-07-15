package com.eworld.server;

public class User {
    private String username;
    private String password;
    private int userAccountId;

    public User() {
    }
    public User(String username, String password, int userAccountId) {

        this.username = username;
        this.password = password;
        this.userAccountId = userAccountId;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserAccountId() {
        return userAccountId;
    }
    public void setUserAccountId(int userAccountId) {
        this.userAccountId = userAccountId;
    }
}
