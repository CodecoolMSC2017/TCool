package com.codecool.web.model;

import com.codecool.web.service.Tweet;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class TweetProcessor {

    public List<Tweet> collectTweets(Document doc) {
        NodeList nList = doc.getElementsByTagName("tweet");
        List<Tweet> collectedTweets = new ArrayList<>();

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node tweet = nList.item(temp);

            if (tweet.getNodeType() == Node.ELEMENT_NODE) {
                Element tweetElement = (Element) tweet;
                String name = tweetElement.getElementsByTagName("sender").item(0).getTextContent();
                String message = tweetElement.getElementsByTagName("messager").item(0).getTextContent();
                long tweetTime = Long
                    .parseLong(tweetElement.getElementsByTagName("tweetTime").item(0).getTextContent());

                Tweet newTweet = new Tweet(name, message, tweetTime);
                collectedTweets.add(newTweet);
            }
        }

        return collectedTweets;
    }
}
