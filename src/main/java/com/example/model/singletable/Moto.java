package com.example.model.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

// deuxieme sous-classe de la meme table unique
@Entity
@DiscriminatorValue("MOTO")
public class Moto extends Vehicule {

    private boolean sidecar;

    public Moto() {
    }

    public Moto(String marque, boolean sidecar) {
        super(marque);
        this.sidecar = sidecar;
    }

    public boolean isSidecar() {
        return sidecar;
    }

    public void setSidecar(boolean valeur) {
        this.sidecar = valeur;
    }
}
