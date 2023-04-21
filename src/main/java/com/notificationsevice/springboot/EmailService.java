package com.notificationsevice.springboot;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private final String senderEmail;
    private final String appPassword;

    public EmailService(JavaMailSender mailSender,
                        @Value("${email.sender}") String senderEmail,
                        @Value("${email.password}") String appPassword) {
        this.mailSender = mailSender;
        this.senderEmail = senderEmail;
        this.appPassword = appPassword;
    }
    public void sendEmail(String recipientEmail, String subject, String message) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(recipientEmail);
        helper.setSubject(subject);
        helper.setText(message, true);
        helper.setFrom(senderEmail);

        mailSender.send(mimeMessage);
    }
}