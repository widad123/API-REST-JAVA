package com.formation.apirest.dao;

import java.util.concurrent.atomic.AtomicInteger;

public class Comment {

	 	private int id;
	    private String message;
	    private String author;
	    
		private static AtomicInteger SEQUENCE_NEXT_ID = new AtomicInteger(1);

	    
		public Comment(String message, String author) {
			super();
			this.id = SEQUENCE_NEXT_ID.getAndIncrement();
			this.message = message;
			this.author = author;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}
	    
		
	    
}
