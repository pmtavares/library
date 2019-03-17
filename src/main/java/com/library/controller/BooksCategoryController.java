package com.library.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.domain.BooksCategory;
import com.library.service.impl.BooksCategoryImpl;

@RestController
@RequestMapping("/library")
public class BooksCategoryController {
	
	@Autowired
	private BooksCategoryImpl booksCategory;
	
	@RequestMapping(value="/categories", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Collection<BooksCategory> getAllCategories()
	{
		return booksCategory.searchAll();
	}
	
	@RequestMapping(value="/categories/{id}", method=RequestMethod.GET)
	public BooksCategory searchById(@PathVariable int id)
	{
		return booksCategory.searchById(id);
	}
	
	@RequestMapping(value="/categories/register", method=RequestMethod.POST)
	public boolean registerCategory(@RequestBody BooksCategory category)
	{				
		return booksCategory.register(category);
	}
	
	@RequestMapping(value="/categories/save", method=RequestMethod.PUT)
	public BooksCategory updateCategory(@RequestBody BooksCategory category)
	{				
		return booksCategory.save(category);
	}
	
	@RequestMapping(value="/categories/remove/{id}", method=RequestMethod.DELETE)
	public boolean deleteCategory(@PathVariable int id)
	{		
		
		return booksCategory.delete(id);
	}
	
	

}
