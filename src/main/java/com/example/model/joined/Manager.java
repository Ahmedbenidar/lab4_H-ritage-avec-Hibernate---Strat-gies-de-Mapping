package com.example.model.joined;

import javax.persistence.Entity;

// Hibernate creera une table Manager reliee a Employe
@Entity
public class Manager extends Employe {

    private int nombreEquipes;

    public Manager() {
    }

    public Manager(String nom, int nombreEquipes) {
        super(nom);
        this.nombreEquipes = nombreEquipes;
    }

    public int getNombreEquipes() {
        return nombreEquipes;
    }

    public void setNombreEquipes(int valeur) {
        this.nombreEquipes = valeur;
    }
}
