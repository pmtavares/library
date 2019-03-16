package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.library.domain.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
		
	public final static String findByUserId = "select u from Users u where u.id =:id";
	@Query(findByUserId)
	Users searchById(@Param("id") Long id);


}
