package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer documentID;

    private String titre;

    private String type;

    @Lob
    @Column(name = "fichier", columnDefinition = "LONGBLOB")
    private byte[] fichier;

    @Column(name = "CIN_Fonctionnaire")
    private String cinFonctionnaire;

    // Getters and Setters

    public Integer getDocumentID() {
        return documentID;
    }

    public void setDocumentID(Integer documentID) {
        this.documentID = documentID;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getFichier() {
        return fichier;
    }

    public void setFichier(byte[] fichier) {
        this.fichier = fichier;
    }

    public String getCinFonctionnaire() {
        return cinFonctionnaire;
    }

    public void setCinFonctionnaire(String cinFonctionnaire) {
        this.cinFonctionnaire = cinFonctionnaire;
    }
}
