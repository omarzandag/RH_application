package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Formation")
@Data // Lombok annotation for getters and setters
@NoArgsConstructor // Lombok annotation for no-args constructor
@AllArgsConstructor // Lombok annotation for all-args constructor
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FormationID")
    private Integer formationId;

    @Column(name = "Prestataire", nullable = false, length = 50)
    private String prestataire;

    @Column(name = "Formateur", nullable = false, length = 50)
    private String formateur;

    @Column(name = "DateDebut", nullable = false)
    private LocalDate dateDebut;

    @Column(name = "DateFin", nullable = false)
    private LocalDate dateFin;

    @Column(name = "Lieu", nullable = false, length = 50)
    private String lieu;

    @Column(name = "ListeBénéficiaires", nullable = false, length = 500)
    private String listeBeneficiaires;
}