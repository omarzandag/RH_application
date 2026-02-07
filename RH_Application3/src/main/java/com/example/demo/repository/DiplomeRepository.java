package com.example.demo.repository;

import com.example.demo.entity.Diplome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiplomeRepository extends JpaRepository<Diplome, Integer> {

    // Custom query to find diplomas by CIN_Fonctionnaire
    List<Diplome> findByCinFonctionnaire(String cinFonctionnaire);
}