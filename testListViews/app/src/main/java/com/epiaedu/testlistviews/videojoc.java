package com.epiaedu.testlistviews;

public class videojoc {

    private String nom;
    private String imatge;

    public String getDesenvolupador() {
        return desenvolupador;
    }

    private String desenvolupador;

    public String getImatge() {
        return imatge;
    }

    public videojoc(String nom, String imatge, String desenvolupador) {
        this.nom = nom;
        this.imatge = imatge;
        this.desenvolupador = desenvolupador;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
