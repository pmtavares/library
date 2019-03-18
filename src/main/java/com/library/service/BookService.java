package com.library.service;

import java.util.Collection;

import com.library.domain.Book;

public interface BookService {
	
	public boolean register(Book book);
	
	public Book save(Book book);
	
	public boolean delete(Long id);
	
	public Collection<Book> searchAll();
	
	public Book searchById(Long bookId);

}
