package com.example.demo.controller;

import com.example.demo.entity.Enfant;
import com.example.demo.service.EnfantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enfants")
public class EnfantController {

    @Autowired
    private EnfantService enfantService;

    // Get all enfants
    @GetMapping
    public ResponseEntity<List<Enfant>> getAllEnfants() {
        return ResponseEntity.ok(enfantService.getAllEnfants());
    }

    // Get all enfants by CIN
    @GetMapping("/cin/{cin}")
    public ResponseEntity<List<Enfant>> getAllEnfantsByCIN(@PathVariable String cin) {
        return ResponseEntity.ok(enfantService.getAllEnfantsByCIN(cin));
    }

    // Create a new enfant
    @PostMapping
    public ResponseEntity<Enfant> createEnfant(@RequestBody Enfant enfant) {
        return ResponseEntity.ok(enfantService.createEnfant(enfant));
    }

    // Update an existing enfant by ID
    @PutMapping("/{id}")
    public ResponseEntity<Enfant> updateEnfant(@PathVariable Integer id, @RequestBody Enfant updatedEnfant) {
        return ResponseEntity.ok(enfantService.updateEnfant(id, updatedEnfant));
    }
}