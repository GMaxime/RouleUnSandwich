#Projet RouleUnSandwich, équipe GyroDragon
#Membres : Ines Occelli, Peggy Calderon Kayser, Vincent Gilabert, Maxime Guillet

Avancement du projet :

Le programme est en relation avec la base de données par Hibernate, toutes les classes nécéssaires sont mappées (package pojo) sur les tables correspondantes et ont les fonctions nécessaires implémentées.
Ainsi, en récupérant un compte client, nous pouvons récupérer ses commandes, depuis les commandes nous pouvons récupérer les sandwiches et accompagnements, depuis les sandwiches nous pouvons récupérer les produits correspondants.
Une route permet de récupérer toutes les commandes valides pour le front Admin (IP:8080/rest/Commande/Valide), donnant un résultat JSON. Malheureusement, nous n'avons pas réussi avec le Javascript (front) à gérer l'adresse d'un server distant pour tester la fonctionnalité des requêtes fetch en javascript.
Voici un exemple de résultat de la requète HTTP :
[
    {
        "sandwichs": [
            {
                "produits": [],
                "price": 5,
                "id": 2,
                "base": {
                    "produits": [],
                    "price": 5,
                    "name": "poulet",
                    "id": 1
                }
            }
        ],
        "id": 2,
        "accompagnements": [
            {
                "price": 1.5,
                "name": "cookie",
                "id": 1,
                "category": "1"
            }
        ]
    }
]
(Ici, une seule commande est affichée mais comme le montrent les crochets, il peut en renvoyer plusieurs à la fois s'il y en a plus)
Le projet se compile en war avec maven et peut ensuite être déployé sur un tomcat.
La difficulté à essayer de faire communiquer le back et le front nous a considérablement bloqué.
Nous pouvons voir dans le front que les requêtes fetch sont censées renvoyer des données (par exemple, il y a ajout de cellules lorsqu'un résultat est attendu dans un tableau).
Cependant, ne pouvant pas accéder à tomcat distant, le résultat de la requête est indéfini (undefined).
Afin d'obtenir un apperçu visuel de la création de sandwich, nous avons rajouté les colonnes, lignes et cellules manquantes en dur.

Après réflexion, nous aurions du plus soliciter votre aide lors des séance en votre présence comme l'a fait le groupe de Matthieu, Romain, Thomas et Elodie