package com.aguilar.mailsender.service;

import com.aguilar.mailsender.controller.dto.SimpleMsgRequestDTO;

public interface MailService {

  void sendSimpleMessage(SimpleMsgRequestDTO simpleMsgRequestDTO);
}
