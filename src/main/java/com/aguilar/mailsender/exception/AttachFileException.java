package com.aguilar.mailsender.exception;

public class AttachFileException extends RuntimeException{

  public AttachFileException(String msg, Throwable err) {
    super(msg, err);
  }

}
