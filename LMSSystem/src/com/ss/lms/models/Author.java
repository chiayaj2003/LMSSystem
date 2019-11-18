package com.ss.lms.models;

import java.util.ArrayList;
import java.util.List;
import com.ss.lms.models.Book;
import java.io.Serializable;

public class Author implements Serializable {
	
	private static final long serialVersionUID = 0;
	
	private Integer authorId;
	
	private String authorName;	
	
	private String authorPhoneNumber;
	
	// Removed - please refer to Book.dao for add and delete method.
	private List<Book> books;

	public Author() {
		
	}
	
	public Author(Integer authorId, String authorName, String authorPhoneNumber) {
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorPhoneNumber = authorPhoneNumber;
		this.books = new ArrayList<Book>();
	}	

	/**
	 * @return the authorId
	 */
	public Integer getAuthorId() {
		return authorId;
	}

	/**
	 * @param authorId
	 * the authorId to set
	 */
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public static long getSerialversionUid() {
		return serialVersionUID;
	}

	public String getAuthorPhoneNumber() {
		return authorPhoneNumber;
	}

	public void setAuthorPhoneNumber(String authorPhoneNumber) {
		this.authorPhoneNumber = authorPhoneNumber;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}			
}
