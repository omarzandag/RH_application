package com.example.demo.repository;

import com.example.demo.entity.Enfant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnfantRepository extends JpaRepository<Enfant, Integer> {

    // Custom query to get all enfants by CIN
    List<Enfant> findByCinFonctionnaire(String cinFonctionnaire);
}