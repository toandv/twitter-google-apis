package io.github.toandv;

import jdk.nashorn.internal.runtime.OptimisticReturnFilters;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.OAuth2Token;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

/**
 * Created by toan on 7/25/16.
 */
public class AppOnlyOAuth {

    private static final String TWITTER_CONSUMER_KEY = "LPhcGrEFLTm1C8pAB9XxMQgvw";
    private static final String TWITTER_CONSUMER_SECRET = "rLItCtB8dDNeLGIKn3LrRlce4FpchxVLELOwPAPwcCr9hWttJD";

    public static void main(String[] args) {
        ConfigurationBuilder builder=new ConfigurationBuilder();
        builder.setApplicationOnlyAuthEnabled(true);

        // setup
        Twitter twitter = new TwitterFactory(builder.build()).getInstance();

        // exercise & verify
         twitter.setOAuthConsumer(TWITTER_CONSUMER_KEY, TWITTER_CONSUMER_SECRET);
        try {
            OAuth2Token token = twitter.getOAuth2Token();
           List<Status> statuses = twitter.getUserTimeline("Twitter");
//            for (Status status: statuses
//                 ) {
//                System.out.println(status.getText());
//            }

            //twitter.updateStatus("update status");

        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }
}
