package com.demo.restemailerviceapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

// Autowired: Spring Core Framework --> Dependency Injection (DI)

@Controller
public class EmailController {
	
	@Autowired
	private EmailContactRepo repo;
	
	@GetMapping("/")
	public String getHomePage() {
		return "home.jsp";
	}
	
	@PostMapping("/insertEmailContact")
	public String registerEmailContact(@ModelAttribute("newEmailContact") EmailContact theEmailContact) {
		repo.save(theEmailContact);
		return "registration-success.jsp";
	}
	
	@GetMapping("/fetchEmailContactList")
	public String fetchEmailContacts(Model theModel) {
		// add data to Model object
		List<EmailContact> emailContactList = repo.findAll();
		theModel.addAttribute("fetchedEmailContacts", emailContactList);
		
		return "my-email-contacts.jsp";
	}
	
	@PostMapping("/sendEmail")
	public String sendEmail(@ModelAttribute("sentEmail") Email theEmail) {
		return "email-sent-success.jsp";
	}
}
