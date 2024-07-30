package uz.app.jdbcapp.service;

import lombok.SneakyThrows;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailService {
    @SneakyThrows
    public void sendSmsToUser(String email, String text) {
        String subject = "Account Confirmation";
        String htmlContent = String.format("Please click this <a href=\"http://10.10.2.142:8080/auth?confirmation=%s\">link</a> in order to confirm your account", text);

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("abror01042001@gmail.com", "yrdvdspgimmmovpd");
            }
        };

        Session session = Session.getInstance(properties, auth);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("abror01042001@gmail.com"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject(subject);
            message.setContent(htmlContent, "text/html");

            Transport.send(message);
            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Failed to send email.");
        }

    }

    private static EmailService emailService;
    public static EmailService getInstance() {
        if (emailService == null) {
            emailService = new EmailService();
        }
        return emailService;
    }
}
