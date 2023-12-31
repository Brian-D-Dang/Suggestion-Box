package com.eworld.server.suggestion;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SUGGESTION")
public class SuggestionEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "SUGGESTION_ID")
    private int suggestionId;

    @Column(name = "USER_ACCOUNT_ID")
    private int userAccountId;

    @Column(name = "SUGGESTION")
    private String suggestion;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "SUBJECT")
    private String subject;

    public SuggestionEntity() {}

    public SuggestionEntity(String category, String subject, String suggestion, Date createdDate, int userAccountId) {
        this.category = category;
        this.subject = subject;
        this.suggestion = suggestion;
        this.createdDate = createdDate;
        this.userAccountId = userAccountId;
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

    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }


}
