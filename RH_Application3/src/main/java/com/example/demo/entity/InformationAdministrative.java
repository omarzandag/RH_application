package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "InformationAdministrative")
public class InformationAdministrative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IAID")
    private Integer iaid;

    @Column(name = "PPR", nullable = false)
    private String ppr;

    @Column(name = "PosteBudgetaire", nullable = false)
    private String posteBudgetaire;

    @Column(name = "DateRecrutement", nullable = false)
    private LocalDate dateRecrutement;

    @Column(name = "DiplomeRecrutement", nullable = false)
    private String diplomeRecrutement;

    @Column(name = "AdministrationRecrutement", nullable = false)
    private String administrationRecrutement;

    @Column(name = "Datetitularisation", nullable = false)
    private LocalDate datetitularisation;

    @Column(name = "Grade", nullable = false)
    private String grade;

    @Column(name = "Echelle", nullable = false)
    private String echelle;

    @Column(name = "Echelon", nullable = false)
    private String echelon;

    @Column(name = "Indice", nullable = false)
    private String indice;

    @Column(name = "StatutAdministratif", nullable = false)
    private String statutAdministratif;

    @Column(name = "Affectation", nullable = false)
    private String affectation;

    @Column(name = "Fonction", nullable = false)
    private String fonction;

    @Column(name = "CIN_Fonctionnaire", nullable = false)
    private String cinFonctionnaire;

    public InformationAdministrative(Integer iaid, String ppr, String posteBudgetaire, LocalDate dateRecrutement, String diplomeRecrutement, String administrationRecrutement, LocalDate datetitularisation, String grade, String echelle, String echelon, String indice, String statutAdministratif, String affectation, String fonction, String cinFonctionnaire) {
        this.iaid = iaid;
        this.ppr = ppr;
        this.posteBudgetaire = posteBudgetaire;
        this.dateRecrutement = dateRecrutement;
        this.diplomeRecrutement = diplomeRecrutement;
        this.administrationRecrutement = administrationRecrutement;
        this.datetitularisation = datetitularisation;
        this.grade = grade;
        this.echelle = echelle;
        this.echelon = echelon;
        this.indice = indice;
        this.statutAdministratif = statutAdministratif;
        this.affectation = affectation;
        this.fonction = fonction;
        this.cinFonctionnaire = cinFonctionnaire;
    }

    public InformationAdministrative() {
        
    }

    public Integer getIaid() {
        return iaid;
    }

    public void setIaid(Integer iaid) {
        this.iaid = iaid;
    }

    public String getPpr() {
        return ppr;
    }

    public void setPpr(String ppr) {
        this.ppr = ppr;
    }

    public String getPosteBudgetaire() {
        return posteBudgetaire;
    }

    public void setPosteBudgetaire(String posteBudgetaire) {
        this.posteBudgetaire = posteBudgetaire;
    }

    public LocalDate getDateRecrutement() {
        return dateRecrutement;
    }

    public void setDateRecrutement(LocalDate dateRecrutement) {
        this.dateRecrutement = dateRecrutement;
    }

    public String getDiplomeRecrutement() {
        return diplomeRecrutement;
    }

    public void setDiplomeRecrutement(String diplomeRecrutement) {
        this.diplomeRecrutement = diplomeRecrutement;
    }

    public String getAdministrationRecrutement() {
        return administrationRecrutement;
    }

    public void setAdministrationRecrutement(String administrationRecrutement) {
        this.administrationRecrutement = administrationRecrutement;
    }

    public LocalDate getDatetitularisation() {
        return datetitularisation;
    }

    public void setDatetitularisation(LocalDate datetitularisation) {
        this.datetitularisation = datetitularisation;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEchelle() {
        return echelle;
    }

    public void setEchelle(String echelle) {
        this.echelle = echelle;
    }

    public String getEchelon() {
        return echelon;
    }

    public void setEchelon(String echelon) {
        this.echelon = echelon;
    }

    public String getIndice() {
        return indice;
    }

    public void setIndice(String indice) {
        this.indice = indice;
    }

    public String getStatutAdministratif() {
        return statutAdministratif;
    }

    public void setStatutAdministratif(String statutAdministratif) {
        this.statutAdministratif = statutAdministratif;
    }

    public String getAffectation() {
        return affectation;
    }

    public void setAffectation(String affectation) {
        this.affectation = affectation;
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