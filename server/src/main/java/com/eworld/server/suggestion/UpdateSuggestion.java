package com.eworld.server.suggestion;

public class UpdateSuggestion {
    private String category;
    private String subject;
    private String suggestion;
    private int userAccountId;
    private int suggestionId;

    public UpdateSuggestion() {
    }
    public UpdateSuggestion(String category, String subject, String suggestion, int userAccountId, int suggestionId) {
        this.category = category;
        this.subject = subject;
        this.suggestion = suggestion;
        this.userAccountId = userAccountId;
        this.suggestionId = suggestionId;
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

    public int getUserAccountId() {
        return userAccountId;
    }
    public void setUserAccountId(int userAccountId) {
        this.userAccountId = userAccountId;
    }

    public int getSuggestionId() {
        return suggestionId;
    }
    public void setSuggestionId(int suggestionId) {
        this.suggestionId = suggestionId;
    }
}

