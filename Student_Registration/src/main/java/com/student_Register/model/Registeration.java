package com.student_Register.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
// mapped our class to the table 


//@Data
//@AllArgsConstructor
//@NoArgsConstructor

@Entity(name = "registeration")
public class Registeration {
	// mapped our fields to our table columns
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "email" )
	private String email;
	
	@Column(name = "user_name")
	private String username;
	
	@Column(name = "password")
	private String password;

	// create constructor
	public Registeration(Long id, String email, String username, String password) {
		
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	

	// no arg constructor
	
	 public Registeration() {
		 
	}

	// create getters and setters
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	

	
	
	 
	
	

}
