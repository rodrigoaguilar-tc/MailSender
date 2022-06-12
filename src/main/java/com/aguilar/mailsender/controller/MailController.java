package com.aguilar.mailsender.controller;

import com.aguilar.mailsender.controller.dto.SimpleMsgRequestDTO;
import com.aguilar.mailsender.controller.dto.SimpleMsgResponseDTO;
import com.aguilar.mailsender.service.MailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/sendMail")
public class MailController {

  @Autowired
  MailService mailService;

  @PostMapping("/simpleMail")
  public ResponseEntity<SimpleMsgResponseDTO> sendMail(@Valid @RequestBody SimpleMsgRequestDTO simpleMsgRequestDTO) {
    return new ResponseEntity<>(mailService.sendSimpleMessage(simpleMsgRequestDTO), HttpStatus.OK);
  }
}
