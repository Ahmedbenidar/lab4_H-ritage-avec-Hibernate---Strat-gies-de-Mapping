package com.example.model.tableperclass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

// base de la hierarchie : aucune table pour cette classe abstraite
// chaque sous-classe concrete aura sa propre table avec les memes colonnes
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;

    public Produit() {
    }

    public Produit(String nom) {
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
