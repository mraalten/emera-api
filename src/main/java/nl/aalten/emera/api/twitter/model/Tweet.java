package nl.aalten.emera.api.twitter.model;

import java.io.InputStream;

public class Tweet {

    private String text;
    private InputStream imageAsStream;

    public Tweet(String text) {
        this.text = text;
    }

    public Tweet(String text, InputStream imageAsStream) {
        this.text = text;
        this.imageAsStream = imageAsStream;
    }

    public void setImageAsStream(InputStream imageAsStream) {
        this.imageAsStream = imageAsStream;
    }

    public String getText() {
        return text;
    }

    public InputStream getImageAsStream() {
        return imageAsStream;
    }

    public boolean hasImage() {
        return imageAsStream != null;
    }
}
