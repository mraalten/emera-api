package nl.aalten.emera.api.twitter;

import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterConfig {

    public static Configuration getKinaiTwitterConfiguration() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setPrettyDebugEnabled(false);
        cb.setDebugEnabled(false)
                .setOAuthConsumerKey("<oAuthConsumerKeyHere>")
                .setOAuthConsumerSecret("<oAuthConsumerSecretHere>")
                .setOAuthAccessToken("<oAuthAccessTokenHere>")
                .setOAuthAccessTokenSecret("<oAuthAccessTokenSecretHere>");
        return cb.build();
    }

}
