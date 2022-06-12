package com.aguilar.mailsender.service;

import com.aguilar.mailsender.controller.dto.SimpleMsgRequestDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService{

  @Autowired
  private JavaMailSender javaMailSender;

  @Override
  public void sendSimpleMessage(SimpleMsgRequestDTO simpleMsgRequestDTO) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("noreply@baeldung.com");
    message.setTo(simpleMsgRequestDTO.getMailTo());
    message.setSubject(simpleMsgRequestDTO.getMailsSubject());
    message.setText(simpleMsgRequestDTO.getMailBody());
    javaMailSender.send(message);
  }
}
