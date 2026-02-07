package com.example.demo.repository;

import com.example.demo.entity.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Integer> {
    // Custom query to find absences by CIN_Fonctionnaire
    List<Absence> findByCinFonctionnaire(String cinFonctionnaire);
}