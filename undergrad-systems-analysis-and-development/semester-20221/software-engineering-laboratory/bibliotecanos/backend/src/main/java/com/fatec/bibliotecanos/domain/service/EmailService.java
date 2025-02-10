package com.fatec.bibliotecanos.domain.service;

public interface EmailService {

    void sendMail(String toEmail,
                  String body,
                  String subject);

}
