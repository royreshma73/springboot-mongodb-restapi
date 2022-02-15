package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.util.Date;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Students")
public class Student {

	private String id;
	@NotBlank(message = "Name is mandatory")
	@NotNull
	private String name;
	@NotBlank(message = "Classname is mandatory")
	@NotNull
	private String className;
	@NotBlank(message = "Division is mandatory")
	@NotNull
	private char division;
	@NotBlank(message = "Gender is mandatory")
	@NotNull
	private String gender;
	private Date dateOfBirth;
	
	public Student() {
		super();
	}

	
	
}
