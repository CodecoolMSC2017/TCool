package com.codecool.web.service;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import javafx.scene.control.Alert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;


public class XmlHandler {

    public void saveTweet(Tweet twe) {
        try {
            String path = "../Data/Tweets.xml";
            System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("../Data/Tweets.xml"));
            Element root = doc.getDocumentElement();

            Element tweet = doc.createElement("tweet");
            root.appendChild(tweet);

            Element tweetSender = doc.createElement("sender");
            Element tweetMessage = doc.createElement("message");
            Element tweetTime = doc.createElement("tweetTime");
            tweetSender.appendChild(doc.createTextNode(twe.getSender()));
            tweetMessage.appendChild(doc.createTextNode(twe.getMessage()));
            tweetTime.appendChild(doc.createTextNode(Long.toString(twe.getTime())));
            tweet.appendChild(tweetSender);
            tweet.appendChild(tweetMessage);
            tweet.appendChild(tweetTime);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(path));

            transformer.transform(source, result);

            System.out.println("File saved!");
        } catch (ParserConfigurationException pce) {
            System.out.println("Parser configuration failed.");
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            System.out.println("Failed to transform. Remain Mr. Hyde today");
            tfe.printStackTrace();
        } catch (SAXException sxe) {
            System.out.println("Sucks Exception happened.");
            sxe.printStackTrace();
        } catch (IOException ioe) {
            System.out.println("This is likely not the best input");
            ioe.printStackTrace();
        }
    }

    public Document loadTweets() throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        String path = "../Data/Tweets.xml";
        File xmlFile = new File(path);
        Document document = dBuilder.parse(xmlFile);
        return document;
    }
}
