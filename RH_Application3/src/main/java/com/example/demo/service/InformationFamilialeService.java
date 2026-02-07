package com.example.demo.service;

import com.example.demo.entity.InformationFamiliale;
import com.example.demo.repository.InformationFamilialeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformationFamilialeService {

    @Autowired
    private InformationFamilialeRepository informationFamilialeRepository;

    public List<InformationFamiliale> getAllInformationFamiliale() {
        return informationFamilialeRepository.findAll();
    }

    public Optional<InformationFamiliale> getInformationFamilialeByCin(String cinFonctionnaire) {
        return informationFamilialeRepository.findById(cinFonctionnaire);
    }

    public InformationFamiliale saveInformationFamiliale(InformationFamiliale informationFamiliale) {
        return informationFamilialeRepository.save(informationFamiliale);
    }

    public void deleteInformationFamiliale(String cinFonctionnaire) {
        informationFamilialeRepository.deleteById(cinFonctionnaire);
    }
}