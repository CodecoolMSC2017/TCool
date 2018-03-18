package com.codecool.web.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class Tweet {
    private String sender;
    private String message;
    private long time;

    public Tweet(HttpServletRequest req) {
        Date currentDate = new Date();
        this.sender = req.getParameter("name");
        this.message = req.getParameter("message");
        this.time = currentDate.getTime();
    }

    public Tweet(String sender, String message, long time) {
        this.sender = sender;
        this.message = message;
        this.time = time;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public long getTime() {
        return time;
    }
}
