package io.github.toandv.twitter;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class SearchTweetsByPlace {
	public static void main(String[] args) throws TwitterException {
		Twitter twitter = Twitters.getAppOnlyClient();
		Query query = new Query("place:ae");
		QueryResult result = twitter.search(query);
		System.out.println(result.getTweets().size());
		for (Status status : result.getTweets()) {
			System.out.println(status.getPlace());
		}
	}
}
