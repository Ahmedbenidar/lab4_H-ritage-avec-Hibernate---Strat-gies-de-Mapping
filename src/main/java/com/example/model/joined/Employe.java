package com.example.model.joined;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

// base de la hierarchie : une table par classe
// les tables filles pointent sur la table Employe par une cle etrangere
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    public Employe() {
    }

    public Employe(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long valeur) {
        this.id = valeur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String valeur) {
        this.nom = valeur;
    }
}
