package com.colbyleed.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.colbyleed.bookclub.models.LoginUser;
import com.colbyleed.bookclub.models.User;
import com.colbyleed.bookclub.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User register(User newUser, BindingResult results) {		
		
//		CHECK TO SEE IF PASSWORD AND CONFIRM DOES NOT MATCH
		if(this.checkEmail(newUser.getEmail())) {
			results.rejectValue("email", "Email-taken", "Email is already in use");
		}
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			results.rejectValue("confirm", "Confirm", "Password and Confirm Pass must match");
		}
		if(results.hasErrors()) {
			return null;
		}
//		HASH AND SET PASSWORD, SAVE USER TO DB
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepo.save(newUser);
	}
	
	public User login(LoginUser newLoginObject, BindingResult results) {
		
		
//		FIND THE USER IN THE DB
		if(!this.checkEmail(newLoginObject.getEmail())) {
			results.rejectValue("email", "Non-existant", "INVALID CREDENTIALS");
		}
		if(results.hasErrors()) {
			return null;
		}
		
//		CHECK IF PASSWORD MATCHES THE ONE IN THE DB
		User user = userRepo.findByEmail(newLoginObject.getEmail()).orElse(null);
		if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
			results.rejectValue("password", "Matches", "Invalid Password!");
		}
		if(results.hasErrors()) {
			return null;
		}
		
		return user;
	}
	
	public boolean checkEmail(String email) {
		Optional<User> user = userRepo.findByEmail(email);
		
		if(user.isPresent()) {
			return true;
		} else {
			return false;
		}
		
	}
	
//	READ ONE
	public User getOneUser(Long userId) {
		return userRepo.findById(userId).orElse(null);
	}
	
//	READ ALL
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
//	UPDATE
	public User updateUser(User updatedUser) {
		return userRepo.save(updatedUser);
	}
	
//	DELETE
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}
	
	
}
