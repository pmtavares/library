package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.library.domain.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long>{
	public final static String findByBookId = "select b from Book b where b.id =:id";
	@Query(findByBookId)
	Book searchById(@Param("id") Long id);

}
