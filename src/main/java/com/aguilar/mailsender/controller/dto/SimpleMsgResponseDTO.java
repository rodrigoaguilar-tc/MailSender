package com.aguilar.mailsender.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SimpleMsgResponseDTO {

  private String sendTo;
  private String mailsSubject;
}
