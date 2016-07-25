package io.github.toandv;

import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by toan on 7/15/16.
 */
public class SearchTweets {
    public static void main(String[] args) {

        ConfigurationBuilder cb = new ConfigurationBuilder()
                .setDebugEnabled(true)
                .setOAuthConsumerKey("LPhcGrEFLTm1C8pAB9XxMQgvw")
                .setOAuthConsumerSecret("rLItCtB8dDNeLGIKn3LrRlce4FpchxVLELOwPAPwcCr9hWttJD")
                .setOAuthAccessToken("448032857-zAZUC7C3RYxSGtmxkiaTqdxTbysAyPPfkN7FdAWf")
                .setOAuthAccessTokenSecret("Lq7Oxt7XFGR7hiJd81WWcSzzkwmWBN8uZpLptrTdiQJrX");

        Twitter twitter = new TwitterFactory(cb.build()).getInstance();
        try {
            Query query = new Query("functional programming java 8");
            query.setSince("2016-07-01");
            query.setUntil("2016-07-20");
            QueryResult result;
            int count = 0;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    System.out.println(tweet.getId());
                    count++;
                    System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                    System.out.println(twitter.lookupUsers(tweet.getUser().getId()).get(0).getLocation());
                }
            } while ((query = result.nextQuery()) != null);
            System.out.println(count);
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
    }

}
