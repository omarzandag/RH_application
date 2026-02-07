package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Mouvement")
public class Mouvement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mouvementID;

    @Column(name = "Administration", nullable = false, length = 50)
    private String administration;

    @Column(name = "DateDebut", nullable = false)
    private LocalDate dateDebut;

    @Column(name = "DateFin", nullable = false)
    private LocalDate dateFin;

    @Column(name = "CIN_Fonctionnaire", nullable = false, length = 20)
    private String cinFonctionnaire;

    public Integer getMouvementID() {
        return mouvementID;
    }

    public void setMouvementID(Integer mouvementID) {
        this.mouvementID = mouvementID;
    }

    public String getAdministration() {
        return administration;
    }

    public void setAdministration(String administration) {
        this.administration = administration;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public String getCinFonctionnaire() {
        return cinFonctionnaire;
    }

    public void setCinFonctionnaire(String cinFonctionnaire) {
        this.cinFonctionnaire = cinFonctionnaire;
    }
}