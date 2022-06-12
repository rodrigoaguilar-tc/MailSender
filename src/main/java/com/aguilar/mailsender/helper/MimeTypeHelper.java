package com.aguilar.mailsender.helper;

import org.apache.tika.Tika;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Component
public class MimeTypeHelper {

  public String getFileExtension(String base64) {
    byte[] base64Bytes = Base64.getDecoder().decode(base64);
    Tika tika = new Tika();
    String fileType = tika.detect(base64Bytes);
    return getMimeTypeMap().get(fileType);
  }

  private Map<String, String> getMimeTypeMap() {
    Map<String, String> mimeTypeMap = new HashMap<>();
    mimeTypeMap.put("application/pdf", ".pdf");
    mimeTypeMap.put("application/msword", ".doc");
    mimeTypeMap.put("application/vnd.openxmlformats-officedocument.wordprocessingml.document", ".docx");
    mimeTypeMap.put("image/png", ".png");
    return mimeTypeMap;
  }
}
