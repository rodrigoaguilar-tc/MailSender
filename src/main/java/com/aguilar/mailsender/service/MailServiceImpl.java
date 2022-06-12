package com.aguilar.mailsender.service;

import com.aguilar.mailsender.controller.dto.SimpleMsgRequestDTO;
import com.aguilar.mailsender.controller.dto.SimpleMsgResponseDTO;
import com.aguilar.mailsender.exception.SendMailException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

  @Autowired
  private JavaMailSender javaMailSender;

  @Override
  public SimpleMsgResponseDTO sendSimpleMessage(SimpleMsgRequestDTO simpleMsgRequestDTO) {
    try {
      SimpleMailMessage message = new SimpleMailMessage();
      message.setFrom("noreply@baeldung.com");
      message.setTo(simpleMsgRequestDTO.getMailTo());
      message.setSubject(simpleMsgRequestDTO.getMailsSubject());
      message.setText(simpleMsgRequestDTO.getMailBody());
      javaMailSender.send(message);
      return SimpleMsgResponseDTO.builder()
          .sendTo(simpleMsgRequestDTO.getMailTo())
          .mailsSubject(simpleMsgRequestDTO.getMailsSubject())
          .build();
    } catch (MailException mailException) {
      throw new SendMailException("error al enviar mail", mailException.getCause());
    }

  }
}
