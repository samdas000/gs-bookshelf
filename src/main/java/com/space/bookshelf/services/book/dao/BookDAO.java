package com.space.bookshelf.services.book.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.space.bookshelf.services.book.model.Book;
import com.space.bookshelf.services.donor.dao.DonorRowMapper;
import com.space.bookshelf.services.donor.model.Donor;

@Repository
public class BookDAO 
{
	

	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert simpleJdbcInsert;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	@Autowired
    public void setDataSource(final DataSource dataSource) 
	{
		System.out.println("initializing JDBC Template" + dataSource.toString());
        jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	public void addBook(Book book) 
	{
		//Add Book	
		
    	System.out.println("Adding Book");
		String sql = "INSERT INTO BOOK (STREAM, STANDARD, SUBJECT, AUTHOR, TITLE, EDITION) "
				+ "values (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, book.getStream(), book.getStandard(), book.getSubject(),
								book.getAuthor(), book.getTitle(), book.getEdition());
		System.out.println("Added Book");
		
	}

	
	
	public List<Book> getAllBooks()
	{
		String sql = "SELECT * FROM BOOK";
        RowMapper<Book> rowMapper = new BookRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	public Book getBook(int id)
	{
		Book book = null;
		String sql = "SELECT * FROM BOOK WHERE ID="+id;
        RowMapper<Book> rowMapper = new BookRowMapper();
		List books = this.jdbcTemplate.query(sql, rowMapper);
		if((books != null) && (books.size()==1))
		{
			book = (Book) books.get(0);
		}
		
		return book;
	}


	
	public List<Book> getOpenRequets()
	{
		String sql = "SELECT * FROM BOOK";
        RowMapper<Book> rowMapper = new BookRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	

}
