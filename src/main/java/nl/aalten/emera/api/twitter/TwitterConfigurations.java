package nl.aalten.emera.api.twitter;

import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterConfigurations {

    public static Configuration getSdcPuttenTwitterConfiguration() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("p7YHrFf3XNAlEqOcL7mvmLMbI")
                .setOAuthConsumerSecret("2lsWM4vBO7jElC0WmV3Suc5TiUWLacEbxlc4eWy2V3YGQYzvfO")
                .setOAuthAccessToken("715952931640623104-mr1FyVphVjppFJd3XunZ0MVtTfbmXad")
                .setOAuthAccessTokenSecret("vHB7AYseZXTpCwVtn2fxiWONv4bHpcaq81tZIlvCV2gmh");
        return cb.build();
    }

    public static Configuration getKinaiTwitterConfiguration() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setPrettyDebugEnabled(false);
        cb.setDebugEnabled(false)
                .setOAuthConsumerKey("A1t5NhrSrvOLapAhTMJb75wxx")
                .setOAuthConsumerSecret("6vTiAbv4w8FV2u6j10mntdb7cpsLYA3mUOtAnU5xMkxgRDj1lW")
                .setOAuthAccessToken("215012329-nLWXljbtuBjDbExGaYTpS9oUO0Nvjos5ciXwmsGR")
                .setOAuthAccessTokenSecret("FUBd427Z7kdaRHo8JHWOe5XhPSSmJHJ2TsjcJQElxfV7N");
        return cb.build();
    }

}
