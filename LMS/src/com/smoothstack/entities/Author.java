package com.smoothstack.entities;

public class Author {
	
	//declare variables
	private String authorId;
	private String authorName;
	
	public Author(String authorsData) {
		String[] dataArray = authorsData.split(",",2);
		authorId = dataArray[0];
		authorName = dataArray[1];
	}

	public Author(String authorId, String authorName) {
		this.authorId = authorId;
		this.authorName = authorName;
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
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}
	
	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public String CSV() {
		return authorId+","+authorName;
	}

}	



