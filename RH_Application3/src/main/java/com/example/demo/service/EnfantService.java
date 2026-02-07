package com.example.demo.service;

import com.example.demo.entity.Enfant;
import com.example.demo.repository.EnfantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnfantService {

    @Autowired
    private EnfantRepository enfantRepository;

    // Get all enfants
    public List<Enfant> getAllEnfants() {
        return enfantRepository.findAll();
    }

    // Get all enfants by CIN
    public List<Enfant> getAllEnfantsByCIN(String cin) {
        return enfantRepository.findByCinFonctionnaire(cin);
    }

    // Create a new enfant
    public Enfant createEnfant(Enfant enfant) {
        return enfantRepository.save(enfant);
    }

    // Update an existing enfant by ID
    public Enfant updateEnfant(Integer id, Enfant updatedEnfant) {
        return enfantRepository.findById(id)
                .map(enfant -> {
                    enfant.setPrenom(updatedEnfant.getPrenom());
                    enfant.setNomMere(updatedEnfant.getNomMere());
                    enfant.setDateNaissance(updatedEnfant.getDateNaissance());
                    enfant.setCinFonctionnaire(updatedEnfant.getCinFonctionnaire());
                    return enfantRepository.save(enfant);
                })
                .orElseThrow(() -> new RuntimeException("Enfant not found with ID: " + id));
    }
}