package com.demo.restemailerviceapp.controller;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailContactRepo extends JpaRepository<EmailContact, String> {
	
}
