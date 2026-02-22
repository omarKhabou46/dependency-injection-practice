# 🚀 Projet : Inversion de Contrôle (IoC) et Injection de Dépendances (DI)

Ce projet pédagogique a pour objectif de démontrer les concepts fondamentaux de l'**Inversion de Contrôle (IoC)** et de l'**Injection de Dépendances (DI)** en Java. Il illustre l'évolution d'une architecture, partant d'une approche manuelle (couplage fort) vers une gestion automatisée et flexible avec le framework **Spring** (couplage faible).

## 🛠 Technologies Utilisées
* **Langage :** Java 
* **Framework :** Spring (Gestion de l'IoC et des Beans)
* **Gestionnaire de Build :** Maven

---

## 🏗 Structure du Projet

### 1. Couche Accès aux Données (`ma.enset.dao`)
Cette couche gère la récupération des données via une abstraction (Interface).
* **Interface `IDao`** : Définit le contrat avec la méthode `getData()`.
* **`DaoImpl1`** : Implémentation simulant une base de données, annotée `@Component("dao1")`.
* **`DaoImpl2`** : Implémentation via Web Service. Annotée `@Primary` pour être l'implémentation injectée par défaut en cas d'ambiguïté.

### 2. Couche Logique Métier (`ma.enset.metier`)
Cette couche traite les données fournies par la DAO pour effectuer des traitements métier.
* **Interface `IMetier`** : Définit la méthode `calcul()`.
* **`MetierImpl1`** : Utilise l'interface `IDao` pour effectuer ses calculs.
    * **Modes d'injection supportés :**
        * **Par Constructeur** : Recommandée pour assurer l'immuabilité et faciliter les tests unitaires.
        * **Par Setter** : Offre de la flexibilité pour modifier les dépendances après l'instanciation.
        * **Par Champ (`@Autowired`)** : Injection directe, bien que moins recommandée pour le couplage strict.

### 3. Couche Présentation (`ma.enset.presentation`)
Quatre approches démontrent l'évolution de la gestion des dépendances :

| Classe | Méthode d'Injection | Description |
| :--- | :--- | :--- |
| **Presentation1** | **Statique** | Instanciation manuelle "en dur" avec l'opérateur `new`. |
| **Presentation2** | **Dynamique** | Utilisation de la **Réflexion Java** et d'un fichier `config.txt`. |
| **Presentation3** | **Spring XML** | Configuration via un fichier `config.xml` pour déclarer les Beans. |
| **Presentation4** | **Spring Annotations** | Scan automatique des composants avec `@ComponentScan`. |

---

## ⚙️ Concepts Avancés & Fonctionnalités

### Gestion des Beans et Cycle de Vie
L'application explore le comportement interne du conteneur Spring (**ApplicationContext**) :

* **Instanciation Eager (Par défaut)** : Spring instancie tous les Singletons au démarrage du contexte pour valider la configuration immédiatement.
* **Instanciation Lazy (`lazy-init="true"`)** : Pour les objets coûteux, cette option retarde la création de l'objet jusqu'à son premier appel via `getBean()`.
* **Scopes des Beans** :
    * **Singleton (Défaut)** : Une seule instance partagée pour toute l'application.
    * **Prototype** : Une nouvelle instance est créée à chaque demande de Bean.

### Annotations Clés
* `@Component` : Marque une classe comme Bean géré par le conteneur Spring.
* `@Primary` : Indique l'implémentation prioritaire lors d'une injection multiple.
* `@Qualifier` : Permet de désigner précisément le Bean à injecter par son identifiant.

---
#### Captures d'écran des exécutions :

**1. Instanciation Statique & Dynamique**
* Instanciation Statique

Cette capture montre l'instanciation manuelle des classes. On observe que le code source doit être modifié et recompilé pour changer d'implémentation (ex: passer de DaoImpl1 à DaoImpl2).  

<img width="945" height="504" alt="image" src="https://github.com/user-attachments/assets/46c0e054-42d6-4a53-8f79-e2cca096c4fe" />

* Instanciation Dynamique

Illustration de l'utilisation de la Réflexion Java. On voit ici que l'application lit le nom des classes dans un fichier config.txt, permettant de changer le comportement du programme sans toucher au code source.
  
<img width="945" height="503" alt="image" src="https://github.com/user-attachments/assets/e35b7234-827f-430d-bc87-f67592a5ea75" />

<img width="945" height="503" alt="image" src="https://github.com/user-attachments/assets/cba87269-c3e4-4319-9901-baf2745b123e" />

**2. Injection via Spring (XML & Annotations)**
* Injection via Spring XML

Résultat de l'exécution utilisant le conteneur IoC de Spring avec un fichier config.xml. La capture montre comment Spring instancie les Beans et résout les dépendances en suivant les définitions XML.

  - le fichier configuration.xml
  
  <img width="945" height="504" alt="image" src="https://github.com/user-attachments/assets/1e2584ce-2ee7-49b9-ae1e-e948c84df3fa" />
  
  <img width="1366" height="727" alt="image" src="https://github.com/user-attachments/assets/2554e341-5c6f-41dd-a5ef-2227ed4d07c5" />
  
* Injection via Spring Annotations

Démonstration de l'approche moderne avec @ComponentScan. La capture confirme que Spring détecte automatiquement les classes annotées avec @Component et gère l'injection via @Autowired et @Primary.
  
  <img width="1366" height="727" alt="image" src="https://github.com/user-attachments/assets/416116b5-fd36-4db6-9b3a-4b603c623aa8" />









