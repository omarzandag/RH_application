package com.example.demo.service;

import com.example.demo.entity.PrevoyanceSociale;
import com.example.demo.repository.PrevoyanceSocialeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrevoyanceSocialeService {

    @Autowired
    private PrevoyanceSocialeRepository repository;

    // Get by CIN
    public Optional<PrevoyanceSociale> getByCin(String cin) {
        return repository.findByCinFonctionnaire(cin);
    }

    // Create (POST)
    public PrevoyanceSociale create(PrevoyanceSociale prevoyanceSociale) {
        return repository.save(prevoyanceSociale);
    }

    // Update (PUT)
    public PrevoyanceSociale updateByCin(String cin, PrevoyanceSociale updatedData) {
        Optional<PrevoyanceSociale> existingData = repository.findByCinFonctionnaire(cin);
        if (existingData.isPresent()) {
            PrevoyanceSociale prevoyance = existingData.get();
            prevoyance.setOrganismeRetraite(updatedData.getOrganismeRetraite());
            prevoyance.setNumeroAffiliationRetraite(updatedData.getNumeroAffiliationRetraite());
            prevoyance.setDateAffiliationRetraite(updatedData.getDateAffiliationRetraite());
            prevoyance.setOrganismePrevoyance(updatedData.getOrganismePrevoyance());
            prevoyance.setNumeroCNOPS(updatedData.getNumeroCNOPS());
            prevoyance.setNumeroImmatriculationCNOPS(updatedData.getNumeroImmatriculationCNOPS());
            prevoyance.setDateAffiliationCNOPS(updatedData.getDateAffiliationCNOPS());
            prevoyance.setNaffiliationFHassanII(updatedData.getNaffiliationFHassanII());
            prevoyance.setOrganisationAssurance(updatedData.getOrganisationAssurance());
            prevoyance.setnAffiliationAssurance(updatedData.getnAffiliationAssurance());
            prevoyance.setCinFonctionnaire(updatedData.getCinFonctionnaire());
            return repository.save(prevoyance);
        }
        throw new RuntimeException("Record not found with CIN: " + cin);
    }
}