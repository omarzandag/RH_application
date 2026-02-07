package com.example.demo.controller;

import com.example.demo.entity.PrevoyanceSociale;
import com.example.demo.service.PrevoyanceSocialeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/prevoyance-sociale")
public class PrevoyanceSocialeController {

    @Autowired
    private PrevoyanceSocialeService service;

    // GET by CIN
    @GetMapping("/cin/{cin}")
    public ResponseEntity<?> getByCin(@PathVariable String cin) {
        Optional<PrevoyanceSociale> result = service.getByCin(cin);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST
    @PostMapping
    public ResponseEntity<PrevoyanceSociale> create(@RequestBody PrevoyanceSociale prevoyanceSociale) {
        PrevoyanceSociale created = service.create(prevoyanceSociale);
        return ResponseEntity.status(201).body(created);
    }

    // PUT
    @PutMapping("/cin/{cin}")
    public ResponseEntity<PrevoyanceSociale> updateByCin(@PathVariable String cin, @RequestBody PrevoyanceSociale updatedData) {
        try {
            PrevoyanceSociale updated = service.updateByCin(cin, updatedData);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}