package com.library.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.domain.Review;
import com.library.service.impl.ReviewServiceImpl;

@RestController
@RequestMapping("/library")
public class ReviewController {
	@Autowired
	private ReviewServiceImpl reviewService;
	
	@RequestMapping(value="/reviews", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Collection<Review> getAll()
	{
		return reviewService.searchAll();
	}
	
	@RequestMapping(value="/reviews/{id}", method=RequestMethod.GET)
	public Review searchById(@PathVariable int id)
	{
		return reviewService.searchById(id);
	}
	
	@RequestMapping(value="/reviews/register", method=RequestMethod.POST)
	public boolean registerBook(@RequestBody Review review)
	{				
		return reviewService.register(review);
	}
	
	@RequestMapping(value="/reviews/save", method=RequestMethod.PUT)
	public Review updateBook(@RequestBody Review review)
	{				
		return reviewService.save(review);
	}
	
	@RequestMapping(value="/reviews/remove/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable int id)
	{		
		
		return reviewService.delete(id);
	}
	
	@RequestMapping(value="/reviews/{id}/user", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Collection<Review> searchAllByUser(@PathVariable Long id)
	{	
		return reviewService.searchByUserId(id);
	}


}
