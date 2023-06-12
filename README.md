# API-REST-JAVA

Exercice 1: Ressource "users" (utilisateurs)

Énoncé :
Créez un contrôleur Spring MVC pour une ressource "users" (utilisateurs) avec les fonctionnalités CRUD. Chaque utilisateur doit avoir un identifiant unique, un nom et une adresse e-mail.

Endpoints :

GET /users : Récupérer la liste de tous les utilisateurs.
GET /users/{userId} : Récupérer les détails d'un utilisateur spécifique.
POST /users : Créer un nouvel utilisateur.
PUT /users/{userId} : Mettre à jour les informations d'un utilisateur existant.
DELETE /users/{userId} : Supprimer un utilisateur.

Classes POJO associées :

public class User {
    private int id;
    private String name;
    private String email;
    private String password;

    // Constructeurs, getters et setters
}
[09:09]
Exercice 2: Ressource "books" (livres) avec sous-ressource "comments" (commentaires)

Énoncé :
Créez un contrôleur Spring MVC pour une ressource "books" (livres) avec les fonctionnalités CRUD. Chaque livre doit avoir un identifiant unique, un titre, un auteur et une année de publication. De plus, chaque livre peut avoir plusieurs commentaires. Chaque commentaire doit avoir un identifiant unique, un texte et un auteur.

Endpoints pour la ressource "books" :

GET /books : Récupérer la liste de tous les livres.
GET /books/{bookId} : Récupérer les détails d'un livre spécifique.
POST /books : Créer un nouveau livre.
PUT /books/{bookId} : Mettre à jour les informations d'un livre existant.
DELETE /books/{bookId} : Supprimer un livre.
GET /books/search?title=value : Récupérer la liste de tous les livres qui ont le titre contenant la value.
title est required
GET /books/searchByAuthor/{autheur} : Récupérer la liste de tous les livres qui ont l'autre = auteur.
title est required

Endpoints pour la sous-ressource "comments" :

GET /books/{bookId}/comments : Récupérer la liste de tous les commentaires d'un livre.
GET /books/{bookId}/comments/{commentId} : Récupérer les détails d'un commentaire spécifique d'un livre.
POST /books/{bookId}/comments : Ajouter un nouveau commentaire à un livre.
PUT /books/{bookId}/comments/{commentId} : Mettre à jour les informations d'un commentaire existant d'un livre.
DELETE /books/{bookId}/comments/{commentId} : Supprimer un commentaire d'un livre.

Classes POJO associées :

public class Book {
    private int id;
    private String title;
    private String author;
    private int publicationYear;
    private List<Comment> comments;

    // Constructeurs, getters et setters
}

public class Comment {
    private int id;
    private String message;
    private String author;

    // Constructeurs, getters et setters
}
[09:09]
Exercice 3 : Ressource "auth" (authentification)

Énoncé :
Créez un contrôleur Spring MVC pour gérer l'authentification des utilisateurs. La ressource "auth" doit fournir des endpoints pour permettre aux utilisateurs de se connecter (login) avec le login et le password et de se déconnecter (logout). De plus, un token (un String) doit être généré lors de la connexion et utilisé pour authentifier les requêtes ultérieures.
N'oublier pas d'utiliser le POJO User dans l'exercice 1 (email, password)

Endpoints attendus :

POST /login : Permet à l'utilisateur de se connecter en fournissant un nom d'utilisateur et un mot de passe (en RequestBody). En cas de succès, un token est généré et renvoyé en réponse.
GET /logout?token=<TOKEN> : Permet à l'utilisateur de se déconnecter avec le TOKEN. L'utilisateur est déconnecté et le token devient invalide.
GET /isvalid?token=<TOKEN> : Permet à l'utilisateur de dire si le token est valide (true ou false). 

PS : Il faudra créer une classe TokenManager qui permet de pouvoir gérer le token
