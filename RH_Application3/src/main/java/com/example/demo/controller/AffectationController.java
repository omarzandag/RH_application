package com.example.demo.controller;

import com.example.demo.entity.Affectation;
import com.example.demo.service.AffectationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/affectations")
public class AffectationController {

    @Autowired
    private AffectationService affectationService;

    // GET all affectations
    @GetMapping
    public List<Affectation> getAllAffectations() {
        return affectationService.getAllAffectations();
    }

    // GET affectation by ID
    @GetMapping("/{id}")
    public ResponseEntity<Affectation> getAffectationById(@PathVariable Integer id) {
        Optional<Affectation> affectation = affectationService.getAffectationById(id);
        return affectation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // GET affectations by CIN_Fonctionnaire
    @GetMapping("/cin/{cinFonctionnaire}")
    public List<Affectation> getAffectationsByCinFonctionnaire(@PathVariable String cinFonctionnaire) {
        return affectationService.getAffectationsByCinFonctionnaire(cinFonctionnaire);
    }

    // POST a new affectation
    @PostMapping
    public Affectation createAffectation(@RequestBody Affectation affectation) {
        return affectationService.addAffectation(affectation);
    }

    // PUT update affectation by ID
    @PutMapping("/{id}")
    public ResponseEntity<Affectation> updateAffectation(@PathVariable Integer id, @RequestBody Affectation updatedAffectation) {
        Affectation affectation = affectationService.updateAffectation(id, updatedAffectation);
        return affectation != null ? ResponseEntity.ok(affectation) : ResponseEntity.notFound().build();
    }

    // PUT update affectations by CIN_Fonctionnaire
    @PutMapping("/cin/{cinFonctionnaire}")
    public List<Affectation> updateAffectationsByCinFonctionnaire(@PathVariable String cinFonctionnaire, @RequestBody Affectation updatedAffectation) {
        return affectationService.updateAffectationsByCinFonctionnaire(cinFonctionnaire, updatedAffectation);
    }

    // DELETE affectation by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAffectation(@PathVariable Integer id) {
        affectationService.deleteAffectationById(id);
        return ResponseEntity.noContent().build();
    }

    // DELETE affectations by CIN_Fonctionnaire
    @DeleteMapping("/cin/{cinFonctionnaire}")
    public ResponseEntity<Void> deleteAffectationsByCinFonctionnaire(@PathVariable String cinFonctionnaire) {
        affectationService.deleteAffectationsByCinFonctionnaire(cinFonctionnaire);
        return ResponseEntity.noContent().build();
    }
}