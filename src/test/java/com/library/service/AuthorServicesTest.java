package com.library.service;

import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.library.AbstractTest;
import com.library.domain.Author;
import com.library.service.impl.AuthorServiceImpl;
import org.junit.Assert;

//@Transactional
public class AuthorServicesTest extends AbstractTest{
	
	@Autowired
	private AuthorServiceImpl authorService;
	
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
		Author author = new Author();
		author.setName("Machado");
		author.setSurname("de Assis");
		author.setDateRegistration(new Date());
		author.setCountry("Brazil");

		authorService.register(author);		
		Assert.assertEquals(author.getName(), "Machado");

	}
	@Test
	@Ignore
	public void searchById()
	{
		Author author = authorService.searchById(1L);
		System.out.println("Author is: " + author.getName());
		Assert.assertEquals(author.getName(), "Pedro");
		
	}
	
	@Test
	@Ignore
	public void searchAll()
	{
		Collection<Author> authors = authorService.searchAll();
		System.out.println("Author is: " + authors.toString());
		Assert.assertTrue(authors.size() > 3);
		
	}
	@Test
	@Ignore
	public void delete()
	{
		Author author = authorService.searchById(4L);
		System.out.print("Author: "+ author.getId() + " - " + author.getName() + " deleted." );
		Assert.assertTrue(authorService.delete(4L));
	}

}
