package com.aguilar.mailsender.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class JavaMailSenderConfig {

  @Value("${spring.mail.host}")
  String mailHost;

  @Value("${spring.mail.port}")
  Integer mailPort;

  @Value("${spring.mail.username}")
  String mailUsername;

  @Value("${spring.mail.password}")
  String mailPassword;

  @Value("${spring.mail.properties.mail.transport.protocol}")
  String mailProtocol;

  @Value("${spring.mail.properties.mail.smtp.auth}")
  String mailAuth;

  @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
  String mailStartTTLS;

  @Value("${spring.mail.properties.mail.debug}")
  String mailDebug;

  @Bean
  public JavaMailSender getJavaMailSender() {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost(mailHost);
    mailSender.setPort(mailPort);

    mailSender.setUsername(mailUsername);
    mailSender.setPassword(mailPassword);

    Properties props = mailSender.getJavaMailProperties();
    props.put("mail.transport.protocol", mailProtocol);
    props.put("mail.smtp.auth", mailAuth);
    props.put("mail.smtp.starttls.enable", mailStartTTLS);
    props.put("mail.debug", mailDebug);

    return mailSender;
  }
}
