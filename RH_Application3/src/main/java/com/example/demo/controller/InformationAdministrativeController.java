package com.example.demo.controller;

import com.example.demo.entity.InformationAdministrative;
import com.example.demo.service.InformationAdministrativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/information-administrative")
public class InformationAdministrativeController {

    @Autowired
    private InformationAdministrativeService service;

    // GET Record by CIN
    @GetMapping("/cin/{cin}")
    public ResponseEntity<InformationAdministrative> getInformationAdministrativeByCin(@PathVariable String cin) {
        return service.getInformationAdministrativeByCin(cin)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST Create a New Record
    @PostMapping
    public ResponseEntity<InformationAdministrative> createInformationAdministrative(
            @RequestBody InformationAdministrative informationAdministrative) {
        // Check if the CIN already exists
        if (service.getInformationAdministrativeByCin(informationAdministrative.getCinFonctionnaire()).isPresent()) {
            return ResponseEntity.badRequest().body(null); // Return 400 Bad Request if CIN exists
        }
        // Save the new record
        InformationAdministrative savedRecord = service.saveOrUpdateInformationAdministrative(informationAdministrative);
        return ResponseEntity.ok(savedRecord);
    }

    // PUT Update Record by CIN
    @PutMapping("/cin/{cin}")
    public ResponseEntity<InformationAdministrative> updateInformationAdministrativeByCin(
            @PathVariable String cin,
            @RequestBody InformationAdministrative updatedInformationAdministrative) {
        return service.getInformationAdministrativeByCin(cin)
                .map(existingInfo -> {
                    // Update fields (except CIN, which should remain unchanged)
                    existingInfo.setPpr(updatedInformationAdministrative.getPpr());
                    existingInfo.setPosteBudgetaire(updatedInformationAdministrative.getPosteBudgetaire());
                    existingInfo.setDateRecrutement(updatedInformationAdministrative.getDateRecrutement());
                    existingInfo.setDiplomeRecrutement(updatedInformationAdministrative.getDiplomeRecrutement());
                    existingInfo.setAdministrationRecrutement(updatedInformationAdministrative.getAdministrationRecrutement());
                    existingInfo.setDatetitularisation(updatedInformationAdministrative.getDatetitularisation());
                    existingInfo.setGrade(updatedInformationAdministrative.getGrade());
                    existingInfo.setEchelle(updatedInformationAdministrative.getEchelle());
                    existingInfo.setEchelon(updatedInformationAdministrative.getEchelon());
                    existingInfo.setIndice(updatedInformationAdministrative.getIndice());
                    existingInfo.setStatutAdministratif(updatedInformationAdministrative.getStatutAdministratif());
                    existingInfo.setAffectation(updatedInformationAdministrative.getAffectation());
                    existingInfo.setFonction(updatedInformationAdministrative.getFonction());

                    return ResponseEntity.ok(service.saveOrUpdateInformationAdministrative(existingInfo));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE Record by CIN
    @DeleteMapping("/cin/{cin}")
    public ResponseEntity<Void> deleteInformationAdministrativeByCin(@PathVariable String cin) {
        service.deleteInformationAdministrativeByCin(cin);
        return ResponseEntity.noContent().build();
    }
}