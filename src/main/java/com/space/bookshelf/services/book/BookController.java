package com.space.bookshelf.services.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.space.bookshelf.services.book.dao.BookDAO;
import com.space.bookshelf.services.book.model.Book;
import com.space.bookshelf.services.donor.dao.DonorDAO;
import com.space.bookshelf.services.donor.model.Donor;
import com.space.bookshelf.system.BeanUtil;

@RestController
public class BookController 
{
	@Autowired
	private BookDAO dao;
	
	
	@RequestMapping("/punya/book/add_old")
	public String getListofBooks_old()
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
	
	
	@RequestMapping("/punya/book/add")
	public String getListofBooks(@RequestParam(name="stream") String stream,
			@RequestParam(name="standard") String standard,
			@RequestParam(name="subject") String subject,
			@RequestParam(name="author") String author,
			@RequestParam(name="title") String title,
			@RequestParam(name="edition") String edition)
	{
		Book book = new Book();
		
		String message = "";
		
		if((stream != null) && (standard != null) && (subject != null) && 
				(author != null) && (title != null) && (edition != null))
		{
			//book.setId("1");
	        book.setStream(stream);
	        book.setStandard(standard);
	        book.setSubject(subject);
	        book.setAuthor(author);
	        book.setTitle(title);
	        book.setEdition(edition);
	        
	        int i = dao.addBook(book);
			
			System.out.println("here");
	        if(i==1)
	        {
			System.out.println("here 1");
	        	message = "Book details added successfully";
	        }
			
		}
		else
		{
			System.out.println("here 2");
			message = "Mandatory fields: stream, standard, subject, author, title, edition"+
					  "USE:\"stream\"=\"<stream>\",\"standard\"=\"<standard>\",\"subject\"=\"<subject>\","
					  + "\"author\"=\"<author>\",\"title\"=\"<title>\",\"title\"=\"<title>\"";
		}
		
		System.out.println("here 3");
		return message;
		
		//return "index"; later need to forward to boot catalogue page
	}
	
	
	
		
	@RequestMapping("punya/book/show")
	public String show()
	{
		Book book = new Book();
		
		book.setId("1");
        book.setStream("ICSE");
        book.setStandard("Class-IX");
        book.setSubject("History");
        book.setAuthor("Dr Ramesh");
        book.setTitle("History of Independent India");
        book.setEdition("2.0");
        
        List test = new ArrayList();
        test.add (book);        
        test.add (book);        
        test.add (book);        
        //return BeanUtil.getJSon(test);
        return BeanUtil.getJSon(dao.getAllBooks());
        
		//return dao.getAllBooks().toString();		
		
	}
	
	
	@RequestMapping("punya/book/{id}")
	public String showDetails(@PathVariable("id") int id)
	{
		Book book =  dao.getBook(id);
		return BeanUtil.getJSon(book);    
	}
	
	

}
