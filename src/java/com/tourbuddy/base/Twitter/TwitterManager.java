package com.tourbuddy.base.Twitter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nethumini
 */
public class TwitterManager {

    private static Twitter twitter = null;
    private static Properties prop = null;
    private static File file = null;
    private static InputStream is = null;
    private static OutputStream os = null;
    private static AccessToken accessToken = null;
    private static RequestToken requestToken = null;

    private TwitterManager() {
        file = new File("D:\\Research\\tourbuddy-master\\web\\WEB-INF\\twitter4j.properties");
       
//        file = new File("C:\\Documents and Settings\\Manoj\\Desktop");
        prop = new Properties();
        try {
            if (file.exists()) {
                is = new FileInputStream(file);
                prop.load(is);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.exit(-1);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ignore) {
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException ignore) {
                }
            }
        }
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(prop.getProperty("oauth.consumerKey"))
                .setOAuthConsumerSecret(prop.getProperty("oauth.consumerSecret"))
                .setOAuthAccessToken(null)
                .setOAuthAccessTokenSecret(null);
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
        try {
            requestToken = twitter.getOAuthRequestToken();
        } catch (TwitterException ex) {
            Logger.getLogger(TwitterManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("key:" + twitter.getConfiguration().getOAuthConsumerKey());
        System.out.println("secret: " + twitter.getConfiguration().getOAuthConsumerSecret());
    }

    public static TwitterManager getInstance() {
        return TMLoader.theInstance;
    }

    private static class TMLoader {

        private static final TwitterManager theInstance = new TwitterManager();
    }

    public Twitter getTwitter() {
        return twitter;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
        try {
            prop.setProperty("oauth.accessToken", accessToken.getToken());
            prop.setProperty("oauth.accessTokenSecret", accessToken.getTokenSecret());
            os = new FileOutputStream(file);
            prop.store(os, "twitter4j.properties");
            os.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.exit(-1);
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException ignore) {
                }
            }
        }
        System.out.println("Successfully stored access token to " + file.getAbsolutePath() + ".");
        updateTwitter();
        System.out.println("Twitter updated.");
    }

    private void updateTwitter() {
        // Read All Twittes
        ConfigurationBuilder cb1 = new ConfigurationBuilder();
        cb1.setDebugEnabled(true)
                .setOAuthConsumerKey(prop.getProperty("oauth.consumerKey"))
                .setOAuthConsumerSecret(prop.getProperty("oauth.consumerSecret"))
                .setOAuthAccessToken(accessToken.getToken())
                .setOAuthAccessTokenSecret(accessToken.getTokenSecret());
        TwitterFactory tf1 = new TwitterFactory(cb1.build());
        this.twitter = tf1.getInstance();
    }

    public AccessToken getAccessToken() {
        return accessToken;
    }

    public RequestToken getRequestToken() {
        return requestToken;
    }

}
