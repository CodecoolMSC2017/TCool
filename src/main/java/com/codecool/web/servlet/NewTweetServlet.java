package com.codecool.web.servlet;

import com.codecool.web.service.Tweet;
import com.codecool.web.service.XmlHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/new-tweet")
public class NewTweetServlet extends HttpServlet {
    private final XmlHandler xmlHandler = new XmlHandler();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Tweet newTweet = new Tweet(req);
        xmlHandler.saveTweet(newTweet);
        req.getRequestDispatcher("new-tweet.jsp").forward(req, resp);
    }

}
