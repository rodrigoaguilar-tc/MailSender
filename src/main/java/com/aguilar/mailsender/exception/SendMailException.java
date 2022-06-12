package com.aguilar.mailsender.exception;

public class SendMailException extends RuntimeException{

  public SendMailException(String msg, Throwable err) {
    super(msg, err);
  }
}
