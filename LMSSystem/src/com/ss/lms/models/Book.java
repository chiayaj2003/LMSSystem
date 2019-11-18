/**
 * 
 */
package com.ss.lms.models;

import java.io.Serializable;

/**
 * @author chiayang
 *
 */
public class Book {
	
	private static final long serialVersionUID = 0;
	
	private String bookIsbn;
	
	private String bookTitle;
	
	private int AuthorId;
	
	public Book() {
		
	}
	
	public Book(String bookIsbn, String bookTitle, int AuthorId) {
		this.bookIsbn = bookIsbn;
		this.bookTitle = bookTitle;
		this.AuthorId = AuthorId;
	}	

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}	
	
	public String getBookIsbn() {
		return bookIsbn;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getAuthorId() {
		return AuthorId;
	}

	public void setAuthorId(int authorId) {
		AuthorId = authorId;
	}		
}
