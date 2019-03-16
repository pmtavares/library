package com.library.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.library.domain.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
	
	public final static String findByAuthorId = "select a from Author a where a.id =:id";
	@Query(findByAuthorId)
	Author searchById(@Param("id") Long id);
	
	public final static String findById = "select a from Author a where a.id =:id";
	@Query(findById)
	Optional<Author> findById(@Param("id") Long id);
	

}
