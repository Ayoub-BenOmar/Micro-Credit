# Système de Scoring Automatisé pour Crédit

## Contexte du projet
Le secteur micro-finance marocain fait face à des défis majeurs dans l'évaluation du risque crédit : processus manuels, subjectivité des décisions, exclusion de profils potentiellement solvables. Les méthodes traditionnelles ne répondent plus aux exigences de rapidité, précision et traçabilité du marché moderne.

Ce projet vise à développer un **système de scoring automatisé en Java** qui combine :
- Algorithmes de scoring basés sur 5 composants métier : stabilité professionnelle, capacité financière, historique, relation client, patrimoine
- Moteur de décision automatique
- Historisation complète pour audit

Objectif : Transformer l'octroi de crédit avec un scoring intelligent qui réduit les risques tout en améliorant l'accès au financement.

## Structure de l'application
- **Couche de présentation (UI/Menu)**
- **Couche métier**
- **Couche utilitaire**
- **Couche repository**

## Fonctionnalités principales

### Module 1 : Gestion des clients
- Créer un nouveau client
- Modifier informations client
- Consulter profil client
- Supprimer client
- Lister tous les clients

**Classes principales :**
- `Personne` (abstraite) : nom, prénom, date de naissance, ville, nombre d'enfants, investissement, placement, situation familiale, createdAt, score
- `Employe` : hérite de Personne, avec salaire, ancienneté, poste, typeContrat, secteur (public, grande entreprise, PME)
- `Professionnel` : hérite de Personne, avec revenu, immatriculation fiscale, secteur d'activité, activité (ex : Avocat, Mécanicien)

### Module 2 : Calcul de score
- Algorithme de scoring automatique basé sur les composants métier
- Validation des seuils d'éligibilité (70/100 nouveau, 60/100 existant)
- Calcul de la capacité d'emprunt :
    - Nouveau client score 60-80 → 4x salaire
    - Client existant score 60-80 → 7x salaire
    - Client existant score >80 → 10x salaire

**Classe principale :**
- `Credit` : dateCredit, montantDemande, montantOctroye, tauxInteret, dureeEnMois, typeCredit, decision (ACCORD_IMMEDIAT, ETUDE_MANUELLE, REFUS_AUTOMATIQUE)

### Module 3 : Gestion de l'historique de paiement
- Génération des échéances et suivi des paiements
- Classification automatique des paiements : paiement à temps, retard (5-30 jours), impayé réglé ou non réglé (31+ jours)
- Gestion des régularisations et système de pénalités/bonus
- Mise à jour dynamique du score selon l'historique

**Classes principales :**
- `Echeance` : dateEcheance, mensualité, datePaiement, statutPaiement (PAYE_AT_TEMPS, EN_RETARD, PAYE_EN_RETARD, IMPAYE_NON_REGLE, IMPAYE_REGLE)
- `Incident` : dateIncident, Echeance, score, typeIncident (PAYE_AT_TEMPS, EN_RETARD, PAYE_EN_RETARD, IMPAYE_NON_REGLE, IMPAYE_REGLE)

### Module 4 : Moteur de décision automatique
- Accord immédiat pour score ≥ 80
- Étude manuelle pour score 60-79
- Refus automatique pour score <60

### Module 5 : Analytics
- Recherche clients éligibles pour crédit immobilier selon critères multiples (âge, revenus, type d'emploi, score, situation familiale)
- Identification clients à risque nécessitant suivi (top 10)
- Tri par score, revenus, ancienneté
- Répartition par type d'emploi et statistiques (score moyen, revenus moyens, taux d’approbation)
- Usage business : ciblage pour campagnes marketing basées sur score, revenus, âge, crédit en cours
