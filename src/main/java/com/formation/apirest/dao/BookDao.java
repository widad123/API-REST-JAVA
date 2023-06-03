package com.formation.apirest.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookDao {
	
private static List<Book> books = Collections.synchronizedList(new ArrayList<>());
private static List<Comment> comments1 = Collections.synchronizedList(new ArrayList<>());
private static List<Comment> comments2 = Collections.synchronizedList(new ArrayList<>());

	
	static {
		comments1.addAll(List.of(
				new Comment("L'histoire de la lecture féminine se reflète dans la peinture et la photographie","Stefan Bollmann , Laure Adler"),
				new Comment("Les artistes de toutes les époques ont représenté des femmes en train de lire","Stefan Bollmann , Laure Adler")
				));
		
		comments2.addAll(List.of(
				new Comment("Laure Adler est journaliste, historienne et écrivaine","autor wika"),
				new Comment("Pendant longtemps, la majorité des femmes surent lire, mais pas écrire","wika")
				));
		
		books.addAll(
				List.of(
						new Book("Les femmes qui lisent sont dangereuses","Stefan Bollmann , Laure Adler ",2015,comments1),
						new Book("Les femmes qui écrivent vivent dangereusement","Laure Adler, Stefan Bollmann , Odile Demange)",2022,comments2)
				)
		);
	}
	
	/***
	 * Fonction qui retourne tous les livre
	 * ***/
	public List<Book> getBooks() {
		return books;
	}
	
	/***
	 *fonction qui retourne les détails d'un livre spécifique
	 * */
	public Book getBook(Integer bookId) {
		for(Book book : books) {
			if(book.getId()==bookId) {
				return book;
			}
		}
		return null;
	}
	
	/***
	 * fonction qui cree un nouveau livre
	 * **/
	public void addBook(Book book) {
		books.add(book);
	}
	
	/**
	 * 	 * fonction qui mis à jour un livre
		 * */
		public boolean updateBook(Book _book) {
			Book book = this.getBook(_book.getId());
			if(book == null) {
				return false;
			}
			book.setTitle(_book.getTitle());
			book.setAuthor(_book.getAuthor());
			book.setPublicationYear(_book.getPublicationYear());
			book.setCommentList(_book.getComments());
			return true;
		}
	
	/**
	 * fonction qui suprime un livre***/
	public void deleteBook(Integer id) {
		for(int index = 0; index < books.size(); index++) {
			if(books.get(index).getId()==id) {
				books.remove(index);
				return;
			}
		}
	}
	

	
//	/***
//	 * fonction qui cherche les livres qu'on le titre= titre */
	public List<Book> searchBooks(String title) {
		List<Book> results = new ArrayList<>();
		for(Book book : books) {
			if(book.getTitle().toUpperCase().contains(title.toUpperCase())) {
				results.add(book);
			
		}
		}
	return results;		
	}
	
//	/***
//	 * fonction qui cherche les livres qu'on le meme author */
	public List<Book> searchBooksByAuthor(String author) {
		List<Book> results = new ArrayList<>();
		for(Book book : books) {
			if(book.getAuthor().toUpperCase().contains(author.toUpperCase())) {
				results.add(book);
			
		}
		}
	return results;		
	}
	
//Récupérer la liste de tous les commentaires d'un livre.
	public List<Comment> getComments(Integer bookId) {
		return getBook(bookId).getComments();
	}
	
// Récupérer les détails d'un commentaire spécifique d'un livre.
	public Comment getComment(Integer bookId,Integer commentId) {
		List<Comment> commentaires = getComments(bookId);
			for(Comment com : commentaires) {
				if(com.getId()==commentId) {
					return com;
				}
			}
			return null;
	}
	

	//Ajouter un nouveau commentaire à un livre.
	public void addComment(Integer bookId,Comment com) {
		getBook(bookId).setComments(com);
	}
	
	//Mettre à jour les informations d'un commentaire existant d'un livre.
	public boolean updateComment(Integer bookId,Comment com) {
		Comment comment = this.getComment(bookId,com.getId());
		if(comment == null) {
			return false;
		}
		comment.setMessage(com.getMessage());
		comment.setAuthor(com.getAuthor());
		return true;
	}
	
	//Supprimer un commentaire d'un livre.
	public void deleteComment(Integer bookId, Integer commentId) {
		for(int index = 0; index < getComments(bookId).size(); index++) {
			if(getComments(bookId).get(index).getId()==commentId) {
				getComments(bookId).remove(index);
				return;
			}
		}
	} 
	

}
