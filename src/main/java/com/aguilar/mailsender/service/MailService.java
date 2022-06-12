package com.aguilar.mailsender.service;

import com.aguilar.mailsender.controller.dto.SimpleMsgRequestDTO;
import com.aguilar.mailsender.controller.dto.SimpleMsgResponseDTO;

public interface MailService {

  SimpleMsgResponseDTO sendSimpleMessage(SimpleMsgRequestDTO simpleMsgRequestDTO);
}
