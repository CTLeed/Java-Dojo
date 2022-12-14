package com.colbyleed.userdemo.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colbyleed.userdemo.models.User;
import com.colbyleed.userdemo.repositories.UserRepository;

@Service
public class UserService {
//	IMPORT REPOSITORY
	@Autowired
	UserRepository userRepo;
	
//	CREATE A USER
	public User create(User newUser) {
		return userRepo.save(newUser);
	}
	
//	GET ALL USERS
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
//	GET ONE USER
	public User findUser(Long id) {
		return userRepo.findById(id).orElse(null);
	}
	
//	UPDATE A USER
	public User updateUser(@Valid User updatedUser) {
		return userRepo.save(updatedUser);
	}
	
//	DELETE A USER
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}
}
