package com.example.demo.controller;

import com.example.demo.entity.Absence;
import com.example.demo.service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/absences")
public class AbsenceController {

    @Autowired
    private AbsenceService absenceService;

    // GET all absences
    @GetMapping
    public List<Absence> getAllAbsences() {
        return absenceService.getAllAbsences();
    }

    // GET absences by CIN_Fonctionnaire
    @GetMapping("/cin/{cinFonctionnaire}")
    public List<Absence> getAbsencesByCinFonctionnaire(@PathVariable String cinFonctionnaire) {
        return absenceService.getAbsencesByCinFonctionnaire(cinFonctionnaire);
    }

    // GET absence by ID
    @GetMapping("/{id}")
    public ResponseEntity<Absence> getAbsenceById(@PathVariable Integer id) {
        return absenceService.getAbsenceById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST a new absence
    @PostMapping
    public Absence createAbsence(@RequestBody Absence absence) {
        return absenceService.createAbsence(absence);
    }

    // PUT (update) an existing absence
    @PutMapping("/{id}")
    public ResponseEntity<Absence> updateAbsence(@PathVariable Integer id, @RequestBody Absence updatedAbsence) {
        try {
            Absence absence = absenceService.updateAbsence(id, updatedAbsence);
            return ResponseEntity.ok(absence);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/cin/{cinFonctionnaire}")
    public ResponseEntity<List<Absence>> updateAbsencesByCinFonctionnaire(
            @PathVariable String cinFonctionnaire,
            @RequestBody Absence updatedAbsence) {
        try {
            List<Absence> updatedAbsences = absenceService.updateAbsencesByCinFonctionnaire(cinFonctionnaire, updatedAbsence);
            return ResponseEntity.ok(updatedAbsences);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}