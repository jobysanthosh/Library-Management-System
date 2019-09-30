package com.smoothstack.entities;

public class Publisher {

	//declare variables
	private String publisherId;
	private String publisherName;
	private String publisherAddress;
	
	public Publisher(String publisherId, String publisherName, String publisherAddress) {
		this.publisherId=publisherId;
		this.publisherName=publisherName;
		this.publisherAddress=publisherAddress;
	}
	
	public String getPublisherId() {
		return publisherId;
	}
	
	public void setPublisherId(String publisherId) {
		this.publisherId=publisherId;
	}
	
	public String getPublisherName() {
		return publisherName;
	}
	
	public void setPublisherName(String publisherName) {
		this.publisherName=publisherName;
	}
	
	public String getPublisherAddress() {
		return publisherAddress;
	}
	
	public void setPublisherAddress(String publisherAddress) {
		this.publisherAddress=publisherAddress;
	}
	
	public String CSV() {
		return publisherId+","+publisherName+","+publisherAddress;
	}
	
}
