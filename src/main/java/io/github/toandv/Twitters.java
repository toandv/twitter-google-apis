package io.github.toandv;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by toan on 7/25/16.
 */
public class Twitters {
    static ConfigurationBuilder cb = new ConfigurationBuilder()
            .setDebugEnabled(true)
            .setOAuthConsumerKey("LPhcGrEFLTm1C8pAB9XxMQgvw")
            .setOAuthConsumerSecret("rLItCtB8dDNeLGIKn3LrRlce4FpchxVLELOwPAPwcCr9hWttJD")
            .setOAuthAccessToken("448032857-zAZUC7C3RYxSGtmxkiaTqdxTbysAyPPfkN7FdAWf")
            .setOAuthAccessTokenSecret("Lq7Oxt7XFGR7hiJd81WWcSzzkwmWBN8uZpLptrTdiQJrX");

    static Twitter twitter = new TwitterFactory(cb.build()).getInstance();

    public static Twitter getTwitter() {
        return twitter;
    }
}
