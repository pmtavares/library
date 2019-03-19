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
import com.library.domain.Review;
import com.library.domain.Users;
import com.library.service.impl.BookServiceImpl;
import com.library.service.impl.ReviewServiceImpl;
import com.library.service.impl.UsersServiceImpl;

public class ReviewServiceTest extends AbstractTest{
		
	@Autowired
	private ReviewServiceImpl reviewService;
	@Autowired
	private BookServiceImpl bookService;
	@Autowired
	private UsersServiceImpl userService;
	
	
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
		Review review = new Review();
		review.setDateReview(new Date());
		review.setScore((short)3);
		
		Book book = bookService.searchById(2L);
		review.setBook(book);
		
		Users user = userService.searchById(2L);
		review.setUser(user);
		
		review.setComment("Test to delete");

		reviewService.register(review);		
		Assert.assertEquals(review.getScore(), (short)3);

	}
	@Test
	@Ignore
	public void searchById()
	{
		Review review = reviewService.searchById(1);
		System.out.println("Review is: " + review.getComment());
		Assert.assertEquals(review.getComment(), "This is a comment test.");
		
	}
	
	@Test
	@Ignore
	public void searchAll()
	{
		Collection<Review> reviews = reviewService.searchAll();
		System.out.println("Review is: " + reviews.toString());
		Assert.assertTrue(reviews.size() > 0);
		
	}
	@Test
	@Ignore
	public void delete()
	{
		Review review = reviewService.searchById(3);
		System.out.print("Review: "+ review.getId() + " deleted." );
		Assert.assertTrue(reviewService.delete(3));
	}


}
