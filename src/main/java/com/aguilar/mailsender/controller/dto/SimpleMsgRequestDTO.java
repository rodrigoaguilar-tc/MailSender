package com.aguilar.mailsender.controller.dto;

import lombok.Data;

@Data
public class SimpleMsgRequestDTO {

  private String mailTo;
  private String mailsSubject;
  private String mailBody;
}
