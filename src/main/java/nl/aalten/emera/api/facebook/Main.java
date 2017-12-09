package nl.aalten.emera.api.facebook;

import facebook4j.Account;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.ResponseList;

public class Main {

    public static void main(String[] args) throws FacebookException {
        Facebook facebook = new FacebookFactory().getInstance();
        ResponseList<Account> accounts = facebook.getAccounts();
        System.out.println(accounts);
    }
}
