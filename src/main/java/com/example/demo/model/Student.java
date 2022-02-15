package com.example.demo.model;

import java.util.Date;
import org.springframework.data.annotation.Transient;
import java.lang.Character;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Students")
public class Student {
	
	
	public Student(String rollNo,
			@Valid @NotBlank(message = "Name is mandatory") @NotNull String name,
			@Valid @NotBlank(message = "className is mandatory") @NotNull String className,
			@Valid @NotBlank(message = "Date of birth is mandatory") @NotNull Date dateOfBirth,
			@Valid @NotNull(message = "division is mandatory") @NotNull Character division,
			@Valid @NotBlank(message = "Gender is mandatory") @NotNull String gender) {
		super();
		
		this.name = name;
		this.className = className;
		this.dateOfBirth = dateOfBirth;
		this.division = division;
		this.gender = gender;
	}
	@Transient
	public static final String SEQUENCE_NAME = "student_seq";
	
	@Id
	private String id;
	
	private String rollNo;
	@Valid
	@NotBlank(message = "Name is mandatory")
	@NotNull
	private String name;
	@Valid
	@NotBlank(message = "className is mandatory")
	@NotNull
	private String className;
	@Valid
	@NotNull(message = "Date of birth is mandatory")
	
	private Date dateOfBirth;
	@Valid
	@NotNull(message = "division is mandatory")
	
	private Character division;
	@Valid
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

	public void setClassName(String className) {
		this.className = className;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Character getDivision() {
		return division;
	}

	public void setDivision(Character division) {
		this.division = division;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}


	
}
