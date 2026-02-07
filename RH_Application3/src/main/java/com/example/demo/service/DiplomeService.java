package com.example.demo.service;

import com.example.demo.entity.Diplome;
import com.example.demo.repository.DiplomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiplomeService {

    @Autowired
    private DiplomeRepository diplomeRepository;

    // Get diploma by ID
    public Optional<Diplome> getDiplomeById(Integer id) {
        return diplomeRepository.findById(id);
    }

    // Get diplomas by CIN_Fonctionnaire
    public List<Diplome> getDiplomesByCinFonctionnaire(String cinFonctionnaire) {
        return diplomeRepository.findByCinFonctionnaire(cinFonctionnaire);
    }

    public Diplome createDiplome(Diplome diplome) {
        return diplomeRepository.save(diplome);
    }

    // Delete a diploma by ID
    public boolean deleteDiplomeById(Integer id) {
        Optional<Diplome> diplome = diplomeRepository.findById(id);
        if (diplome.isPresent()) {
            diplomeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Update diplomas by CIN_Fonctionnaire
    public List<Diplome> updateDiplomesByCinFonctionnaire(String cinFonctionnaire, Diplome updatedDiplome) {
        List<Diplome> diplomes = diplomeRepository.findByCinFonctionnaire(cinFonctionnaire);
        if (!diplomes.isEmpty()) {
            for (Diplome diplome : diplomes) {
                diplome.setIntitule(updatedDiplome.getIntitule());
                diplome.setSpecialite(updatedDiplome.getSpecialite());
                diplome.setDateObtention(updatedDiplome.getDateObtention());
                diplome.setEtablissement(updatedDiplome.getEtablissement());
                diplomeRepository.save(diplome);
            }
        }
        return diplomes;
    }
}