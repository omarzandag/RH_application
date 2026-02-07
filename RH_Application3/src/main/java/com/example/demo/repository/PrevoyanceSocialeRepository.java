package com.example.demo.repository;

import com.example.demo.entity.PrevoyanceSociale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrevoyanceSocialeRepository extends JpaRepository<PrevoyanceSociale, Integer> {

    Optional<PrevoyanceSociale> findByCinFonctionnaire(String cin);
}