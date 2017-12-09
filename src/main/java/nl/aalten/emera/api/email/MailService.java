package nl.aalten.emera.api.email;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class MailService {

    private final MailConfig mailConfig;
    private Properties properties;
    private Session session;

    public MailService(MailConfig mailConfig) {
        this.mailConfig = mailConfig;
        createProperties();
        this.session = createSession();
    }

    public void sendMail
        (
            List<EmailAddress> recipients,
            EmailAddress from,
            EmailAddress replyTo,
            String subject,
            String htmlMessage
    ) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = new MimeMessage(session);
        message.addHeader("Content-type", "text/HTML; charset=UTF-8");
        message.setFrom(from.toInternetAddress());
        message.setReplyTo(new Address[] {replyTo.toInternetAddress()});
        message.setSubject(subject);
        message.setText(htmlMessage, "UTF-8", "html");
        message.setSentDate(new Date());
        message.setRecipients(Message.RecipientType.TO, toAddresses(recipients));

        Transport.send(message);
    }

    private Address[] toAddresses(List<EmailAddress> recipients) {
        Address[] toAddresses = new Address[recipients.size()];
        int index = 0;
        for (EmailAddress emailAddress : recipients) {
            toAddresses[index] = emailAddress.toInternetAddress();
            index++;
        }
        return toAddresses;
    }

    private void createProperties() {
        this.properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", mailConfig.smtpHostName);
    }

    private Session createSession() {
        return  Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(mailConfig.userName, mailConfig.password);
                    }
                });
    }


}
