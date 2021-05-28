package com.student_Register.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.access.EjbAccessException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student_Register.model.Registeration;
import com.student_Register.repository.RegisterRepo;
import com.student_Register.service.RegisterService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/all")
public class RegisterController {

	// Injected the RegisterService;
	@Autowired
	RegisterService registerService;

	@Autowired
	RegisterRepo registerRepo;

	@PostMapping("/register")
	public Registeration registerUser(@RequestBody Registeration regis) throws Exception {

		String userEmail = regis.getEmail();

		if (userEmail != null && !"".equals(userEmail)) {

			Registeration userOject = registerService.findUserByEmailId(userEmail);
			if (userOject != null) {
				throw new Exception("user with " + userEmail + " is already exist");
			}

		}

		Registeration theUser = null;
		theUser = registerService.saveUser(regis);

		return theUser;

	}

	@PostMapping("/login")
	public Registeration logInUser(@RequestBody Registeration logusr) throws Exception {

		String userEmail = logusr.getEmail();
		String userPassword = logusr.getPassword();
		Registeration userObjec = null;

		if (userEmail != null && userPassword != null) {
			userObjec = registerService.findUserByEmailAndPassword(userEmail, userPassword);

		}

		if (userObjec == null) {
			throw new Exception("Bad Credential");
		}

		return userObjec;
	}

	@GetMapping("/users")
	public List<Registeration> getAllRegisterdPersons() {

		return registerRepo.findAll();
	}

}
