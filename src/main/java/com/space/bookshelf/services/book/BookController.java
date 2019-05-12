package com.space.bookshelf.services.book;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController 
{
	@RequestMapping("/books")
	public String getListofBooks()
	{
		return "index";
	}

}
