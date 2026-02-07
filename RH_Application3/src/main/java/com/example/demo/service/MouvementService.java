package com.example.demo.service;

import com.example.demo.entity.Mouvement;
import com.example.demo.repository.MouvementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MouvementService {

    @Autowired
    private MouvementRepository mouvementRepository;

    public Mouvement createMouvement(Mouvement mouvement) {
        return mouvementRepository.save(mouvement);
    }

    public List<Mouvement> getAllMouvements() {
        return mouvementRepository.findAll();
    }

    public List<Mouvement> getAllMouvementsByCin(String cinFonctionnaire) {
        return mouvementRepository.findAllByCinFonctionnaire(cinFonctionnaire);
    }

    // Update all Mouvements by CIN_Fonctionnaire
    public List<Mouvement> updateAllMouvementsByCin(String cinFonctionnaire, Mouvement updatedMouvement) {
        List<Mouvement> mouvements = mouvementRepository.findAllByCinFonctionnaire(cinFonctionnaire);
        for (Mouvement mouvement : mouvements) {
            mouvement.setAdministration(updatedMouvement.getAdministration());
            mouvement.setDateDebut(updatedMouvement.getDateDebut());
            mouvement.setDateFin(updatedMouvement.getDateFin());
        }
        return mouvementRepository.saveAll(mouvements);
    }

    public void deleteMouvementById(Integer mouvementID) {
        mouvementRepository.deleteByMouvementID(mouvementID);
    }

    public void deleteMouvementsByCin(String cinFonctionnaire) {
        mouvementRepository.deleteByCinFonctionnaire(cinFonctionnaire);
    }
}