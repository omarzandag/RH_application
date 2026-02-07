package com.example.demo.service;

import com.example.demo.entity.Affectation;
import com.example.demo.repository.AffectationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AffectationService {

    @Autowired
    private AffectationRepository affectationRepository;

    // Get all affectations
    public List<Affectation> getAllAffectations() {
        return affectationRepository.findAll();
    }

    // Get affectation by ID
    public Optional<Affectation> getAffectationById(Integer id) {
        return affectationRepository.findById(id);
    }

    // Get affectations by CIN_Fonctionnaire
    public List<Affectation> getAffectationsByCinFonctionnaire(String cinFonctionnaire) {
        return affectationRepository.findByCinFonctionnaire(cinFonctionnaire);
    }

    // Add a new affectation
    public Affectation addAffectation(Affectation affectation) {
        return affectationRepository.save(affectation);
    }

    // Update an existing affectation by ID
    public Affectation updateAffectation(Integer id, Affectation updatedAffectation) {
        Optional<Affectation> existingAffectation = affectationRepository.findById(id);
        if (existingAffectation.isPresent()) {
            Affectation affectation = existingAffectation.get();
            affectation.setEntite(updatedAffectation.getEntite());
            affectation.setDate(updatedAffectation.getDate());
            affectation.setPoste(updatedAffectation.getPoste());
            affectation.setCinFonctionnaire(updatedAffectation.getCinFonctionnaire());
            return affectationRepository.save(affectation);
        }
        return null; // or throw an exception
    }

    // Update affectation by CIN_Fonctionnaire
    public List<Affectation> updateAffectationsByCinFonctionnaire(String cinFonctionnaire, Affectation updatedAffectation) {
        List<Affectation> affectations = affectationRepository.findByCinFonctionnaire(cinFonctionnaire);
        affectations.forEach(affectation -> {
            affectation.setEntite(updatedAffectation.getEntite());
            affectation.setDate(updatedAffectation.getDate());
            affectation.setPoste(updatedAffectation.getPoste());
            affectation.setCinFonctionnaire(updatedAffectation.getCinFonctionnaire());
        });
        return affectationRepository.saveAll(affectations);
    }

    // Delete an affectation by ID
    public void deleteAffectationById(Integer id) {
        affectationRepository.deleteById(id);
    }

    // Delete affectations by CIN_Fonctionnaire
    public void deleteAffectationsByCinFonctionnaire(String cinFonctionnaire) {
        affectationRepository.deleteByCinFonctionnaire(cinFonctionnaire);
    }
}