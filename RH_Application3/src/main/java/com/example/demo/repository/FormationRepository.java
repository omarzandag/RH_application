package com.example.demo.repository;

import com.example.demo.entity.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Integer> {
    // Custom query methods can be added here if needed
}