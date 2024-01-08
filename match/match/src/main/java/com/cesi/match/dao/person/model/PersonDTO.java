package com.cesi.match.dao.person.model;

public class PersonDTO {
    int id;
    String nom;
    String prenom;
    int anneeNaissance;
    String nationalite;
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAnneeNaissance() {
        return anneeNaissance;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setId(int anInt) {
        this.id = anInt;
    }

    public void setNom(String string) {
        this.nom = string;
    }

    public void setPrenom(String string) {
        this.prenom = string;
    }

    public void setAnneeNaissance(int anInt) {
        this.anneeNaissance = anInt;
    }

    public void setNationalite(String string) {
        this.nationalite = string;
    }
}
