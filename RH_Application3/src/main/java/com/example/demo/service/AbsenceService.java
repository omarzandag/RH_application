package com.example.demo.service;

import com.example.demo.entity.Absence;
import com.example.demo.repository.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbsenceService {

    @Autowired
    private AbsenceRepository absenceRepository;

    // Get all absences
    public List<Absence> getAllAbsences() {
        return absenceRepository.findAll();
    }

    // Get absences by CIN_Fonctionnaire
    public List<Absence> getAbsencesByCinFonctionnaire(String cinFonctionnaire) {
        return absenceRepository.findByCinFonctionnaire(cinFonctionnaire);
    }

    // Get absence by ID
    public Optional<Absence> getAbsenceById(Integer id) {
        return absenceRepository.findById(id);
    }

    // Create a new absence
    public Absence createAbsence(Absence absence) {
        return absenceRepository.save(absence);
    }

    // Update an existing absence
    public Absence updateAbsence(Integer id, Absence updatedAbsence) {
        return absenceRepository.findById(id).map(absence -> {
            absence.setTypeAbsence(updatedAbsence.getTypeAbsence());
            absence.setDateDepart(updatedAbsence.getDateDepart());
            absence.setNombreJours(updatedAbsence.getNombreJours());
            absence.setRemplacant(updatedAbsence.getRemplacant());
            absence.setCinFonctionnaire(updatedAbsence.getCinFonctionnaire());
            return absenceRepository.save(absence);
        }).orElseThrow(() -> new RuntimeException("Absence not found with ID: " + id));
    }

    public List<Absence> updateAbsencesByCinFonctionnaire(String cinFonctionnaire, Absence updatedAbsence) {
        List<Absence> absences = absenceRepository.findByCinFonctionnaire(cinFonctionnaire);
        if (absences.isEmpty()) {
            throw new RuntimeException("No absences found for CIN_Fonctionnaire: " + cinFonctionnaire);
        }

        // Update each absence record
        absences.forEach(absence -> {
            absence.setTypeAbsence(updatedAbsence.getTypeAbsence());
            absence.setDateDepart(updatedAbsence.getDateDepart());
            absence.setNombreJours(updatedAbsence.getNombreJours());
            absence.setRemplacant(updatedAbsence.getRemplacant());
        });

        return absenceRepository.saveAll(absences);
    }
}