package com.example.demo.repository;

import com.example.demo.entity.InformationFamiliale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationFamilialeRepository extends JpaRepository<InformationFamiliale, String> {
    // Custom query methods can be added here if needed
}