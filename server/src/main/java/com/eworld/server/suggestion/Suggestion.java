package com.eworld.server.suggestion;


public class Suggestion {
    private String category;
    private String subject;
    private String suggestion;
    private Integer userAccountId;

    public Suggestion() {
    }
    public Suggestion(String category, String subject, String suggestion, Integer userAccountId) {
        this.category = category;
        this.subject = subject;
        this.suggestion = suggestion;
        this.userAccountId = userAccountId;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSuggestion() {
        return suggestion;
    }
    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public Integer getUserAccountId() {
        return userAccountId;
    }
    public void setUserAccountId(Integer userAccountId) {
        this.userAccountId = userAccountId;
    }
}
