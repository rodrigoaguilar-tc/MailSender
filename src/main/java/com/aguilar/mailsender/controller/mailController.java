package com.aguilar.mailsender.controller;

import com.aguilar.mailsender.controller.dto.SimpleMsgRequestDTO;
import com.aguilar.mailsender.service.MailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sendMail")
public class mailController {

  @Autowired
  MailService mailService;

  @PostMapping("/plainHTML")
  public ResponseEntity<Boolean> sendMail(@RequestBody SimpleMsgRequestDTO simpleMsgRequestDTO) {
    mailService.sendSimpleMessage(simpleMsgRequestDTO);
    return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
  }
}
