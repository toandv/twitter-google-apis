package io.github.toandv;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;
import twitter4j.auth.OAuth2Token;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by toan on 7/25/16.
 */
public class Posts {
    public static void main(String[] args) {
        Twitter twitter = Twitters.getTwitter();
        try {
            OAuth2Token token = twitter.getOAuth2Token();
            System.out.println(token);
            twitter.updateStatus("Hello twitter api");
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }
}
