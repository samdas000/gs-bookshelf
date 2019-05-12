package com.space.bookshelf.services.book.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.space.bookshelf.services.book.model.Book;

public class BookRowMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Book book = new Book();
        
        
                
        return book;
    }


}

