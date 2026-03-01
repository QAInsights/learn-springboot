package org.qainsights.learningspringboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NewEmailNotificationService implements NewNotificationService{

    @Value("${email.smtpHost}")
    private String smtpHost;

    @Value("${email.smtpPort}")
    private int smtpPort;

    @Override
    public void send(String message, String recipientEmail) {
        System.out.println("Sending email to " + recipientEmail + " with message " + message);
        System.out.println("Sending email using " + smtpHost + ":" + smtpPort);
    }
}
