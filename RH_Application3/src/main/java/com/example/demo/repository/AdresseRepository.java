package com.example.demo.repository;

import com.example.demo.entity.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Integer> {
    Optional<Adresse> findByCinFonctionnaire(String cinFonctionnaire);
}