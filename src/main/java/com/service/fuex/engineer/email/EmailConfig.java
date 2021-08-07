package com.service.fuex.engineer.email;

import com.service.fuex.web.exception.ResourceNotFoundExceotion;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Properties;

@Component
public class EmailConfig {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Configuration config;

    @Value("${spring.mail.username}")
    private String EMAIL_SENDER;
    @Value("${spring.mail.password}")
    private String PASSWORD_SENDER;

    public void sendEmail(String emailTo, Map<String, Object> components)throws IOException, TemplateException, MessagingException {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername(EMAIL_SENDER);
        mailSender.setPassword(PASSWORD_SENDER);
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        mailSender.setJavaMailProperties(properties);

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());
        Template t = config.getTemplate("email-login.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, components);
        String from = EMAIL_SENDER;
        helper.setTo(emailTo);
        helper.setText(html, true);
        helper.setSubject("OTP CODE Fuex Service");
        helper.setFrom(from);
        mailSender.send(message);
    }

}
