package com.example.demo.repository;

import com.example.demo.entity.Conjoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConjointRepository extends JpaRepository<Conjoint, Integer> {

    Optional<Conjoint> findByCin(String cin);
    List<Conjoint> findByCinFonctionnaire(String cinFonctionnaire);

    void deleteByCinFonctionnaire(String cinFonctionnaire);
}