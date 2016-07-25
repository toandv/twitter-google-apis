package io.github.toandv.twitter;

import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 * Created by toan on 7/15/16.
 */
public class SearchTweets {
	public static void main(String[] args) {

		Twitter twitter = Twitters.getAppOnlyClient();
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
