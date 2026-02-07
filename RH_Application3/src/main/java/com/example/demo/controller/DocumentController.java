package com.example.demo.controller;


import com.example.demo.entity.Document;
import com.example.demo.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    @Autowired
    private DocumentService service;

    @PostMapping
    public ResponseEntity<Document> uploadDocument(
            @RequestParam String titre,
            @RequestParam String type,
            @RequestParam String cinFonctionnaire,
            @RequestParam("file") MultipartFile file) {
        try {
            Document doc = service.saveDocument(titre, type, cinFonctionnaire, file);
            return ResponseEntity.ok(doc);
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Document> getById(@PathVariable Integer id) {
        return service.getDocumentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cin/{cin}")
    public ResponseEntity<List<Document>> getByCin(@PathVariable String cin) {
        return ResponseEntity.ok(service.getDocumentsByCin(cin));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadDocument(@PathVariable Integer id) {
        Optional<Document> optionalDoc = service.getDocumentById(id);

        if (optionalDoc.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Document doc = optionalDoc.get();

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=\"" + doc.getTitre() + "." + doc.getType().toLowerCase() + "\"")
                .header("Content-Type", "application/octet-stream")
                .body(doc.getFichier());
    }

}
