package com.library.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.library.domain.Book;
import com.library.service.impl.BookServiceImpl;


@RestController
@RequestMapping("/library")
public class BooksController {
	
	@Autowired
	private BookServiceImpl bookService;
	
	@RequestMapping(value="/books", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Collection<Book> getAll()
	{
		return bookService.searchAll();
	}
	
	@RequestMapping(value="/books/{id}", method=RequestMethod.GET)
	public Book searchById(@PathVariable Long id)
	{
		return bookService.searchById(id);
	}
	
	@RequestMapping(value="/books/register", method=RequestMethod.POST)
	public boolean registerBook(@RequestBody Book book)
	{				
		return bookService.register(book);
	}
	
	@RequestMapping(value="/books/save", method=RequestMethod.PUT)
	public Book updateBook(@RequestBody Book book)
	{				
		return bookService.save(book);
	}
	
	@RequestMapping(value="/books/remove/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable Long id)
	{		
		
		return bookService.delete(id);
	}

}
