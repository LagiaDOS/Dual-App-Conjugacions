package com.epiaedu.botigamanoli;

public class producte {

    private String descripcio;
    private String categoria;
    private double preu;
    private String fabricant;
    private String comentari;
    private boolean favorit;

    public producte(String descripcio, String categoria, double preu, String fabricant, String comentari) {
        this.descripcio = descripcio;
        this.categoria = categoria;
        this.preu = preu;
        this.fabricant = fabricant;
        this.comentari = comentari;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public String getFabricant() {
        return fabricant;
    }

    public void setFabricant(String fabricant) {
        this.fabricant = fabricant;
    }

    public String getComentari() {
        return comentari;
    }

    public void setComentari(String comentari) {
        this.comentari = comentari;
    }

    public boolean getFavorit() {
        return favorit;
    }

    public void setFavorit(boolean favorit) {
        this.favorit = favorit;
    }
}
