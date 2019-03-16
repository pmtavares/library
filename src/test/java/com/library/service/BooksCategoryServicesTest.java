package com.library.service;

import java.util.Collection;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.library.AbstractTest;
import com.library.domain.BooksCategory;
import com.library.service.impl.BooksCategoryImpl;

@Transactional
public class BooksCategoryServicesTest extends AbstractTest {
	
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
		BooksCategory category = new BooksCategory();
		category.setCategory("Philosophy");
		category.setDescription("Philosophy, is not contemplation, reflection or "
				+ "communication, but the creation of concepts.");

		booksCategoryService.register(category);		
		Assert.assertEquals(category.getCategory(), "Philosophy");

	}
	@Test
	@Ignore
	public void searchById()
	{
		BooksCategory category = booksCategoryService.searchById(1);
		System.out.println("Cateogry is: " + category.getCategory());
		Assert.assertEquals(category.getCategory(), "IT");
		
	}
	
	@Test
	@Ignore
	public void searchAll()
	{
		Collection<BooksCategory> categories = booksCategoryService.searchAll();
		System.out.println("Author is: " + categories.toString());
		Assert.assertTrue(categories.size() > 1);
		
	}
	@Test
    @Ignore
	public void delete()
	{
		BooksCategory category = booksCategoryService.searchById(2);
		System.out.print("BooksCategory: "+ category.getCategory() + " deleted." );
		Assert.assertTrue(booksCategoryService.delete(2));
	}
	
	@Test
    @Ignore
	public void update()
	{
		BooksCategory category = booksCategoryService.searchById(5);
		category.setDescription("Books about famous people's life");
		
		//Assert.assertTrue(booksCategoryService.save(category));
	}

}
