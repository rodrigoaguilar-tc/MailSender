package com.aguilar.mailsender.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SimpleMsgResponseDTO {

  private String sendTo;
  private String mailsSubject;
}
