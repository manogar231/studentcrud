package com.springlearn.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.springlearn.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	 
	
	Optional<Student> findStudentById(int id);
	
	Optional<Student> findStudentByName(String name);
	
	
}

