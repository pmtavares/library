package com.library.dao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.domain.BooksCategory;
import com.library.repository.BooksCategoryRepository;

@Component
public class BooksCategoryDAO {
	
	@Autowired
	private BooksCategoryRepository booksCategoryRep; 
	
	public void register(BooksCategory category)
	{
		booksCategoryRep.save(category);
	}
	
	public BooksCategory save(BooksCategory category)
	{
		return booksCategoryRep.save(category);
	}
	
	public BooksCategory searchById(int id) {
		BooksCategory category = booksCategoryRep.searchById(id);
		return category;
	}
	
	public Collection<BooksCategory> searchAll() {
		Collection<BooksCategory> categories = booksCategoryRep.findAll();
		return categories;
	}
	
	public void deleteById(BooksCategory category)
	{
		
		booksCategoryRep.delete(category);	
	}
	

}
