package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Conjoint")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conjoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer conjointID;

    @Column(nullable = false, length = 50)
    private String nom;

    @Column(nullable = false, length = 20, unique = true)
    private String cin;

    @Column(nullable = false)
    private LocalDate dateNaissance;

    @Column(nullable = false, length = 50)
    private String fonction;

    @Column(name = "CIN_Fonctionnaire", nullable = false, length = 20)
    private String cinFonctionnaire;

    public Integer getConjointID() {
        return conjointID;
    }

    public void setConjointID(Integer conjointID) {
        this.conjointID = conjointID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getCinFonctionnaire() {
        return cinFonctionnaire;
    }

    public void setCinFonctionnaire(String cinFonctionnaire) {
        this.cinFonctionnaire = cinFonctionnaire;
    }
}