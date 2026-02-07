package com.example.demo.controller;

import com.example.demo.entity.Fonctionnaire;
import com.example.demo.service.FonctionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fonctionnaires")
public class FonctionnaireController {

    @Autowired
    private FonctionnaireService fonctionnaireService;

    // Get all fonctionnaires
    @GetMapping
    public List<Fonctionnaire> getAllFonctionnaires() {
        return fonctionnaireService.getAllFonctionnaires();
    }

    // Get a fonctionnaire by CIN
    @GetMapping("/cin/{cin}")
    public ResponseEntity<Fonctionnaire> getFonctionnaireByCin(@PathVariable String cin) {
        Fonctionnaire fonctionnaire = fonctionnaireService.getFonctionnaireByCin(cin);
        if (fonctionnaire != null) {
            return ResponseEntity.ok(fonctionnaire);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update a fonctionnaire by CIN
    @PutMapping("/cin/{cin}")
    public ResponseEntity<Fonctionnaire> updateFonctionnaire(@PathVariable String cin, @RequestBody Fonctionnaire updatedFonctionnaire) {

        if (!cin.equals(updatedFonctionnaire.getCin())) {
            return ResponseEntity.badRequest().build();
        }

        Fonctionnaire fonctionnaire = fonctionnaireService.createOrUpdateFonctionnaire(updatedFonctionnaire);
        if (fonctionnaire != null) {
            return ResponseEntity.ok(fonctionnaire);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // Create or update a fonctionnaire
    // Create a new fonctionnaire
    @PostMapping
    public ResponseEntity<Fonctionnaire> createFonctionnaire(@RequestBody Fonctionnaire fonctionnaire) {
        // Check if a fonctionnaire with the same CIN already exists
        if (fonctionnaireService.getFonctionnaireByCin(fonctionnaire.getCin()) != null) {
            return ResponseEntity.status(409).build(); // 409 Conflict: Resource already exists
        }

        // Save the new fonctionnaire
        Fonctionnaire savedFonctionnaire = fonctionnaireService.createOrUpdateFonctionnaire(fonctionnaire);
        return ResponseEntity.status(201).body(savedFonctionnaire); // 201 Created: Resource successfully created
    }

    // Delete a fonctionnaire by CIN
    @DeleteMapping("/cin/{cin}")
    public ResponseEntity<Void> deleteFonctionnaire(@PathVariable String cin) {
        fonctionnaireService.deleteFonctionnaire(cin);
        return ResponseEntity.noContent().build();
    }
}