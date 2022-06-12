package com.aguilar.mailsender.controller.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class SimpleMsgRequestDTO {

  @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
  private String mailTo;

  private String mailsSubject;

  @NotBlank
  private String mailBody;
}
