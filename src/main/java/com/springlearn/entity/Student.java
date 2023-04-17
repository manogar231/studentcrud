package com.springlearn.entity;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//its POJO class 

@Entity
@Table(name="students")
public class Student {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
     @Column(name="Name")
	private String name;
     @Column(name="Dept")
	private String dept;
     
	public Student(int id,String name,String dept) {
		
		this.id=id;
		this.name=name;
		this.dept=dept;
		
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", dept=" + dept + "]";
	}
	
     
   
}
