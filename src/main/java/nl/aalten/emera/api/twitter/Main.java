package nl.aalten.emera.api.twitter;

import java.io.IOException;
import java.io.InputStream;

import lombok.extern.slf4j.Slf4j;
import nl.aalten.emera.api.twitter.model.Member;
import nl.aalten.emera.api.twitter.model.Tweet;
import twitter4j.TwitterException;

@Slf4j
public class Main {
    private static TwitterApi twitterApi = new TwitterApi(TwitterConfigurations.getKinaiTwitterConfiguration());
    private static String HAPPY_BIRTHDAY_TEXT = "SDC Putten feliciteert selectie speler %s met zijn verjaardag.";

    public static void main(String[] args) throws IOException, TwitterException {
        log.debug("Starting app");
//        Stream<String> file = readFile();
//        file.forEach(line -> processLine(line));
    }

    private static void processLine(String line) {
        String[] fields = line.split(";");
        Member member = new Member(fields[0], fields[1], fields[2]);
        if (member.isBirthday()) {
            boolean sent = sendTweet(member);
            if (sent) {
                log.info("Tweet sent for " + member.getName() + " - " + member.getBirthDate());
            }
        }
    }

    private static boolean sendTweet(Member member) {
        Tweet tweet = new Tweet(String.format(HAPPY_BIRTHDAY_TEXT, member.getName()));
        InputStream imageAsStream = ClassLoader.getSystemResourceAsStream("cake.jpeg");
        tweet.setImageAsStream(imageAsStream);
        return twitterApi.sendTweet(tweet);
    }

//    private static Stream<String> readFile() throws IOException {
//        return Files.lines(Paths.get("src/main/resources/leden.txt"));
//    }

}
