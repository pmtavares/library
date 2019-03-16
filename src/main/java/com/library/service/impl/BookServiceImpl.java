package com.library.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.dao.BookDAO;
import com.library.domain.Book;
import com.library.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO bookDao;

	@Override
	public boolean register(Book book) {
		try {
			bookDao.register(book);
			return true;
		}
		catch(NullPointerException ex)
		{
			System.out.println(ex.getMessage());
			return false;
		}
		
	}

	@Override
	public boolean delete(Long id) {
		try {
			bookDao.deleteById(id);
			return true;
		}
		catch(NullPointerException ex)
		{
			System.out.println(ex.getMessage());
			return false;
		}
	}

	@Override
	public Collection<Book> searchAll() {
		return bookDao.searchAll();
	}

	@Override
	public Book searchById(Long bookId) {
		Book book = bookDao.searchById(bookId);
		return book;
	}

}
