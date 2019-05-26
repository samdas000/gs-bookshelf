package com.space.bookshelf.services.book.model;

import com.space.bookshelf.model.Entity;

public class Book extends Entity
{	
	private String stream = "";	
	private String standard = "";
	private String subject = "";
	private String author = "";
	private String title = "";
	private String edition = "";
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	public String toString()
	{
		return id + "| " + stream + "| " + standard + "| " + subject + "| " + author 
				+ "| " + title + "| " + edition + "<br/>";
		
		
	}
	
	

}
