package io.github.toandv.twitter;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.OAuth2Token;

/**
 * Created by toan on 7/25/16.
 */
public class Posts {
	public static void main(String[] args) {
		Twitter twitter = Twitters.getUserOnlyClient();
		try {
			OAuth2Token token = twitter.getOAuth2Token();
			System.out.println(token);
			twitter.updateStatus("Hello twitter api");
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
}
