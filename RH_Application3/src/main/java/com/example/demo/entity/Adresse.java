package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Adresse")
@Data // Lombok annotation for getters and setters
@NoArgsConstructor // Lombok annotation for no-args constructor
@AllArgsConstructor // Lombok annotation for all-args constructor
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AdresseID", nullable = false)
    private Integer adresseID;

    @Column(name = "Ville", nullable = false, length = 50)
    private String ville;

    @Column(name = "Commune", nullable = false, length = 50)
    private String commune;

    @Column(name = "Quartier", nullable = false, length = 50)
    private String quartier;

    @Column(name = "Rue", nullable = false, length = 50)
    private String rue;

    @Column(name = "Numero", nullable = false, length = 20)
    private String numero;

    @Column(name = "CodePostal", nullable = false, length = 10)
    private String codePostal;

    @Column(name = "CIN_Fonctionnaire", nullable = false, length = 20)
    private String cinFonctionnaire;
}