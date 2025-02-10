package com.fatec.bibliotecanos.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}") private String sender;

    @Override
    public void sendMail(String toEmail,
                         String body,
                         String subject) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(sender);
        mailMessage.setTo(toEmail);
        mailMessage.setText(body);
        mailMessage.setSubject(subject);

        javaMailSender.send(mailMessage);
    }

}