package com.example.demo.repository;

import com.example.demo.entity.Affectation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AffectationRepository extends JpaRepository<Affectation, Integer> {

    List<Affectation> findByCinFonctionnaire(String cinFonctionnaire);
    void deleteByCinFonctionnaire(String cinFonctionnaire);
}