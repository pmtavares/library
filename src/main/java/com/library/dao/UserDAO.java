package com.library.dao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.domain.Users;
import com.library.repository.UserRepository;

@Component
public class UserDAO {

	@Autowired
	private UserRepository userRepository;
	
	public Users searchById(Long id)
	{
		return userRepository.searchById(id);
	}
	
	public Collection<Users> searchAll()
	{
		Collection<Users> users = userRepository.findAll();
		return users;
	}
	
	public void register(Users user)
	{
		userRepository.save(user);
	}
	
	public void deleteById(Long id)
	{
		Users user = userRepository.searchById(id);
		userRepository.delete(user);	
	}
	
}
