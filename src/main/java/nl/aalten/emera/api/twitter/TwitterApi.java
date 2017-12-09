package nl.aalten.emera.api.twitter;

import java.io.InputStream;

import lombok.extern.slf4j.Slf4j;
import nl.aalten.emera.api.twitter.model.Tweet;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;

@Slf4j
public class TwitterApi {
    private static final String DEFAULT_BIRTHDAY_IMAGE = "cake.jpeg";

    private Twitter twitter;

    public TwitterApi(Configuration twitterConfiguration) {
        TwitterFactory twitterFactory = new TwitterFactory(twitterConfiguration);
        twitter = twitterFactory.getInstance();
    }

    public boolean sendTweet(Tweet tweet) {
        StatusUpdate su  = new StatusUpdate(tweet.getText());
        if (tweet.hasImage()) {
            su.setMedia("birthday_image", tweet.getImageAsStream());
        } else {
            su.setMedia("birthday_image", getImageAsStream(DEFAULT_BIRTHDAY_IMAGE));
        }
        try {
            twitter.updateStatus(su);
            return true;
        } catch (TwitterException e) {
            log.error("Twitter message not send, error occurred : " + e);
        }
        return false;
    }

    private InputStream getImageAsStream(String imageName) {
        return this.getClass().getClassLoader().getResourceAsStream(imageName);
    }

}
