package com.library.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.domain.Author;
import com.library.service.impl.AuthorServiceImpl;

@RestController
@RequestMapping("/library")
public class AuthorController {
	
	@Autowired
	private AuthorServiceImpl authorService;
	
	
	@RequestMapping(value="/authors", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Collection<Author> getAllCategories()
	{
		return authorService.searchAll();
	}
	
	@RequestMapping(value="/authors/{id}", method=RequestMethod.GET)
	public Author searchById(@PathVariable Long id)
	{
		return authorService.searchById(id);
	}
	
	@RequestMapping(value="/authors/register", method=RequestMethod.POST)
	public boolean registerAuthor(@RequestBody Author author)
	{				
		return authorService.register(author);
	}
	
	@RequestMapping(value="/authors/save", method=RequestMethod.PUT)
	public Author updateAuthor(@RequestBody Author author)
	{				
		return authorService.save(author);
	}
	
	@RequestMapping(value="/authors/remove/{id}", method=RequestMethod.DELETE)
	public boolean deleteAuthor(@PathVariable Long id)
	{		
		
		return authorService.delete(id);
	}

}
