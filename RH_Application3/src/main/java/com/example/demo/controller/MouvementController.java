package com.example.demo.controller;

import com.example.demo.entity.Mouvement;
import com.example.demo.service.MouvementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mouvements")
public class MouvementController {

    @Autowired
    private MouvementService mouvementService;

    // Create a new Mouvement
    @PostMapping
    public ResponseEntity<Mouvement> createMouvement(@RequestBody Mouvement mouvement) {
        Mouvement createdMouvement = mouvementService.createMouvement(mouvement);
        return ResponseEntity.ok(createdMouvement);
    }

    // Get all Mouvements
    @GetMapping
    public ResponseEntity<List<Mouvement>> getAllMouvements() {
        List<Mouvement> mouvements = mouvementService.getAllMouvements();
        return ResponseEntity.ok(mouvements);
    }

    // Get Mouvement by CIN and ID
    @GetMapping("/cin/{cin}")
    public ResponseEntity<List<Mouvement>> getAllMouvementsByCin(@PathVariable String cin) {
        List<Mouvement> mouvements = mouvementService.getAllMouvementsByCin(cin);
        if (mouvements.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mouvements);
    }

    // Update all Mouvements by CIN_Fonctionnaire
    @PutMapping("/cin/{cin}")
    public ResponseEntity<List<Mouvement>> updateAllMouvementsByCin(
            @PathVariable String cin,
            @RequestBody Mouvement updatedMouvement) {
        List<Mouvement> updatedMouvements = mouvementService.updateAllMouvementsByCin(cin, updatedMouvement);
        if (updatedMouvements.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedMouvements);
    }

    // Delete Mouvement by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMouvementById(@PathVariable Integer id) {
        mouvementService.deleteMouvementById(id);
        return ResponseEntity.noContent().build();
    }

    // Delete Mouvements by CIN
    @DeleteMapping("/cin/{cin}")
    public ResponseEntity<Void> deleteMouvementsByCin(@PathVariable String cin) {
        mouvementService.deleteMouvementsByCin(cin);
        return ResponseEntity.noContent().build();
    }
}