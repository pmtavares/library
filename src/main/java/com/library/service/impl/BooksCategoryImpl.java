package com.library.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.BooksCategoryDAO;
import com.library.domain.BooksCategory;
import com.library.service.BooksCategoryService;

@Service
public class BooksCategoryImpl implements BooksCategoryService{

	@Autowired
	BooksCategoryDAO booksCategoryDAO;
	
	@Override
	public boolean register(BooksCategory category) {
		try
		{
			booksCategoryDAO.register(category);
			return true;
		}
		catch(NullPointerException ex)
		{
			
			return false;
		}
		
	}
	
	@Override
	public BooksCategory save(BooksCategory category) {
		
		BooksCategory categoryToUpdate = booksCategoryDAO.searchById(category.getId());
		
		if(categoryToUpdate != null)
		{
			categoryToUpdate.setCategory(category.getCategory());
			categoryToUpdate.setDescription(category.getDescription());
			return booksCategoryDAO.save(categoryToUpdate);
		}
		return booksCategoryDAO.save(category);
		
			
	}

	@Override
	public boolean delete(int id) {
		BooksCategory category = booksCategoryDAO.searchById(id);
		if(category != null)
		{
			try
			{			
				booksCategoryDAO.deleteById(category);
				return true;
			}
			catch(NullPointerException ex)
			{				
				throw ex;
			}
		}
		
		return false;
	}

	@Override
	public Collection<BooksCategory> searchAll() {
		Collection<BooksCategory> categories = booksCategoryDAO.searchAll();
		return categories;
	}

	@Override
	public BooksCategory searchById(int id) {
		BooksCategory category = booksCategoryDAO.searchById(id);
		return category;
	}

}
