package com.service.fuex.engineer.email;

import com.service.fuex.web.exception.ResourceNotFoundExceotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class EmailConfig {
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String EMAIL_SENDER;
    @Value("${spring.mail.password}")
    private String PASSWORD_SENDER;

    public void sendEmail(String emailTo) throws ResourceNotFoundExceotion{
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(465);
        mailSender.setUsername(EMAIL_SENDER);
        mailSender.setPassword(PASSWORD_SENDER);

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        mailSender.setJavaMailProperties(properties);

        String from = EMAIL_SENDER;

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(emailTo);
        message.setSubject("Kode OTP Fuex Service ✔");
        message.setText("This is a kode otp : ");

        mailSender.send(message);
    }

}
