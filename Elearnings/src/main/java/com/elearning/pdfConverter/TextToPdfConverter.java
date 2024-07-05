package com.elearning.pdfConverter;

public class TextToPdfConverter {
	
	
	
	/*
	 * 
	 * Text to Pdf Converter code 
	 * 
	 *        controller code
	 *        
	 *        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ConversionController {

    @Autowired
    private TextToPdfConverter converter;

    @PostMapping("/convert")
    public ResponseEntity<byte[]> convertTextFile(@RequestParam("file") MultipartFile file) throws IOException {
        byte[] pdfBytes = converter.convertTextToPdf(file.getOriginalFilename());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "converted.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfBytes);
    }
}
	 *        
	 *        *********************************************************
	 *        
	 *        Service Code 
	 *        
	 *        import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class TextToPdfConverter {

    public byte[] convertTextToPdf(String textFilePath) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(baos);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        String textContent = Files.readString(Paths.get(textFilePath));
        document.add(new Paragraph(textContent));

        document.close();
        return baos.toByteArray();
    }
}

	 * 
	 * */

}
