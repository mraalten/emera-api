package nl.aalten.emera.api.twitter;

import nl.aalten.emera.api.twitter.model.Tweet;
import org.junit.Test;

public class TwitterApiShould {

    @Test
    public void sendTweetWithCorrectDetails() {
        TwitterApi twitterApi = new TwitterApi(TwitterConfigurations.getKinaiTwitterConfiguration());
        twitterApi.sendTweet(new Tweet("Gefeliciteerd met je verjaardag!"));
    }
}
