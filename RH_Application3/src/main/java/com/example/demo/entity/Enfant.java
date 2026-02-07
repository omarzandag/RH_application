package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Enfant")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enfant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer enfantID;

    @Column(nullable = false, length = 50)
    private String prenom;

    @Column(nullable = false, length = 50)
    private String nomMere;

    @Column(nullable = false)
    private LocalDate dateNaissance;

    @Column(name="CIN_Fonctionnaire" ,nullable = false, length = 20)
    private String cinFonctionnaire;

    public Integer getEnfantID() {
        return enfantID;
    }

    public void setEnfantID(Integer enfantID) {
        this.enfantID = enfantID;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNomMere() {
        return nomMere;
    }

    public void setNomMere(String nomMere) {
        this.nomMere = nomMere;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getCinFonctionnaire() {
        return cinFonctionnaire;
    }

    public void setCinFonctionnaire(String cinFonctionnaire) {
        this.cinFonctionnaire = cinFonctionnaire;
    }
}