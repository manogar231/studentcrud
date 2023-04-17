package com.springlearn.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springlearn.entity.Student;
//import com.springlearn.handler.StudentHandler;
//import com.springlearn.repository.StudentRepository;
import com.springlearn.service.StudentService;

@RestController
public class StudentControl {
	
	@Autowired
     private  StudentService studentService; 
	
	@PostMapping("/save-student")
	 public ResponseEntity<Student> savestudents(@RequestBody Student student){
		 return  ResponseEntity.ok().body(studentService.savestudents(student));
	 }
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student>  updateStudent(Student student){
		return ResponseEntity.ok().body(studentService.updateStudent(student));
	}
	
	
	 @RequestMapping(value = "/allstudent", method = RequestMethod.GET)
	 public ResponseEntity<List<Student>> getallStudent(){ 
			return  ResponseEntity.ok().body(studentService.getallStudents());
	 }
	
	 
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> findstudentbyid(@PathVariable Integer id){
		
		return ResponseEntity.ok().body(studentService.findStudentById(id));
	}
	
	
    @GetMapping(value="/{name}")	
	 public Object findstudentbyname(@PathVariable String name){
		 return ResponseEntity.ok().body(studentService.findStudentByName(name));
	 } 
    
	
	@DeleteMapping("/delete/{id}")
	public Object deleteStudentById(@PathVariable (value = "id") Integer studentId) {
    
		studentService.deletestudent(studentId);
		return "Deleted sucessfully";
	}

}