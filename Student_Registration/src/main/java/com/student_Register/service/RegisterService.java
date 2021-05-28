package com.student_Register.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_Register.model.Registeration;
import com.student_Register.repository.RegisterRepo;

@Service
public class RegisterService {
	
	
	// Dependency injection
	@Autowired
	RegisterRepo registerRepo;
	
	public Registeration saveUser(Registeration regis) {
		
		
		return registerRepo.save(regis);
	}
	
	public Registeration findUserByEmailId(String userEmail) {
		
		return registerRepo.findUserByEmail(userEmail);
	}
	
	
	public Registeration findUserByEmailAndPassword(String emailId, String password) {
		
		
		return registerRepo.findUserByEmailAndPassword(emailId, password);
	}

	 
	

}
