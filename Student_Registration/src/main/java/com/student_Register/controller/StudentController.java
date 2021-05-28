package com.student_Register.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student_Register.exception.StudentNotFoundException;
import com.student_Register.model.Student;
import com.student_Register.repository.StudentRepository;

@RestController
@RequestMapping("/students/v1")
public class StudentController {

	// do dependency injection
	@Autowired
	StudentRepository studentRepository;

	// write get student api

	@GetMapping("/students")
	public List<Student> getStudents() {

		return studentRepository.findAll();
	}

	// write post api

	@PostMapping("/students")
	public Student saveStudent(@RequestBody Student student) {

		return studentRepository.save(student);
	}

	// write update student api

	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id, @RequestBody Student studentDetails) {

		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student not exist with id " + id));

		student.setFirstName(studentDetails.getFirstName());
		student.setLastName(studentDetails.getLastName());
		student.setEmail(studentDetails.getEmail());

		Student updateStudent = studentRepository.save(student);

		return ResponseEntity.ok(student);

	}

	// develope the delete api

	@DeleteMapping("/students/{id}")

	public ResponseEntity<Map<String, Long>> deleteStudent(@PathVariable("id") Long id) {

		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student not exist with id " + id));

		studentRepository.delete(student);

		Map<String, Long> response = new HashMap<String, Long>();

		response.put("student Deleted with ID ", id);

		return ResponseEntity.ok(response);

	}

}
