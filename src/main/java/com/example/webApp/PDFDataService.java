package com.example.webApp;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PDFDataService {

    @Autowired
    private AppreomentRepository repository;

    public List<Appreoment> parsePDF(MultipartFile file) throws Exception {
        List<Appreoment> list = new ArrayList<>();

        try (PDDocument document = PDDocument.load(file.getInputStream())) {
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);

            Pattern pattern = Pattern.compile("(\\d+)\\s+(\\d{9})\\s+([\\p{L}\\s\\-]+?)\\s+(\\d+)\\s+(\\d{3})", Pattern.MULTILINE);
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                String ict = matcher.group(2);
                String name = matcher.group(3).trim().replaceAll("\\s+", " ");
                int score = Integer.parseInt(matcher.group(4));
                int code = Integer.parseInt(matcher.group(5));
                list.add(new Appreoment(ict, name, score, code));
            }

            // Save to database
            repository.saveAll(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
