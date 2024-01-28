package com.harear.pdftoimage;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PdfToImageApplication {

  @Value("${quoraa.book}")
  private String bookName;

  @Autowired
  private BookToImagesService bookToImagesService;

  public static void main(String[] args) {
    SpringApplication.run(PdfToImageApplication.class, args);
  }

  @PostConstruct
  public void init() {
    bookToImagesService.convert(bookName);
  }
}
