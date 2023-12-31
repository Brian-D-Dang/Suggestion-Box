package com.eworld.server.suggestion;
import java.util.Date;

public class DisplayedSuggestion {
    private String category;
    private String subject;
    private String suggestion;
    private String date;
    private int suggestionId;
    private int userAccountId;

    public DisplayedSuggestion() {
    }
    public DisplayedSuggestion(String category, String subject, String suggestion, String date, int suggestionId, int userAccountId) {
        this.category = category;
        this.subject = subject;
        this.suggestion = suggestion;
        this.date = date;
        this.suggestionId = suggestionId;
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

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public int getSuggestionId() {
        return suggestionId;
    }
    public void setSuggestionId(int suggestionId) {
        this.suggestionId = suggestionId;
    }

    public int getUserAccountId() {
        return userAccountId;
    }
    public void setUserAccountId(int userAccountId) {
        this.userAccountId = userAccountId;
    }
}
