package com.example.model.joined;

import javax.persistence.Entity;

// Hibernate creera une table Developpeur reliee a Employe
@Entity
public class Developpeur extends Employe {

    private String langage;

    public Developpeur() {
    }

    public Developpeur(String nom, String langage) {
        super(nom);
        this.langage = langage;
    }

    public String getLangage() {
        return langage;
    }

    public void setLangage(String valeur) {
        this.langage = valeur;
    }
}
