package com.aguilar.mailsender.service;

import com.aguilar.mailsender.model.dto.SimpleMsgRequestDTO;
import com.aguilar.mailsender.model.dto.SimpleMsgResponseDTO;

public interface MailService {

  SimpleMsgResponseDTO sendSimpleMessage(SimpleMsgRequestDTO simpleMsgRequestDTO);
}
