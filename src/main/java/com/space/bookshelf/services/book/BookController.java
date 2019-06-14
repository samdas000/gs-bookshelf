package com.space.bookshelf.services.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.space.bookshelf.services.book.dao.BookDAO;
import com.space.bookshelf.services.book.model.Book;
import com.space.bookshelf.services.donor.dao.DonorDAO;
import com.space.bookshelf.services.donor.model.Donor;

@RestController
public class BookController 
{
	@Autowired
	private BookDAO dao;
	
	
	@RequestMapping("/punya/book/add")
	public String getListofBooks()
	{
		Book book = new Book();
		
		book.setId("1");
        book.setStream("ICSE");
        book.setStandard("Class-IX");
        book.setSubject("History");
        book.setAuthor("Dr Ramesh");
        book.setTitle("History of Independent India");
        book.setEdition("2.0");
        
		dao.addBook(book);
		return "Book details uploaded!!";
		
		//return "index"; later need to forward to boot catalogue page
	}
	
	
	@RequestMapping("punya/book/show")
	public String Show()
	{
		//return dao.getAllBooks().toString();	
		return BeanUtil.getJSon(dao.getAllBooks());
		
	}
	
	@RequestMapping("punya/book/{id}")
	public String showDetails(@PathVariable("id") int id)
	{
		Book book =  dao.getBook(id);
		return BeanUtil.getJSon(book);    
	}
	
	
	

}
