package nl.aalten.emera.api.email;

import lombok.Builder;
import lombok.NonNull;

@Builder(builderClassName = "Builder")
public class MailConfig {

    @NonNull
    public String userName;

    @NonNull
    public String password;

    @NonNull
    public String smtpHostName;


}
