# Sakani — Plateforme de logement étudiant et colocation

## Description
Sakani est une plateforme web destinée aux étudiants en Tunisie. Elle facilite la recherche de logements, la consultation des annonces, la gestion des candidatures, l'organisation des visites et la recherche de colocataires compatibles.

## Problématique
Les étudiants rencontrent des difficultés à trouver des logements adaptés à leur budget, à leur localisation et à leurs préférences. Les annonces sont dispersées et la recherche de colocataires fiables reste complexe.

## Objectifs
- Centraliser les offres de logements étudiants.
- Faciliter la publication et la consultation des annonces.
- Simplifier les demandes de logement.
- Organiser les visites.
- Proposer un système de matching pour la colocation.

## Architecture
Le projet repose sur une architecture microservices avec une API Gateway, un frontend web et des bases de données adaptées aux services.

## Microservices
1. **Logement Service** : gestion des logements.
2. **Annonce Service** : publication et consultation des annonces.
3. **Candidature Service** : gestion des demandes de logement.
4. **Visite Service** : planification des visites.
5. **Matching Service (commun)** : recommandations de colocataires compatibles.

## Organisation du dépôt
- `Backend/` : microservices et API Gateway.
- `Frontend/` : application web.
- `Documentation/Presentation/` : présentation de la séance 4.
- `Documentation/Diagrams/Architecture/` : diagramme d'architecture globale.
- `Documentation/Diagrams/UML/` : diagrammes UML.
- `Documentation/DossierTechnique/` : document technique.
- `Documentation/API-Contracts/` : contrats des API.

## Équipe
Projet académique AWD — Équipe de 4 étudiants.

## État du projet
Phase de conception et validation intermédiaire — Semaine 4.