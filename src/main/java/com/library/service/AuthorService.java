package com.library.service;

import java.util.Collection;

import com.library.domain.Author;



public interface AuthorService {
	
	public boolean register(Author author);
	
	public Author save(Author author);
	
	public boolean delete(Long id);
	
	public Collection<Author> searchAll();
	
	public Author searchById(Long authorId);

}
