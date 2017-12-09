package nl.aalten.emera.api.facebook;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;

public class FacebookApi {

    public void postMessage(String message) throws FacebookException {
        Facebook facebook = new FacebookFactory().getInstance();
        facebook.getAccounts();
    }
}
