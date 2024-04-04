package com.harear.quraa.ocr;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BookOcrService {

  @Value("${quraa.book_absolute_path}")
  private String bookAbsolutePath;

  @Value("${quraa.book_directory}")
  private String bookDirectory;

  public void convert() {
    try {
      String sourceDir = bookAbsolutePath;
      String destinationDir = bookDirectory + "/pages/";

      File sourceFile = new File(sourceDir);
      File destinationFile = new File(destinationDir);
      if (!destinationFile.exists()) {
        destinationFile.mkdir();
      }
      if (sourceFile.exists()) {
        PDDocument document = PDDocument.load(sourceDir);
        List<PDPage> list = document.getDocumentCatalog().getAllPages();

        int pageNumber = 1;
        for (PDPage page : list) {
          File pageFile = new File(destinationDir + pageNumber + ".png");
          File txtFile = new File(destinationDir + pageNumber + ".txt");
          if (pageFile.exists() || txtFile.exists()) {
            pageNumber++;
            continue;
          }

          BufferedImage image = page.convertToImage(1, 240);
          File outputfile = new File(destinationDir + pageNumber + ".png");
          ImageIO.write(image, "png", outputfile);
          pageNumber++;
        }
        document.close();
      } else {
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}