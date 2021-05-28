package com.student_Register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.student_Register.model.Registeration;

@Component
public interface RegisterRepo extends JpaRepository<Registeration, Long> {

	public Registeration findUserByEmail(String userEmail);
	public Registeration findUserByEmailAndPassword(String emailId, String password);

}
