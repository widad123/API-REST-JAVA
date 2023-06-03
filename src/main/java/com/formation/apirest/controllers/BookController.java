package com.formation.apirest.controllers;
import com.formation.apirest.dao.*;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/***
 * GET /books : Récupérer la liste de tous les livres.
GET /books/{bookId} : Récupérer les détails d'un livre spécifique.
POST /books : Créer un nouveau livre.
PUT /books/{bookId} : Mettre à jour les informations d'un livre existant.
DELETE /books/{bookId} : Supprimer un livre.
GET /books/search?title=value : Récupérer la liste de tous les livres qui ont le titre contenant la value.
title est required
GET /books/searchByAuthor/{autheur} : Récupérer la liste de tous les livres qui ont l'autre = auteur.
title est required
GET /books/{bookId}/comments : Récupérer la liste de tous les commentaires d'un livre.
GET /books/{bookId}/comments/{commentId} : Récupérer les détails d'un commentaire spécifique d'un livre.
POST /books/{bookId}/comments : Ajouter un nouveau commentaire à un livre.
PUT /books/{bookId}/comments/{commentId} : Mettre à jour les informations d'un commentaire existant d'un livre.
DELETE /books/{bookId}/comments/{commentId} : Supprimer un commentaire d'un livre.
 * **/	

@RestController
@RequestMapping("/books")
public class BookController {
	

 private BookDao bookDao = new BookDao();
 
 // * GET /books : Récupérer la liste de tous les livres.
 @GetMapping("")
 public List<Book> listerBooks(){
	 return bookDao.getBooks();
 }
 
 //GET /books/{bookId} : Récupérer les détails d'un livre spécifique.
 @GetMapping("/{bookId}")
 public Book getBook(@PathVariable("bookId") Integer bookId) {
	 return bookDao.getBook(bookId);
 }
 
 //POST /books : Créer un nouveau livre.
 @PostMapping("")
 public void addBook(@RequestBody Book book) {
	 bookDao.addBook(book);
 }
 
 //PUT /books/{bookId} : Mettre à jour les informations d'un livre existant.
 @PutMapping("/{bookId}")
 public boolean updateBook(@PathVariable("bookId") Integer bookId,
		 @RequestBody Book book) {
		book.setId(bookId);		
	 return bookDao.updateBook(book);
 }
 
 //DELETE /books/{bookId} : Supprimer un livre.
 @DeleteMapping("/{bookId}")
public void deleteBook(@PathVariable("bookId") Integer bookId) {
	 bookDao.deleteBook(bookId);
 }

 //GET /books/search?title=value : Récupérer la liste de tous les livres qui ont le titre contenant la value.
// title est required 
 @GetMapping("/search?title=value")
 public List<Book> searchBook(@RequestParam(value="title", required=true) String title){
	 return bookDao.searchBooks(title);
 }
 
 
 //GET /books/searchByAuthor/{autheur} : Récupérer la liste de tous les livres qui ont l'autre = auteur.
 @GetMapping("/searchByAuthor/{autheur}")
 public List<Book> searchBookByAuthor(@PathVariable("autheur") String author){
	 return bookDao.searchBooksByAuthor(author);
 }
 
 //GET /books/{bookId}/comments : Récupérer la liste de tous les commentaires d'un livre.
 @GetMapping("/{bookId}/comments")
public List<Comment> listerComments(@PathVariable("bookId") Integer bookId){
	return bookDao.getComments(bookId);
}
 
//GET /books/{bookId}/comments/{commentId} : Récupérer les détails d'un commentaire spécifique d'un livre.
 @GetMapping("/{bookId}/comments/{commentId}")
public Comment getComment(@PathVariable("bookId") Integer bookId,@PathVariable("commentId") Integer commentId) {
	return bookDao.getComment(bookId, commentId);
}

//POST /books/{bookId}/comments : Ajouter un nouveau commentaire à un livre.
 @PostMapping("/{bookId}/comments")
 public void addComment(@PathVariable("bookId") Integer bookId,@RequestBody Comment comment) {
	 bookDao.addComment(bookId,comment);
 }
 
 //PUT /books/{bookId}/comments/{commentId} : Mettre à jour les informations d'un commentaire existant d'un livre.
 @PutMapping("/{bookId}/comments/{commentId}")
 public void updateComment(@PathVariable("bookId") Integer bookId,
		 @PathVariable("commentId") Integer commentId,
		 @RequestBody Comment comment) {
		comment.setId(commentId);		
	 bookDao.addComment(bookId,comment);
 }

 //DELETE /books/{bookId}/comments/{commentId} : Supprimer un commentaire d'un livre.
 @DeleteMapping("/{bookId}/comments/{commentId}")
public void deleteComment(@PathVariable("bookId") Integer bookId,@PathVariable("commentId") Integer commentId) {
	 bookDao.deleteComment(bookId, commentId);
 }

}
