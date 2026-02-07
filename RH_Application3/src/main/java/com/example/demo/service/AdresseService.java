package com.example.demo.service;

import com.example.demo.entity.Adresse;
import com.example.demo.repository.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdresseService {

    @Autowired
    private AdresseRepository adresseRepository;

    // Get an address by CIN_Fonctionnaire
    public Optional<Adresse> getAdresseByCin(String cin) {
        return adresseRepository.findByCinFonctionnaire(cin);
    }

    // Update an address by CIN_Fonctionnaire
    public Adresse updateAdresseByCin(String cin, Adresse updatedAdresse) {
        return adresseRepository.findByCinFonctionnaire(cin)
                .map(adresse -> {
                    adresse.setVille(updatedAdresse.getVille());
                    adresse.setCommune(updatedAdresse.getCommune());
                    adresse.setQuartier(updatedAdresse.getQuartier());
                    adresse.setRue(updatedAdresse.getRue());
                    adresse.setNumero(updatedAdresse.getNumero());
                    adresse.setCodePostal(updatedAdresse.getCodePostal());
                    adresse.setCinFonctionnaire(updatedAdresse.getCinFonctionnaire());
                    return adresseRepository.save(adresse);
                })
                .orElseThrow(() -> new RuntimeException("Address not found with CIN: " + cin));
    }

    // Delete an address by CIN_Fonctionnaire
    public void deleteAdresseByCin(String cin) {
        adresseRepository.findByCinFonctionnaire(cin)
                .ifPresentOrElse(
                        adresse -> adresseRepository.delete(adresse),
                        () -> {
                            throw new RuntimeException("Address not found with CIN: " + cin);
                        }
                );
    }

    public Adresse createAdresse(Adresse adresse) {
        return adresseRepository.save(adresse);
    }
}