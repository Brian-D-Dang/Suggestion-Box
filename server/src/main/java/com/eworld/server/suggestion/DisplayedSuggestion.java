package com.eworld.server.suggestion;

public class DisplayedSuggestion {
    private String category;
    private String subject;
    private String suggestion;

    public DisplayedSuggestion() {
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

}
