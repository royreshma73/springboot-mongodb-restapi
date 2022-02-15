package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.SequenceGenerator;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="/api")
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	private SequenceGenerator service;
	
	//get all students
	@GetMapping(value="/allStudents")
	public List<Student> getAllStudents(Student student) {
	 	
		return studentRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
	    	  
	  }
	
	//insert student
	@PostMapping(value="/addStudent")
	public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
		try {
			   //generate roll number
			    int s = service.getSequenceNumber(student.SEQUENCE_NAME);
			    String rollno = "R-00" + s;
			    student.setRollNo(rollno);
			    Student _student = studentRepository.insert(student);
			    return new ResponseEntity<>(_student, HttpStatus.CREATED);
		  } catch (Exception e) {
			  return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	}
}
