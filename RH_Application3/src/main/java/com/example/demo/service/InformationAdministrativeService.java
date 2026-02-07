package com.example.demo.service;

import com.example.demo.entity.InformationAdministrative;
import com.example.demo.repository.InformationAdministrativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InformationAdministrativeService {

    @Autowired
    private InformationAdministrativeRepository repository;

    public Optional<InformationAdministrative> getInformationAdministrativeByCin(String cin) {
        return repository.findByCinFonctionnaire(cin);
    }

    public InformationAdministrative saveOrUpdateInformationAdministrative(InformationAdministrative informationAdministrative) {
        return repository.save(informationAdministrative);
    }

    public void deleteInformationAdministrativeByCin(String cin) {
        repository.deleteByCinFonctionnaire(cin);
    }
}