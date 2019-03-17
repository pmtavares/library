package com.library.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.domain.Users;
import com.library.service.impl.UsersServiceImpl;

@RestController
@RequestMapping("/library")
public class UsersController {
	
	@Autowired
	private UsersServiceImpl userService;
	
	@RequestMapping(value="/users", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Collection<Users> getAllCategories()
	{
		return userService.searchAll();
	}
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
	public Users searchById(@PathVariable Long id)
	{
		return userService.searchById(id);
	}
	
	@RequestMapping(value="/users/register", method=RequestMethod.POST)
	public boolean registerAuthor(@RequestBody Users user)
	{				
		return userService.register(user);
	}
	
	@RequestMapping(value="/users/save", method=RequestMethod.PUT)
	public Users updateAuthor(@RequestBody Users user)
	{				
		return userService.save(user);
	}
	
	@RequestMapping(value="/users/remove/{id}", method=RequestMethod.DELETE)
	public boolean deleteUser(@PathVariable Long id)
	{		
		
		return userService.delete(id);
	}

}
