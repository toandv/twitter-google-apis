package io.github.toandv.twitter;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

/**
 * Created by toan on 7/22/16.
 */
class StreamingTweets {
	public static void main(String... args) {

		TwitterStream twitterStream = new TwitterStreamFactory(Twitters.userOnlyConf).getInstance();
		StatusListener listenner = new StatusListener() {
			@Override
			public void onStatus(Status status) {
				System.out.println(status);
			}

			@Override
			public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

			}

			@Override
			public void onTrackLimitationNotice(int numberOfLimitedStatuses) {

			}

			@Override
			public void onScrubGeo(long userId, long upToStatusId) {

			}

			@Override
			public void onStallWarning(StallWarning warning) {

			}

			@Override
			public void onException(Exception ex) {

			}
		};

		twitterStream.addListener(listenner);

		twitterStream.sample();
	}
}
