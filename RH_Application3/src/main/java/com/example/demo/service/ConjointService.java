package com.example.demo.service;

import com.example.demo.entity.Conjoint;
import com.example.demo.repository.ConjointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConjointService {

    @Autowired
    private ConjointRepository conjointRepository;

    // Get by CIN
    public Optional<Conjoint> getByCin(String cin) {
        return conjointRepository.findByCin(cin);
    }

    // Get by CIN_Fonctionnaire
    public List<Conjoint> getByCinFonctionnaire(String cinFonctionnaire) {
        return conjointRepository.findByCinFonctionnaire(cinFonctionnaire);
    }

    // Create or Update by CIN
    public Conjoint saveOrUpdate(Conjoint conjoint) {
        return conjointRepository.save(conjoint);
    }

    // Delete by CIN_Fonctionnaire
    public void deleteByCinFonctionnaire(String cinFonctionnaire) {
        conjointRepository.deleteByCinFonctionnaire(cinFonctionnaire);
    }
}