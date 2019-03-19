package com.library.service;

import java.util.Collection;

import com.library.domain.Review;

public interface ReviewService {
	
	public Review save(Review review);
	
	public boolean register(Review review);
	
	public boolean delete(int id);
	
	public Collection<Review> searchAll();
	
	public Collection<Review> searchByUserId(Long Id);
	
	public Review searchById(int Id);

}
