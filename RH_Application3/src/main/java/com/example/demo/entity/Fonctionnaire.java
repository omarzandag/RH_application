package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Fonctionnaire")
public class Fonctionnaire {

    @Id
    @Column(name = "CIN", nullable = false, length = 20)
    private String cin;

    @Column(name = "Nom", nullable = false, length = 50)
    private String nom;

    @Column(name = "Prenom", nullable = false, length = 50)
    private String prenom;

    @Column(name = "Sexe", nullable = false, length = 10)
    private String sexe;

    @Column(name = "date_naissance", nullable = false)
    private LocalDate dateNaissance;

    @Column(name = "lieu_naissance", nullable = false, length = 50)
    private String lieuNaissance;

    @Column(name = "Tel", nullable = false, length = 20)
    private String tel;

    @Column(name = "Email", nullable = false, length = 50)
    private String email;

    // Getters and Setters
    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}