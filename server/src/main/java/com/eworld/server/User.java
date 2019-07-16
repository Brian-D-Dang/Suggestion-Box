package com.eworld.server;

public class User {
    private String firstName;
    private String lastName;
    private int userAccountId;

    public User() {
    }
    public User(String firstName, String lastName, int userAccountId) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.userAccountId = userAccountId;
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

    public int getUserAccountId() {
        return userAccountId;
    }
    public void setUserAccountId(int userAccountId) {
        this.userAccountId = userAccountId;
    }

}
