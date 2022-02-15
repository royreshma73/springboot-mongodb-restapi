package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Students")
public class Student {

	private String id;
	@NotBlank(message = "Name is mandatory")
	@NotNull
	private String name;
	@NotBlank(message = "className is mandatory")
	@NotNull
	private String className;
	@NotBlank(message = "division is mandatory")
	@NotNull
	private char division;
	@NotBlank(message = "Gender is mandatory")
	@NotNull
	private String gender;
	
	public Student() {
		super();
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClass(String className) {
		this.className = className;
	}

	public char getDivision() {
		return division;
	}

	public void setDivision(char division) {
		this.division = division;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Student(String name, String className, char division, String gender) {
		super();
		this.name = name;
		this.className = className;
		this.division = division;
		this.gender = gender;
	}
	
}
