package com.example.demo.repository;

import com.example.demo.entity.Mouvement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MouvementRepository extends JpaRepository<Mouvement, Integer> {

    Optional<Mouvement> findByCinFonctionnaireAndMouvementID(String cinFonctionnaire, Integer mouvementID);

    List<Mouvement> findAllByCinFonctionnaire(String cinFonctionnaire);

    void deleteByMouvementID(Integer mouvementID);

    void deleteByCinFonctionnaire(String cinFonctionnaire);
}