package com.library.dao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.domain.Book;
import com.library.repository.BooksRepository;

@Component
public class BookDAO {
	
	@Autowired
	BooksRepository bookRepository;
	
	public void register(Book book)
	{
		bookRepository.save(book);
	}
	
	public Book searchById(Long id) {
		Book book = bookRepository.searchById(id);
		return book;
	}
	
	public Collection<Book> searchAll() {
		Collection<Book> books = bookRepository.findAll();
		return books;
	}
	
	public void deleteById(Long id)
	{
		Book book = bookRepository.searchById(id);
		bookRepository.delete(book);	
	}


}
