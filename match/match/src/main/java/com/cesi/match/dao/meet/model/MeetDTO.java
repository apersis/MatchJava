package com.cesi.match.dao.meet.model;

public class MeetDTO {
    int id;
    int nuGagnant;
    int nuPerdant;
    String lieutournoi;
    int annee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getNuGagnant() {
        return nuGagnant;
    }

    public void setNuGagnant(int nuGagnant) {
        this.nuGagnant = nuGagnant;
    }

    public int getNuPerdant() {
        return nuPerdant;
    }

    public void setNuPerdant(int nuPerdant) {
        this.nuPerdant = nuPerdant;
    }

    public String getLieuTournoi() {
        return lieutournoi;
    }

    public void setLieuTournoi(String lieutournoi) {
        this.lieutournoi = lieutournoi;
    }


    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
}
