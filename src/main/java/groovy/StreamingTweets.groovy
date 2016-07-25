package groovy

import twitter4j.FilterQuery
import twitter4j.StallWarning
import twitter4j.Status
import twitter4j.StatusDeletionNotice
import twitter4j.StatusListener
import twitter4j.TwitterStream
import twitter4j.TwitterStreamFactory
import twitter4j.conf.ConfigurationBuilder

/**
 * Created by toan on 7/22/16.
 */
class StreamingTweets {
    static void main(args) {
        def cb = new ConfigurationBuilder()
                .setDebugEnabled(true)
                .setOAuthConsumerKey("LPhcGrEFLTm1C8pAB9XxMQgvw")
                .setOAuthConsumerSecret("rLItCtB8dDNeLGIKn3LrRlce4FpchxVLELOwPAPwcCr9hWttJD")
                .setOAuthAccessToken("448032857-zAZUC7C3RYxSGtmxkiaTqdxTbysAyPPfkN7FdAWf")
                .setOAuthAccessTokenSecret("Lq7Oxt7XFGR7hiJd81WWcSzzkwmWBN8uZpLptrTdiQJrX");
      //  cb.setApplicationOnlyAuthEnabled(true)

        TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance()

        def listenner = new StatusListener() {

            @Override
            void onStatus(Status status) {
                println status.getText()
            }

            @Override
            void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

            }

            @Override
            void onTrackLimitationNotice(int numberOfLimitedStatuses) {

            }

            @Override
            void onScrubGeo(long userId, long upToStatusId) {

            }

            @Override
            void onStallWarning(StallWarning warning) {

            }

            @Override
            void onException(Exception ex) {

            }
        }

        twitterStream.addListener(listenner)

        twitterStream.sample()
    }
}
