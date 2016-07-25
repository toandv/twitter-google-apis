package io.github.toandv.twitter;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import twitter4j.AsyncTwitter;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterAdapter;
import twitter4j.TwitterException;
import twitter4j.TwitterListener;
import twitter4j.TwitterMethod;

public class AsyncSearchTweets {
	public static void main(String[] args) throws Exception {
		AsyncTwitter asyncTwitter = Twitters.getAsyncAppOnlyClient();

		CountDownLatch latch = new CountDownLatch(1);

		TwitterListener listener = new TwitterAdapter() {
			@Override
			public void searched(QueryResult result) {
				List<Status> tweets = result.getTweets();
				for (Status tweet : tweets) {
					System.out.println(tweet.getId());
					System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
				}
				latch.countDown();
				System.out.println("Done");
			}

			@Override
			public void onException(TwitterException te, TwitterMethod method) {
				if (method == TwitterMethod.UPDATE_STATUS) {
					te.printStackTrace();
				} else {
					throw new AssertionError("Should not happen");
				}
			}

		};
		asyncTwitter.addListener(listener);
		asyncTwitter.search(new Query("java"));
		latch.await();
	}
}
