package com.colbyleed.beltexam.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.colbyleed.beltexam.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
	
//	CUSTOM QUERY TO FIND USER BY EMAIL
	Optional<User> findByEmail(String email);
}
