package com.example.webApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/appreoments")
public class Controller {

    @Autowired
    private PDFDataService pdfDataService;

    @Autowired
    private AppreomentRepository repository;

    @PostMapping("/parse")
    public List<Appreoment> parsePDF(@RequestParam("file") MultipartFile file) throws Exception {
        return pdfDataService.parsePDF(file);
    }

    @GetMapping("/search/name")
    public List<Appreoment> searchByName(@RequestParam("keyword") String keyword) {
        return repository.findByFullnameContainingIgnoreCase(keyword);
    }

    @GetMapping("/search/iin")
    public List<Appreoment> searchByIIN(@RequestParam("iin") String iin) {
        return repository.findByIctNumber(iin);
    }

    @GetMapping("/search/university")
    public List<Appreoment> searchByUniversity(@RequestParam("code") int code) {
        return repository.findByUniversityCode(code);
    }

    @GetMapping("/search/score")
    public List<Appreoment> searchByScoreRange(@RequestParam("min") int min, @RequestParam("max") int max) {
        return repository.findByScoreRange(min, max);
    }
}
