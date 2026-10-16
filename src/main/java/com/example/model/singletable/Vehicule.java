package com.example.model.singletable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

// base de la hierarchie : tout est range dans une seule table
// la colonne vehicule_type dit de quelle sous-classe il s'agit
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "vehicule_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marque;

    public Vehicule() {
    }

    public Vehicule(String marque) {
        this.marque = marque;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long valeur) {
        this.id = valeur;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String valeur) {
        this.marque = valeur;
    }
}
