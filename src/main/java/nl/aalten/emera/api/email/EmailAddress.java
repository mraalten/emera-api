package nl.aalten.emera.api.email;

import java.io.UnsupportedEncodingException;

import javax.mail.Address;
import javax.mail.internet.InternetAddress;

import lombok.Builder;
import lombok.NonNull;

@Builder(builderClassName = "Builder")
public class EmailAddress {

    @NonNull
    public final String emailAddress;

    @NonNull
    public final String fullName;

    public Address toInternetAddress() {
        try {
            return new InternetAddress(emailAddress, fullName);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(String.format("Not able to create InternetAddress for %s and %s", emailAddress, fullName));
        }
    }
}
