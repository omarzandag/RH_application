package com.example.demo.controller;

import com.example.demo.entity.Adresse;
import com.example.demo.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adresses")
public class AdresseController {

    @Autowired
    private AdresseService adresseService;

    // Get an address by CIN_Fonctionnaire
    @GetMapping("/cin/{cin}")
    public ResponseEntity<Adresse> getAdresseByCin(@PathVariable String cin) {
        return adresseService.getAdresseByCin(cin)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Adresse> createAdresse(@RequestBody Adresse adresse) {
        Adresse createdAdresse = adresseService.createAdresse(adresse);
        return ResponseEntity.ok(createdAdresse);
    }
    // Update an address by CIN_Fonctionnaire
    @PutMapping("/cin/{cin}")
    public ResponseEntity<Adresse> updateAdresseByCin(@PathVariable String cin, @RequestBody Adresse updatedAdresse) {
        Adresse adresse = adresseService.updateAdresseByCin(cin, updatedAdresse);
        return ResponseEntity.ok(adresse);
    }

    // Delete an address by CIN_Fonctionnaire
    @DeleteMapping("/cin/{cin}")
    public ResponseEntity<Void> deleteAdresseByCin(@PathVariable String cin) {
        adresseService.deleteAdresseByCin(cin);
        return ResponseEntity.noContent().build();
    }
}