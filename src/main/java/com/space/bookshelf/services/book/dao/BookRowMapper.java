package com.space.bookshelf.services.book.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.space.bookshelf.services.book.model.Book;
import com.space.bookshelf.services.donor.model.Donor;

public class BookRowMapper implements RowMapper<Book> {

	
    @Override
    public Book mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Book book = new Book();
        
        book.setId(rs.getString("ID"));
        book.setStream(rs.getString("STREAM"));
        book.setStandard(rs.getString("STANDARD"));
        book.setSubject(rs.getString("SUBJECT"));
        book.setAuthor(rs.getString("AUTHOR"));
        book.setTitle(rs.getString("TITLE"));
        book.setEdition(rs.getString("EDITION"));
        
        return book;
    }


}

