package com.example.essai.data;

public class Dates {

    public String debut;
    public String fin;

    public Dates() {

    }

    public Dates(String debut, String fin) {
        this.debut = debut;
        this.fin = fin;
    }

    public String getDebut() {
        return this.debut;
    }

    public void setDebut(String deb) {
        this.debut = deb;
    }

    public String getFin() {
        return this.fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

}
