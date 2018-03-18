package com.codecool.web.servlet;

import com.codecool.web.model.TweetProcessor;
import com.codecool.web.service.Tweet;
import com.codecool.web.service.XmlHandler;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

@WebServlet("/tweets")
public class ViewTweetsServlet extends HttpServlet {

    private final XmlHandler xmlHandler = new XmlHandler();
    private final TweetProcessor allTweets = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Tweet> tweets = allTweets.collectTweets(xmlHandler.loadTweets());
            req.setAttribute("tweets", tweets);
            req.getRequestDispatcher("new-tweet.jsp").forward(req, resp);
        } catch (ParserConfigurationException par) {
            System.out.println("Parser gebazz");
            par.printStackTrace();
        } catch (SAXException sax) {
            System.out.println("SAX gebazz");
            sax.printStackTrace();
        }
    }

}
