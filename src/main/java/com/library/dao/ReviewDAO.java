package com.library.dao;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.domain.Review;
import com.library.repository.ReviewRepository;


@Component
public class ReviewDAO {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	public Review searchById(int id)
	{
		return reviewRepository.searchById(id);
	}
	
	public Collection<Review> searchAll()
	{
		Collection<Review> review = reviewRepository.findAll();
		return review;
	}
	
	public Collection<Review> searchAllByUser(Long id)
	{
		Collection<Review> review = reviewRepository.searchAllByUser(id);
		return review;
	}
	
	public Review save(Review review)
	{
		return reviewRepository.save(review);
	}
	
	public void deleteById(int id)
	{
		Review review = reviewRepository.searchById(id);
		reviewRepository.delete(review);
	}

}
