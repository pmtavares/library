package com.library.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.dao.UserDAO;
import com.library.domain.Author;
import com.library.domain.Users;
import com.library.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UserDAO userDao;


	public boolean register(Users user) {
		try
		{
			userDao.register(user); ;
			return true;
			
		}
		catch(NullPointerException ex)
		{
			System.out.println(ex.getMessage());
			return false;
		}
	}


	public boolean delete(Long id) {
		try
		{
			userDao.deleteById(id);
			return true;
			
		}
		catch(NullPointerException ex)
		{
			System.out.println(ex.getMessage());
			return false;
		}
	}


	public Collection<Users> searchAll() {
		return userDao.searchAll();
	}

	public Users searchById(Long bookId) {
		return userDao.searchById(bookId);
	}


	@Override
	public Users save(Users user) {
		Users userToUpdate = userDao.searchById(user.getId());
		
		if(userToUpdate != null)
		{
			userToUpdate.setName(user.getName());
			userToUpdate.setSurname(user.getSurname());
			userToUpdate.setCity(user.getCity());
			userToUpdate.setEmail(user.getEmail());
			userToUpdate.setPostcode(user.getPostcode());
			userToUpdate.setAddress(user.getAddress());
			return userDao.save(userToUpdate);
		}
		return userDao.save(user);
	}

}
