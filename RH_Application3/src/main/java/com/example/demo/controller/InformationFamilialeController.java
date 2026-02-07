package com.example.demo.controller;

import com.example.demo.entity.InformationFamiliale;
import com.example.demo.service.InformationFamilialeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/information-familiale")
public class InformationFamilialeController {

    @Autowired
    private InformationFamilialeService informationFamilialeService;

    // Get all records
    @GetMapping
    public ResponseEntity<List<InformationFamiliale>> getAllInformationFamiliale() {
        return ResponseEntity.ok(informationFamilialeService.getAllInformationFamiliale());
    }

    // Get record by CIN_Fonctionnaire
    @GetMapping("/cin/{cin}")
    public ResponseEntity<InformationFamiliale> getInformationFamilialeByCin(@PathVariable String cin) {
        return informationFamilialeService.getInformationFamilialeByCin(cin)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create or update record (POST)
    @PostMapping
    public ResponseEntity<InformationFamiliale> saveInformationFamiliale(@RequestBody InformationFamiliale informationFamiliale) {
        return ResponseEntity.ok(informationFamilialeService.saveInformationFamiliale(informationFamiliale));
    }

    // Update record (PUT)
    @PutMapping("/cin/{cin}")
    public ResponseEntity<InformationFamiliale> updateInformationFamiliale(
            @PathVariable String cin,
            @RequestBody InformationFamiliale updatedInformationFamiliale) {

        return informationFamilialeService.getInformationFamilialeByCin(cin)
                .map(existingInformation -> {
                    // Update the existing entity with new values
                    existingInformation.setNomPere(updatedInformationFamiliale.getNomPere());
                    existingInformation.setNomMere(updatedInformationFamiliale.getNomMere());
                    existingInformation.setSituationFamiliale(updatedInformationFamiliale.getSituationFamiliale());
                    existingInformation.setDateMariage(updatedInformationFamiliale.getDateMariage());
                    existingInformation.setListCojoints(updatedInformationFamiliale.getListCojoints());
                    existingInformation.setListEnfants(updatedInformationFamiliale.getListEnfants());

                    // Save the updated entity
                    InformationFamiliale savedInformation = informationFamilialeService.saveInformationFamiliale(existingInformation);
                    return ResponseEntity.ok(savedInformation);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete record by CIN_Fonctionnaire
    @DeleteMapping("/cin/{cin}")
    public ResponseEntity<Void> deleteInformationFamiliale(@PathVariable String cin) {
        informationFamilialeService.deleteInformationFamiliale(cin);
        return ResponseEntity.noContent().build();
    }
}