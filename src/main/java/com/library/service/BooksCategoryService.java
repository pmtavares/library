package com.library.service;

import java.util.Collection;

import com.library.domain.BooksCategory;

public interface BooksCategoryService {
	
	public boolean register(BooksCategory category);
	
	public BooksCategory save(BooksCategory category);
	
	public boolean delete(int id);
	
	public Collection<BooksCategory> searchAll();
	
	public BooksCategory searchById(int id);

}
