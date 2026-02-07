package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "Affectations")
public class Affectation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AffectationID")
    private Integer affectationID;

    @Column(name = "Entite", nullable = false, length = 50)
    private String entite;

    @Column(name = "Date", nullable = false)
    private LocalDate date;

    @Column(name = "Poste", nullable = false, length = 50)
    private String poste;

    @Column(name = "CIN_Fonctionnaire", nullable = false, length = 20)
    private String cinFonctionnaire;

    public Integer getAffectationID() {
        return affectationID;
    }

    public void setAffectationID(Integer affectationID) {
        this.affectationID = affectationID;
    }

    public String getEntite() {
        return entite;
    }

    public void setEntite(String entite) {
        this.entite = entite;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getCinFonctionnaire() {
        return cinFonctionnaire;
    }

    public void setCinFonctionnaire(String cinFonctionnaire) {
        this.cinFonctionnaire = cinFonctionnaire;
    }
}