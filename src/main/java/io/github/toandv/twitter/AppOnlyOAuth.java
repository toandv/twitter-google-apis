package io.github.toandv.twitter;

import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 * Created by toan on 7/25/16.
 */
public class AppOnlyOAuth {

	public static void main(String[] args) {
		// setup
		Twitter twitter = Twitters.getAppOnlyClient();
		try {
			// Must call to get access token.
			List<Status> statuses = twitter.getUserTimeline("Twitter");
			for (Status status : statuses) {
				System.out.println(status.getText());
			}
			// App-only auth cannot make requests to user apis.
			//twitter.updateStatus("update status");
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
}
