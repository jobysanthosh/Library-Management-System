package com.smoothstack.entities;

public class Book {

	private String bookId;
	private String bookTitle;
	private String authorId;
	private String publisherId;
	
	public Book(String bookData) {
		String[] dataArray = bookData.split(",",4);
		bookId = dataArray[0];
		bookTitle = dataArray[1];
		authorId = dataArray[2];
		publisherId = dataArray[3];
	}
	
	public Book(String bookId, String bookTitle, String authorId, String publisherId) {
		this.bookId=bookId;
		this.bookTitle=bookTitle;
		this.authorId=authorId;
		this.publisherId=publisherId;
	}

	/**
	 * @return the bookId
	 */
	public String getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the bookTitle
	 */
	public String getBookTitle() {
		return bookTitle;
	}

	/**
	 * @param bookTitle the bookTitle to set
	 */
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	/**
	 * @return the authorId
	 */
	public String getAuthorId() {
		return authorId;
	}

	/**
	 * @param authorId the authorId to set
	 */
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	/**
	 * @return the publisherId
	 */
	public String getPublisherId() {
		return publisherId;
	}

	/**
	 * @param publisherId the publisherId to set
	 */
	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}
	
	public String CSV() {
		return bookId+","+bookTitle+","+authorId+","+publisherId;
	}
}
