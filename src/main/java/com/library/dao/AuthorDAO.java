package com.library.dao;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.domain.Author;
import com.library.repository.AuthorRepository;

@Component
public class AuthorDAO{
	
	@Autowired
	private AuthorRepository authorRepository;
	
	
	public void register(Author author)
	{
		authorRepository.save(author);
	}
	
	public Author save(Author author)
	{
		return authorRepository.save(author);
	}
	
	public Author searchById(Long id) {
		Author author = authorRepository.searchById(id);
		return author;
	}
	
	public Collection<Author> searchAll() {
		Collection<Author> author = authorRepository.findAll();
		return author;
	}
	
	public void deleteById(Long id)
	{
		Author author = authorRepository.searchById(id);
		authorRepository.delete(author);	
	}


}
