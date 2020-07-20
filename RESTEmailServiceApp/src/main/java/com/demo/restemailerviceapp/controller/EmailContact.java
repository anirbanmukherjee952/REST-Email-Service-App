package com.demo.restemailerviceapp.controller;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

// POJO representing Email Contact entity
// Entity, Id: for Hibernate ORM (Object Relational Mapping)

@Entity
public class EmailContact {
	
	@Id 
	private String id;
	private String name;
	private String emailAddress;
	private String dateOfBirth;

	public EmailContact() {
		id = UUID.randomUUID().toString(); // UUID: Universally Unique ID
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
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "EmailContact [name=" + name + ", emailAddress=" + emailAddress + ", dateOfBirth="
				+ dateOfBirth + "]";
	}
}
