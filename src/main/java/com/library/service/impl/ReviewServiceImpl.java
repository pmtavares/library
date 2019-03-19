package com.library.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.ReviewDAO;
import com.library.domain.Review;
import com.library.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDAO reviewDao;
	
	@Override
	public Review save(Review review) {
		
		return reviewDao.save(review);
	}

	@Override
	public boolean register(Review review) {
		try
		{
			reviewDao.save(review); ;
			return true;
			
		}
		catch(NullPointerException ex)
		{
			System.out.println(ex.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		try
		{
			reviewDao.deleteById(id);
			return true;
			
		}
		catch(NullPointerException ex)
		{
			System.out.println(ex.getMessage());
			return false;
		}

	}

	@Override
	public Collection<Review> searchAll() {
		
		return reviewDao.searchAll();
	}

	@Override
	public Collection<Review> searchByUserId(Long Id) {
		// TODO Auto-generated method stub
		return reviewDao.searchAllByUser(Id);
	}

	@Override
	public Review searchById(int Id) {
		
		return reviewDao.searchById(Id);
	}

}
