package com.example.demo.controller;

import com.example.demo.entity.Conjoint;
import com.example.demo.service.ConjointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conjoint")
public class ConjointController {

    @Autowired
    private ConjointService conjointService;

    // Get by CIN
    @GetMapping("/cinconjoint/{cin}")
    public ResponseEntity<Conjoint> getByCin(@PathVariable String cin) {
        Optional<Conjoint> conjoint = conjointService.getByCin(cin);
        return conjoint.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get by CIN_Fonctionnaire
    @GetMapping("/cin/{cinFonctionnaire}")
    public ResponseEntity<List<Conjoint>> getByCinFonctionnaire(@PathVariable String cinFonctionnaire) {
        List<Conjoint> conjoints = conjointService.getByCinFonctionnaire(cinFonctionnaire);
        if (conjoints.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(conjoints);
    }

    // Create or Update by CIN
    @PostMapping
    public ResponseEntity<Conjoint> createOrUpdate(@RequestBody Conjoint conjoint) {
        Conjoint savedConjoint = conjointService.saveOrUpdate(conjoint);
        return ResponseEntity.ok(savedConjoint);
    }

    // Delete by CIN_Fonctionnaire
    @DeleteMapping("/cin/{cinFonctionnaire}")
    public ResponseEntity<Void> deleteByCinFonctionnaire(@PathVariable String cinFonctionnaire) {
        conjointService.deleteByCinFonctionnaire(cinFonctionnaire);
        return ResponseEntity.noContent().build();
    }
}