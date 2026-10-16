package com.example.model.tableperclass;

import javax.persistence.Entity;

// table autonome : elle reprend les colonnes heritees de Produit
@Entity
public class Electronique extends Produit {

    private int garantie; // duree en mois

    public Electronique() {
    }

    public Electronique(String nom, int garantie) {
        super(nom);
        this.garantie = garantie;
    }

    public int getGarantie() {
        return garantie;
    }

    public void setGarantie(int valeur) {
        this.garantie = valeur;
    }
}
