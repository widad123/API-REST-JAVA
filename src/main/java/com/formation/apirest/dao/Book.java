package com.formation.apirest.dao;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Book {
	
	 	private int id;
	    private String title;
	    private String author;
	    private int publicationYear;
	    private List<Comment> comments;
	    
		private static AtomicInteger SEQUENCE_NEXT_ID = new AtomicInteger(1);

	    
		public Book(String title, String author, int publicationYear, List<Comment> comments) {
			super();
			this.id = SEQUENCE_NEXT_ID.getAndIncrement();
			this.title = title;
			this.author = author;
			this.publicationYear = publicationYear;
			this.comments = comments;
			
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public int getPublicationYear() {
			return publicationYear;
		}

		public void setPublicationYear(int publicationYear) {
			this.publicationYear = publicationYear;
		}

		public List<Comment> getComments() {
			return comments;
		}

		public void setComments(Comment comments) {
			this.comments.add(comments);
		}

		public void setCommentList(List<Comment> comments2) {
			this.comments = comments2;
		}
	    
}
