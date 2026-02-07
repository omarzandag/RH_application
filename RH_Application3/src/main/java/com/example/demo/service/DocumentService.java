package com.example.demo.service;

import com.example.demo.*;
import com.example.demo.entity.Document;
import com.example.demo.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository repository;

    public Document saveDocument(String titre, String type, String cinFonctionnaire, MultipartFile file) throws IOException {
        Document doc = new Document();
        doc.setTitre(titre);
        doc.setType(type);
        doc.setCinFonctionnaire(cinFonctionnaire);
        doc.setFichier(file.getBytes());
        return repository.save(doc);
    }

    public Optional<Document> getDocumentById(Integer id) {
        return repository.findById(id);
    }

    public List<Document> getDocumentsByCin(String cin) {
        return repository.findByCinFonctionnaire(cin);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
