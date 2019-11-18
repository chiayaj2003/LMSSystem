/**
 * 
 */
package com.ss.lms.models;

import java.io.Serializable;

/**
 * @author chiayang
 *
 */
public class Publisher {
	
	private static final long serialVersionUID = 0;
	
	private Integer publisherId;
	
	private String publisherName;
	
	private String publisherAddress;
	
	public Publisher() {		
	}

	public Publisher(Integer publisherId, String publisherName, String publisherAddress) {
		this.publisherId = publisherId;
		this.publisherName = publisherName;
		this.publisherAddress = publisherAddress;		
	}	
	
	public Integer getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPublisherAddress() {
		return publisherAddress;
	}

	public void setPublisherAddress(String publisherAddress) {
		this.publisherAddress = publisherAddress;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
