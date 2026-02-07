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
@Table(name = "PrevoyanceSociale")
public class PrevoyanceSociale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prevoyanceID;

    @Column(nullable = false, length = 50)
    private String organismeRetraite;

    @Column(nullable = false, length = 50)
    private String numeroAffiliationRetraite;

    @Column(nullable = false)
    private LocalDate dateAffiliationRetraite;

    @Column(nullable = false, length = 50)
    private String organismePrevoyance;

    @Column(nullable = false, length = 50)
    private String numeroCNOPS;

    @Column(nullable = false, length = 50)
    private String numeroImmatriculationCNOPS;

    @Column(nullable = false)
    private LocalDate dateAffiliationCNOPS;

    @Column(nullable = false)
    private Integer naffiliationFHassanII;

    @Column(nullable = false, length = 20)
    private String organisationAssurance;

    @Column(nullable = false)
    private Integer nAffiliationAssurance;

    @Column(name="CIN_Fonctionnaire" , nullable = false, length = 20)
    private String cinFonctionnaire;

    public Integer getPrevoyanceID() {
        return prevoyanceID;
    }

    public void setPrevoyanceID(Integer prevoyanceID) {
        this.prevoyanceID = prevoyanceID;
    }

    public String getOrganismeRetraite() {
        return organismeRetraite;
    }

    public void setOrganismeRetraite(String organismeRetraite) {
        this.organismeRetraite = organismeRetraite;
    }

    public String getNumeroAffiliationRetraite() {
        return numeroAffiliationRetraite;
    }

    public void setNumeroAffiliationRetraite(String numeroAffiliationRetraite) {
        this.numeroAffiliationRetraite = numeroAffiliationRetraite;
    }

    public LocalDate getDateAffiliationRetraite() {
        return dateAffiliationRetraite;
    }

    public void setDateAffiliationRetraite(LocalDate dateAffiliationRetraite) {
        this.dateAffiliationRetraite = dateAffiliationRetraite;
    }

    public String getOrganismePrevoyance() {
        return organismePrevoyance;
    }

    public void setOrganismePrevoyance(String organismePrevoyance) {
        this.organismePrevoyance = organismePrevoyance;
    }

    public String getNumeroCNOPS() {
        return numeroCNOPS;
    }

    public void setNumeroCNOPS(String numeroCNOPS) {
        this.numeroCNOPS = numeroCNOPS;
    }

    public String getNumeroImmatriculationCNOPS() {
        return numeroImmatriculationCNOPS;
    }

    public void setNumeroImmatriculationCNOPS(String numeroImmatriculationCNOPS) {
        this.numeroImmatriculationCNOPS = numeroImmatriculationCNOPS;
    }

    public LocalDate getDateAffiliationCNOPS() {
        return dateAffiliationCNOPS;
    }

    public void setDateAffiliationCNOPS(LocalDate dateAffiliationCNOPS) {
        this.dateAffiliationCNOPS = dateAffiliationCNOPS;
    }

    public Integer getNaffiliationFHassanII() {
        return naffiliationFHassanII;
    }

    public void setNaffiliationFHassanII(Integer naffiliationFHassanII) {
        this.naffiliationFHassanII = naffiliationFHassanII;
    }

    public String getOrganisationAssurance() {
        return organisationAssurance;
    }

    public void setOrganisationAssurance(String organisationAssurance) {
        this.organisationAssurance = organisationAssurance;
    }

    public Integer getnAffiliationAssurance() {
        return nAffiliationAssurance;
    }

    public void setnAffiliationAssurance(Integer nAffiliationAssurance) {
        this.nAffiliationAssurance = nAffiliationAssurance;
    }

    public String getCinFonctionnaire() {
        return cinFonctionnaire;
    }

    public void setCinFonctionnaire(String cinFonctionnaire) {
        this.cinFonctionnaire = cinFonctionnaire;
    }
}