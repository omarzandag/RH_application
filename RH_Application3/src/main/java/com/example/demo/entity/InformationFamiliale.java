package com.example.demo.entity;

import com.example.demo.converter.ListToStringConverter;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "InformationFamiliale")
public class InformationFamiliale {

    @Id
    @Column(name = "CIN_Fonctionnaire", nullable = false, length = 20)
    private String cinFonctionnaire;

    @Column(name = "NomPere", nullable = false, length = 50)
    private String nomPere;

    @Column(name = "NomMere", nullable = false, length = 50)
    private String nomMere;

    @Column(name = "SituationFamiliale", nullable = false, length = 50)
    private String situationFamiliale;

    @Column(name = "DateMariage", nullable = true)
    private Date dateMariage;

    @Column(name = "List_Cojoints", columnDefinition = "json", nullable = false)
    @Convert(converter = ListToStringConverter.class)
    private List<String> listCojoints; // JSON will be mapped as a List

    @Column(name = "List_enfants", columnDefinition = "json", nullable = false)
    @Convert(converter = ListToStringConverter.class)
    private List<String> listEnfants; // JSON will be mapped as a List

    public String getCinFonctionnaire() {
        return cinFonctionnaire;
    }

    public void setCinFonctionnaire(String cinFonctionnaire) {
        this.cinFonctionnaire = cinFonctionnaire;
    }

    public String getNomPere() {
        return nomPere;
    }

    public void setNomPere(String nomPere) {
        this.nomPere = nomPere;
    }

    public String getNomMere() {
        return nomMere;
    }

    public void setNomMere(String nomMere) {
        this.nomMere = nomMere;
    }

    public String getSituationFamiliale() {
        return situationFamiliale;
    }

    public void setSituationFamiliale(String situationFamiliale) {
        this.situationFamiliale = situationFamiliale;
    }

    public Date getDateMariage() {
        return dateMariage;
    }

    public void setDateMariage(Date dateMariage) {
        this.dateMariage = dateMariage;
    }

    public List<String> getListCojoints() {
        return listCojoints;
    }

    public void setListCojoints(List<String> listCojoints) {
        this.listCojoints = listCojoints;
    }

    public List<String> getListEnfants() {
        return listEnfants;
    }

    public void setListEnfants(List<String> listEnfants) {
        this.listEnfants = listEnfants;
    }
}