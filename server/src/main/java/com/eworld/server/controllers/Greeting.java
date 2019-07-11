package com.eworld.server.controllers;

import java.util.Date;

public class Greeting {
    private Date date = new Date();
    private long id;
    private String content;

    public Greeting() {}

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
