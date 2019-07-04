package com.eworld.server.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "SUGGESTION")
public class SuggestionEntity {
    @Id
    @GeneratedValue
    @Column(name = "SUGGESTION_ID")
    private int suggestionId;

    @Column(name = "USER_ACCOUNT_ID")
    private int id;

    @Column(name = "suggestion")
    private String suggestion;

    @Column(name = "category")
    private String category;

    @Column(name = "created_date")
    private String date;

    public SuggestionEntity() {}

    public int getSuggestionId() {
        return suggestionId;
    }
    public void setSuggestionId(int suggestionId) {
        this.suggestionId = suggestionId;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getSuggestion() {
        return suggestion;
    }
    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}
