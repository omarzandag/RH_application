package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Diplome")
public class Diplome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DiplomeID")
    private Integer diplomeID;

    @Column(name = "Intitule", nullable = false, length = 50)
    private String intitule;

    @Column(name = "Specialite", nullable = false, length = 50)
    private String specialite;

    @Column(name = "DateObtention", nullable = false)
    private LocalDate dateObtention;

    @Column(name = "Etablissement", nullable = false, length = 50)
    private String etablissement;

    @Column(name = "CIN_Fonctionnaire", nullable = false, length = 20)
    private String cinFonctionnaire;

    public Integer getDiplomeID() {
        return diplomeID;
    }

    public void setDiplomeID(Integer diplomeID) {
        this.diplomeID = diplomeID;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public LocalDate getDateObtention() {
        return dateObtention;
    }

    public void setDateObtention(LocalDate dateObtention) {
        this.dateObtention = dateObtention;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public String getCinFonctionnaire() {
        return cinFonctionnaire;
    }

    public void setCinFonctionnaire(String cinFonctionnaire) {
        this.cinFonctionnaire = cinFonctionnaire;
    }
}