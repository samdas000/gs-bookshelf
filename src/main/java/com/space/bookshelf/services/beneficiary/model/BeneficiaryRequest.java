package com.space.bookshelf.services.beneficiary.model;

import com.space.bookshelf.services.book.model.Book;

public class BeneficiaryRequest 
{
	private Book book;
	//book_id, beneficiary_id, new java.sql.Date(System.currentTimeMillis()), "N"
	private Beneficiary beneficiary;

		
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Beneficiary getBeneficiary() {
		return beneficiary;
	}
	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}
	

}
