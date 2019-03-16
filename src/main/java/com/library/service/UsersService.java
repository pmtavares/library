package com.library.service;

import java.util.Collection;

import com.library.domain.Users;

public interface UsersService {
	
	public boolean register(Users user);
	
	public boolean delete(Long id);
	
	public Collection<Users> searchAll();
	
	public Users searchById(Long bookId);
}
