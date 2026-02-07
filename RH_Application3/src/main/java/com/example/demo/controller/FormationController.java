package com.example.demo.controller;

import com.example.demo.entity.Formation;
import com.example.demo.service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formations")
public class FormationController {

    @Autowired
    private FormationService formationService;

    // Get all formations
    @GetMapping
    public List<Formation> getAllFormations() {
        return formationService.getAllFormations();
    }

    // Get a formation by ID
    @GetMapping("/{id}")
    public ResponseEntity<Formation> getFormationById(@PathVariable Integer id) {
        return formationService.getFormationById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new formation
    @PostMapping
    public Formation createFormation(@RequestBody Formation formation) {
        return formationService.saveFormation(formation);
    }

    // Update an existing formation
    @PutMapping("/{id}")
    public ResponseEntity<Formation> updateFormation(@PathVariable Integer id, @RequestBody Formation updatedFormation) {
        try {
            Formation formation = formationService.updateFormation(id, updatedFormation);
            return ResponseEntity.ok(formation);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a formation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormation(@PathVariable Integer id) {
        formationService.deleteFormation(id);
        return ResponseEntity.noContent().build();
    }
}