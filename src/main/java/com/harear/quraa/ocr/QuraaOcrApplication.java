package com.harear.quraa.ocr;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuraaOcrApplication {

  @Autowired
  private BookOcrService bookOcrService;

  public static void main(String[] args) {
    SpringApplication.run(QuraaOcrApplication.class, args);
  }

  @PostConstruct
  public void init() {
    bookOcrService.convert();
  }
}
