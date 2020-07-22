package com.demo.restemailerviceapp.controller;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

// POJO representing Email Contact entity
// @Entity, @Id: for Hibernate ORM (Object Relational Mapping)
// @Entity: This class is an entity, meaning there exist table with same name as EmailContact (actually email_contact)
// @Id: the attribute is primary key of the entity

@Entity
public class EmailContact {
	
	@Id 
	private int id;
	
	@NotNull
	private String name;
	
	@NotNull
	@Email
	private String emailAddress;
	
	@NotNull
	@Past
	@DateTimeFormat(pattern="YYYY-MM-DD")
	private LocalDate dateOfBirth;
	
	public EmailContact() {
		System.out.println(">> EmailContact: invoked no-arg constructor\n");
	}

	public int getId() {
		System.out.println(">> EmailContact: invoked getId()\n");
		return id;
	}
	public void setId(int id) {
		System.out.println(">> EmailContact: invoked setId()\n");
		this.id = id;
	}
	public String getName() {
		System.out.println(">> EmailContact: invoked getName()\n");
		return name;
	}
	public void setName(String name) {
		System.out.println(">> EmailContact: invoked setName()\n");
		this.name = name;
	}
	public String getEmailAddress() {
		System.out.println(">> EmailContact: invoked getEmailAddress()\n");
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		System.out.println(">> EmailContact: invoked setEmailAddress()\n");
		this.emailAddress = emailAddress;
	}
	public LocalDate getDateOfBirth() {
		System.out.println(">> EmailContact: invoked getDateOfBirth()\n");
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		System.out.println(">> EmailContact: invoked setDateOfBirth()\n");
		this.dateOfBirth = LocalDate.parse(dateOfBirth);
	}
	@Override
	public String toString() {
		return "EmailContact [name=" + name + ", emailAddress=" + emailAddress + ", dateOfBirth="
				+ dateOfBirth + "]";
	}
}
