	package com.colbyleed.userdemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.colbyleed.userdemo.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
//	GET ALL METHOD
	List<User> findAll();
	
//	CUSTOM QUERIES
}
