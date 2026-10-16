package com.example;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.model.joined.Developpeur;
import com.example.model.joined.Employe;
import com.example.model.joined.Manager;
import com.example.model.singletable.Moto;
import com.example.model.singletable.Vehicule;
import com.example.model.singletable.Voiture;
import com.example.model.tableperclass.Electronique;
import com.example.model.tableperclass.Livre;
import com.example.model.tableperclass.Produit;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory usine = Persistence.createEntityManagerFactory("hibernate-inheritance");
        EntityManager em = usine.createEntityManager();

        // tout est insere dans une seule transaction
        em.getTransaction().begin();
        remplir(em);
        em.getTransaction().commit();

        // on relit les 3 hierarchies de la meme facon
        afficher(em, "vehicules", "SELECT v FROM Vehicule v", Vehicule.class);
        afficher(em, "employes", "SELECT e FROM Employe e", Employe.class);
        afficher(em, "produits", "SELECT p FROM Produit p", Produit.class);

        em.close();
        usine.close();
    }

    // un exemple par sous-classe pour tester les 3 strategies
    private static void remplir(EntityManager em) {
        em.persist(new Voiture("Toyota", 4));
        em.persist(new Moto("Harley", true));
        em.persist(new Developpeur("Alice", "Java"));
        em.persist(new Manager("Bob", 3));
        em.persist(new Livre("Clean Code", "Robert C. Martin"));
        em.persist(new Electronique("Smartphone", 24));
    }

    // requete polymorphique : on recupere la liste puis on l'affiche a la main
    private static <T> void afficher(EntityManager em, String titre, String jpql, Class<T> type) {
        System.out.println("--- Liste des " + titre + " ---");
        List<T> resultats = em.createQuery(jpql, type).getResultList();
        for (T objet : resultats) {
            System.out.println(decrire(objet));
        }
    }

    // libelle "Classe: valeur" selon la hierarchie a laquelle appartient l'objet
    private static String decrire(Object objet) {
        String classe = objet.getClass().getSimpleName();
        if (objet instanceof Vehicule) {
            return classe + ": " + ((Vehicule) objet).getMarque();
        }
        if (objet instanceof Employe) {
            return classe + ": " + ((Employe) objet).getNom();
        }
        return classe + ": " + ((Produit) objet).getNom();
    }
}
