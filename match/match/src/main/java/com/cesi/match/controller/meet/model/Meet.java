package com.cesi.match.controller.meet.model;

public class Meet {
    int idGagnant;
    int idPerdant;
    String lieu;
    int annee;

    public int getIdGagnant() {
        return idGagnant;
    }

    public void setIdGagnant(int idGagnant) {
        this.idGagnant = idGagnant;
    }

    public int getIdPerdant() {
        return idPerdant;
    }

    public void setIdPerdant(int idPerdant) {
        this.idPerdant = idPerdant;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
}
