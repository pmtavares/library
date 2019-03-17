package com.library.service.impl;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.dao.AuthorDAO;
import com.library.domain.Author;
import com.library.domain.BooksCategory;
import com.library.service.AuthorService;



@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	private AuthorDAO authorDao;

	public boolean register(Author author) {
		try
		{
			authorDao.register(author); ;
			return true;
			
		}
		catch(NullPointerException ex)
		{
			System.out.println(ex.getMessage());
			return false;
		}
		

	}
	
	@Override
	public Author save(Author author) {
		
		Author authorToUpdate = authorDao.searchById(author.getId());
		
		if(authorToUpdate != null)
		{
			authorToUpdate.setName(author.getName());
			authorToUpdate.setSurname(author.getSurname());
			return authorDao.save(authorToUpdate);
		}
		return authorDao.save(author);
		
			
	}

	@Override
	public boolean delete(Long id) {
		try
		{
			authorDao.deleteById(id) ;
			return true;
			
		}
		catch(NullPointerException ex)
		{
			System.out.println(ex.getMessage());
			return false;
		}
	}

	@Override
	public Collection<Author> searchAll() {
		
		return authorDao.searchAll();
	}

	@Override
	public Author searchById(Long authorId) {
		Author author = authorDao.searchById(authorId);
		return author;
	}

}
