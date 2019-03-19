package com.library.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.library.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
	
	public final static String findById = "select r from Review r where r.id =:id";
	@Query(findById)
	Review searchById(@Param("id") int id);
	
	public final static String findByUserId = "select r from Review r where r.user.id =:id";
	@Query(findByUserId)
	Review searchByUserId(@Param("id") Long id);
	
	public final static String findAllByUserId = "select r from Review r where r.user.id =:id";
	@Query(findAllByUserId)
	Collection<Review> searchAllByUser(@Param("id") Long id);


}
