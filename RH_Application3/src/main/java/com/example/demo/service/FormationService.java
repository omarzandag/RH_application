package com.example.demo.service;

import com.example.demo.entity.Formation;
import com.example.demo.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormationService {

    @Autowired
    private FormationRepository formationRepository;

    // Get all formations
    public List<Formation> getAllFormations() {
        return formationRepository.findAll();
    }

    // Get a formation by ID
    public Optional<Formation> getFormationById(Integer id) {
        return formationRepository.findById(id);
    }

    // Save a new formation
    public Formation saveFormation(Formation formation) {
        return formationRepository.save(formation);
    }

    // Update an existing formation
    public Formation updateFormation(Integer id, Formation updatedFormation) {
        return formationRepository.findById(id).map(formation -> {
            formation.setPrestataire(updatedFormation.getPrestataire());
            formation.setFormateur(updatedFormation.getFormateur());
            formation.setDateDebut(updatedFormation.getDateDebut());
            formation.setDateFin(updatedFormation.getDateFin());
            formation.setLieu(updatedFormation.getLieu());
            formation.setListeBeneficiaires(updatedFormation.getListeBeneficiaires());
            return formationRepository.save(formation);
        }).orElseThrow(() -> new RuntimeException("Formation not found with ID: " + id));
    }

    // Delete a formation by ID
    public void deleteFormation(Integer id) {
        formationRepository.deleteById(id);
    }
}