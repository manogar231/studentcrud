package com.springlearn.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlearn.entity.Student;
import com.springlearn.handler.StudentHandler;
import com.springlearn.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository StudentRepository;
	
	
	//SAVE STUDENT
	public  Student savestudents(Student student) {
		
	   Student students =new Student();
		
		students.setName(student.getName());
		students.setDept(student.getDept());
		return StudentRepository.save(students);
		
	}
	 //GET ALL STUDENT 
	public List<Student>getallStudents(){
		return this.StudentRepository.findAll();
	}
	  //FIND  STUDENT BY ID
	 public Student findStudentById(int id){
		 Optional<Student> student =StudentRepository.findStudentById(id);
		 
		 if(student.isEmpty()) {
			throw new StudentHandler();
		 }
	   Student student2 = student.get();
		 return student2;
		
	 }
	 //FIND STUDENT BY NAME
	 public Student findStudentByName(String name) {
		 
	 Optional<Student> student=StudentRepository.findStudentByName(name);
	if (student.isPresent()) {
		 Student studentname= student.get();
		 return studentname; 
	}
		 throw new StudentHandler();
	 }
	 //DELETE STUDENT
	 public String deletestudent(Integer id) {
		
		 StudentRepository.deleteById(id);
		 
		 return "Deleted The Student";
	 }
	 
    //UPDATING STUDENT DET.
	 public Student updateStudent(Student student) {
		 
       Optional<Student>update= StudentRepository.findStudentById(student.getId());	
       
       if (update.isPresent()) {
        
    	   Student student1=update.get();
    	   student1.setDept(student.getDept());
    	   student1.setName(student.getName());
          return StudentRepository.save(student1);
	}
		 throw new StudentHandler();
	 }
	 
}
