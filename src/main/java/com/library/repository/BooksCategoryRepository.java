package com.library.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.library.domain.Author;
import com.library.domain.BooksCategory;

@Repository
public interface BooksCategoryRepository extends JpaRepository<BooksCategory, Integer> {
	
	public final static String findBooksCategoryById = "select bc from BooksCategory bc where bc.id =:id";
	@Query(findBooksCategoryById)
	BooksCategory searchById(@Param("id") int id);
	
	
	public final static String findById = "select bc from BooksCategory bc where bc.id =:id";
	@Query(findById)
	Optional<Author> findById(@Param("id") int id);

}
