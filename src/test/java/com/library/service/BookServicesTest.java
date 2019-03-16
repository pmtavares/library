package com.library.service;

import java.util.Collection;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.library.AbstractTest;
import com.library.domain.Book;
import com.library.domain.BooksCategory;
import com.library.service.impl.BookServiceImpl;
import com.library.service.impl.BooksCategoryImpl;

public class BookServicesTest extends AbstractTest {
	@Autowired
	private BookServiceImpl bookService;
	@Autowired
	private BooksCategoryImpl booksCategoryService;
	
	@Before //execute before the test has started
	public void setUp()
	{
		System.out.println("Testing starting...");	
		
	}
			
	@After //execute after the test has finished
	public void closeDown()
	{
		System.out.println("Testing finished");
	}
	
	
	@Test
	@Ignore
	public void register()
	{
		Book book = new Book();
		book.setTitle("Test to delete");
		book.setDescription("Description to delete");
		book.setCountry("Brazil");
		book.setEdition((short) 1);
		book.setCopies(5);
		
		BooksCategory category = booksCategoryService.searchById(3);;
		
		book.setCategory(category);
		bookService.register(book);		
		Assert.assertEquals(book.getTitle(), "Test to delete");

	}
	@Test
	@Ignore
	public void searchById()
	{
		Book book = bookService.searchById(1L);
		System.out.println("Book is: " + book.getTitle());
		Assert.assertEquals(book.getTitle(), "Java Script for dummies");
		
	}
	
	@Test
	@Ignore
	public void searchAll()
	{
		Collection<Book> books = bookService.searchAll();
		System.out.println("Book is: " + books.toString());
		Assert.assertTrue(books.size() > 1);
	}
	@Test
	@Ignore
	public void delete()
	{
		Book book = bookService.searchById(3L);
		System.out.print("Book: "+ book.getTitle() + " deleted." );
		Assert.assertTrue(bookService.delete(book.getId()));
	}

}
