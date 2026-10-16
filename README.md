# TP 4 : Heritage avec Hibernate et JPA

Mise en oeuvre des trois strategies de mapping de l'heritage avec JPA / Hibernate.

## Strategies couvertes

| Strategie | Entites | Tables creees |
|---|---|---|
| `SINGLE_TABLE` | `Vehicule`, `Voiture`, `Moto` | 1 table `VEHICULE` + colonne discriminante `vehicule_type` |
| `JOINED` | `Employe`, `Developpeur`, `Manager` | 1 table par classe, `DEVELOPPEUR.ID` et `MANAGER.ID` en cle etrangere vers `EMPLOYE` |
| `TABLE_PER_CLASS` | `Produit`, `Livre`, `Electronique` | 1 table par classe concrete, sans table parente |

## Structure

```
src/main/java/com/example/
    App.java
    model/singletable/    Vehicule, Voiture, Moto
    model/joined/         Employe, Developpeur, Manager
    model/tableperclass/  Produit, Livre, Electronique
src/main/resources/META-INF/persistence.xml
```

## Prerequis

- JDK 8 ou superieur
- Maven

## Execution

```bash
mvn clean compile exec:java -Dexec.mainClass=com.example.App
```

## Resultat attendu

```
--- Liste des vehicules ---
Voiture: Toyota
Moto: Harley
--- Liste des employes ---
Developpeur: Alice
Manager: Bob
--- Liste des produits ---
Livre: Clean Code
Electronique: Smartphone
```

## Base de donnees

H2 en memoire : `jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1`
Unite de persistance : `hibernate-inheritance`
Schema genere automatiquement (`hbm2ddl.auto=create-drop`).