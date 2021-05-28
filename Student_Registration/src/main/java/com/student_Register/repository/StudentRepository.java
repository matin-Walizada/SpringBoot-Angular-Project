package com.student_Register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student_Register.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
