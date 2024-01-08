package com.cesi.match.controller.match.model;

import com.cesi.match.controller.person.model.Person;

public class Match {
    String vainqueur;
    String perdant;
    String tournoi;

    public String getVainqueur() {
        return vainqueur;
    }

    public void setVainqueur(String vainqueur) {
        this.vainqueur = vainqueur;
    }

    public String getPerdant() {
        return perdant;
    }

    public void setPerdant(String perdant) {
        this.perdant = perdant;
    }

    public String getTournoi() {
        return tournoi;
    }

    public void setTournoi(String tournoi) {
        this.tournoi = tournoi;
    }
}
