package io.github.toandv.twitter;

import twitter4j.AsyncTwitter;
import twitter4j.AsyncTwitterFactory;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by toan on 7/25/16.
 */
public class Twitters {

	static final String TWITTER_CONSUMER_KEY = "LPhcGrEFLTm1C8pAB9XxMQgvw";
	static final String TWITTER_CONSUMER_SECRET = "rLItCtB8dDNeLGIKn3LrRlce4FpchxVLELOwPAPwcCr9hWttJD";

	static Configuration userOnlyConf = new ConfigurationBuilder().setDebugEnabled(true)
			.setOAuthConsumerKey(TWITTER_CONSUMER_KEY).setOAuthConsumerSecret(TWITTER_CONSUMER_SECRET)
			.setOAuthAccessToken("448032857-zAZUC7C3RYxSGtmxkiaTqdxTbysAyPPfkN7FdAWf")
			.setOAuthAccessTokenSecret("Lq7Oxt7XFGR7hiJd81WWcSzzkwmWBN8uZpLptrTdiQJrX").build();

	static Twitter userOnlyClient = new TwitterFactory(userOnlyConf).getInstance();

	static Configuration appOnlyConf = new ConfigurationBuilder().setApplicationOnlyAuthEnabled(true).build();

	// setup
	static Twitter appOnlyClient = new TwitterFactory(appOnlyConf).getInstance();

	static AsyncTwitter asyncAppOnlyClient = new AsyncTwitterFactory(appOnlyConf).getInstance();

	static {
		appOnlyClient.setOAuthConsumer(TWITTER_CONSUMER_KEY, TWITTER_CONSUMER_SECRET);
		asyncAppOnlyClient.setOAuthConsumer(TWITTER_CONSUMER_KEY, TWITTER_CONSUMER_SECRET);
		try {
			// Must call to get access token.
			appOnlyClient.getOAuth2Token();
			asyncAppOnlyClient.getOAuth2Token();
		} catch (TwitterException e) {
			throw new RuntimeException(e);
		}
	}

	public static Twitter getUserOnlyClient() {
		return userOnlyClient;
	}

	public static Twitter getAppOnlyClient() {
		return appOnlyClient;
	}

	public static AsyncTwitter getAsyncAppOnlyClient() {
		return asyncAppOnlyClient;
	}

}
