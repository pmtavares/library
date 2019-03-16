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
import com.library.domain.Users;

import com.library.service.impl.UsersServiceImpl;

public class UsersServiceTest extends AbstractTest {
	
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
		Users users = new Users();

		users.setName("Test");
		users.setSurname("Test");
		users.setActive(true);
		users.setAddress("Parnell street, Dublin 1");
		users.setCity("Dublin");
		users.setEmail("test@test.com");
		users.setPostcode("D1");
		users.setUsername("johnst");
		users.setPassword("123456");
		users.setImage("images/users/no-image.jpg");
		users.setDateRegistration(new Date());
		
		userService.register(users);		
		Assert.assertEquals(users.getName(), "Test");

	}
	@Test
	@Ignore
	public void searchById()
	{
		Users user = userService.searchById(1L);
		System.out.println("User is: " + user.getName());
		Assert.assertEquals(user.getName(), "Pedro");
		
	}
	
	@Test
	@Ignore
	public void searchAll()
	{
		Collection<Users> users = userService.searchAll();
		System.out.println("Users are: " + users.toString());
		Assert.assertTrue(users.size() > 1);
	}
	@Test
	@Ignore
	public void delete()
	{
		Users users = userService.searchById(3L);
		System.out.print("User: "+ users.getName() + " deleted." );
		Assert.assertTrue(userService.delete(users.getId()));
	}
	
}
