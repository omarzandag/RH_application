package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Absence")
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer absenceID;

    @Column(nullable = false, length = 50)
    private String typeAbsence;

    @Column(nullable = false)
    private java.sql.Date dateDepart;

    @Column(nullable = false)
    private Integer nombreJours;

    @Column(nullable = false, length = 50)
    private String remplacant;

    @Column(name = "CIN_Fonctionnaire", nullable = false, length = 20)
    private String cinFonctionnaire;

    public Integer getAbsenceID() {
        return absenceID;
    }

    public void setAbsenceID(Integer absenceID) {
        this.absenceID = absenceID;
    }

    public String getTypeAbsence() {
        return typeAbsence;
    }

    public void setTypeAbsence(String typeAbsence) {
        this.typeAbsence = typeAbsence;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Integer getNombreJours() {
        return nombreJours;
    }

    public void setNombreJours(Integer nombreJours) {
        this.nombreJours = nombreJours;
    }

    public String getRemplacant() {
        return remplacant;
    }

    public void setRemplacant(String remplacant) {
        this.remplacant = remplacant;
    }

    public String getCinFonctionnaire() {
        return cinFonctionnaire;
    }

    public void setCinFonctionnaire(String cinFonctionnaire) {
        this.cinFonctionnaire = cinFonctionnaire;
    }
}