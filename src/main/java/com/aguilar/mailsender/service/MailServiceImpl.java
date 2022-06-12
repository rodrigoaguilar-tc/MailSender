package com.aguilar.mailsender.service;

import com.aguilar.mailsender.exception.AttachFileException;
import com.aguilar.mailsender.exception.SendMailException;
import com.aguilar.mailsender.helper.MimeTypeHelper;
import com.aguilar.mailsender.model.dto.SimpleMsgRequestDTO;
import com.aguilar.mailsender.model.dto.SimpleMsgResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Objects;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService {

  @Autowired
  private JavaMailSender javaMailSender;

  @Autowired
  private MimeTypeHelper mimeTypeHelper;

  @Override
  public SimpleMsgResponseDTO sendSimpleMessage(SimpleMsgRequestDTO simpleMsgRequestDTO) {
    try {
      MimeMessage message = createMimeMessage(simpleMsgRequestDTO);
      javaMailSender.send(message);
      return SimpleMsgResponseDTO.builder()
          .sendTo(simpleMsgRequestDTO.getMailTo())
          .mailsSubject(simpleMsgRequestDTO.getMailsSubject())
          .build();
    } catch (MailException mailException) {
      throw new SendMailException("send mail error", mailException.getCause());
    } catch (MessagingException messagingException) {
      throw new SendMailException("fail creating mime message", messagingException.getCause());
    }
  }

  private MimeMessage createMimeMessage(SimpleMsgRequestDTO simpleMsgRequestDTO)
      throws MessagingException {
    MimeMessage message = javaMailSender.createMimeMessage();

    MimeMessageHelper helper = new MimeMessageHelper(message, true);

    helper.setTo(simpleMsgRequestDTO.getMailTo());
    helper.setSubject(simpleMsgRequestDTO.getMailsSubject());
    helper.setText(simpleMsgRequestDTO.getMailBody());

    if (Objects.nonNull(simpleMsgRequestDTO.getBase64AttachFiles())) {
      simpleMsgRequestDTO.getBase64AttachFiles().forEach(attach -> {
        byte[] file = Base64.getDecoder().decode(attach);
        try {
          String fileName = "attach" + mimeTypeHelper.getFileExtension(attach);
          helper.addAttachment(fileName, new ByteArrayResource(file));
        } catch (MessagingException messagingException) {
          throw new AttachFileException("attach file error", messagingException.getCause());
        }
      });
    }
    return message;
  }

}
