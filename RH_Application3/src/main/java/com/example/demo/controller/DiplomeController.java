package com.example.demo.controller;

import com.example.demo.entity.Diplome;
import com.example.demo.service.DiplomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/diplomes")
public class DiplomeController {

    @Autowired
    private DiplomeService diplomeService;

    // Get diploma by ID
    @GetMapping("/{id}")
    public ResponseEntity<Diplome> getDiplomeById(@PathVariable Integer id) {
        Optional<Diplome> diplome = diplomeService.getDiplomeById(id);
        if (diplome.isPresent()) {
            return ResponseEntity.ok(diplome.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get diplomas by CIN_Fonctionnaire
    @GetMapping("/cin/{cinFonctionnaire}")
    public ResponseEntity<List<Diplome>> getDiplomesByCinFonctionnaire(@PathVariable String cinFonctionnaire) {
        List<Diplome> diplomes = diplomeService.getDiplomesByCinFonctionnaire(cinFonctionnaire);
        if (!diplomes.isEmpty()) {
            return ResponseEntity.ok(diplomes);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<Diplome> createDiplome(@RequestBody Diplome diplome) {
        Diplome savedDiplome = diplomeService.createDiplome(diplome);
        return ResponseEntity.status(201).body(savedDiplome);
    }

    // Delete a diploma by ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiplomeById(@PathVariable Integer id) {
        boolean deleted = diplomeService.deleteDiplomeById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update diplomas by CIN_Fonctionnaire (PUT)
    @PutMapping("/cin/{cinFonctionnaire}")
    public ResponseEntity<List<Diplome>> updateDiplomesByCinFonctionnaire(
            @PathVariable String cinFonctionnaire,
            @RequestBody Diplome updatedDiplome) {
        List<Diplome> updatedDiplomes = diplomeService.updateDiplomesByCinFonctionnaire(cinFonctionnaire, updatedDiplome);
        if (!updatedDiplomes.isEmpty()) {
            return ResponseEntity.ok(updatedDiplomes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}