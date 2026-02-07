package com.example.demo.service;

import com.example.demo.entity.Fonctionnaire;
import com.example.demo.repository.FonctionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FonctionnaireService {

    @Autowired
    private FonctionnaireRepository fonctionnaireRepository;

    public List<Fonctionnaire> getAllFonctionnaires() {
        return fonctionnaireRepository.findAll();
    }

    public Fonctionnaire getFonctionnaireByCin(String cin) {
        return fonctionnaireRepository.findById(cin).orElse(null);
    }

    public Fonctionnaire createOrUpdateFonctionnaire(Fonctionnaire fonctionnaire) {
        return fonctionnaireRepository.save(fonctionnaire);
    }

    public void deleteFonctionnaire(String cin) {
        fonctionnaireRepository.deleteById(cin);
    }
}