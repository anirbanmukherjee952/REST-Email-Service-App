package com.demo.restemailerviceapp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Autowired: Spring Core Framework --> Dependency Injection (DI)

@RestController
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	private EmailContactRepo repo;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("/")
	public String getHomePage() {
		return "Welcome to REST Email Service!";
	}
	
	@PostMapping("/contact/registration")
	public String registerEmailContact(@Valid @ModelAttribute EmailContact theEmailContact,
									BindingResult theBindingResult) {
		System.out.println(">> EmailController: inside registerEmailContact()\n");
		
		try {
			if(theBindingResult.hasErrors()) {
				System.out.println(">> EmailController: theBindingResult.getErrors(): " + theBindingResult.getAllErrors());
				return "Failed: Error in input data!";
			}
			else
			{
				repo.save(theEmailContact);
				System.out.println(">> EmailController: inside registerEmailContact(): theEmailContact object saved in database");
				
				return "Succeeded: New Email contact registered!";
			}
		}
		catch(Exception e) {
			System.out.println(">> EmailController: Exception: " + e.getMessage());
			return "Failed: Exception occured!";
		}
	}
	
	@GetMapping("/contact/fetch/all")
	public List<EmailContact> fetchEmailContacts() {
		System.out.println(">> EmailController: inside registerEmailContact()\n");
		
		// add data to Model object
		List<EmailContact> emailContactList = repo.findAll();
		System.out.println(">> EmailController: inside registerEmailContact(): emailContactList retrieved\n");
		
		return emailContactList;
	}
	
	@PostMapping("/send")
	public String sendEmail(@Valid @ModelAttribute EmailMessage theEmail,
							BindingResult theBindingResult) {
		try {
			if(theBindingResult.hasErrors()) {
				System.out.println(">> EmailController: theBindingResult.getErrors(): " + theBindingResult.getAllErrors());
				return "Failed: Error in input data!";
			}
			else {
				// prepare the mail
				MimeMessage msg = mailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(msg, true);
				
				helper.setFrom(theEmail.getSender());
				
				helper.setTo(theEmail.getReceiver());
				
				helper.setSubject(theEmail.getSubject());
				
				helper.setText(theEmail.getBody());
				
				if(theEmail.getAttachment() != null) {
					// upload(writing in server) the attached file
					
					// where to write and write an empty file
					File attachedFile = new File("src/main/resources/uploaded-attachments/" + theEmail.getAttachment().getOriginalFilename());
					attachedFile.createNewFile();
					
					FileOutputStream fout = new FileOutputStream(attachedFile);
					fout.write(theEmail.getAttachment().getBytes());
					fout.close();
					
					helper.addAttachment(attachedFile.getName(), attachedFile);
				}
				
				// send the mail
				mailSender.send(msg);
				
				return "Succeeded: E-mail delivered!";
			}
		}
		catch(Exception e) {
			System.out.println(">> EmailController: Exception: " + e.getMessage());
			return "Failed: E-mail coudn't deliver!";
		}
	}
	
	@Scheduled(cron="0 15 10 * * ?")
	public void sendBirthdayWish() {
		
		String sender = "admin@host.domain";
		
		System.out.println(">> Inside sendBirthdayWish()::");
		
		// get current date
		LocalDate today = LocalDate.now();
		
		// fetch records from database
		List<EmailContact> contacts = repo.findAll();
		
		// search for any birthday
		for(EmailContact contact : contacts) {
			
			System.out.println(">> Contact: " + contact);
			
			// if found
			if(contact.getDateOfBirth().getMonth()==today.getMonth() 
					&& contact.getDateOfBirth().getDayOfMonth()==today.getDayOfMonth()) {
				
				// send birthday wish
				System.out.println(">> Matched contact found: " + contact);
				System.out.println(">> Sending Email message.");
				
				try {
					SimpleMailMessage msg = new SimpleMailMessage();
					msg.setFrom(sender);
					msg.setTo(contact.getEmailAddress());
					msg.setSubject("Happy Birthday");
					msg.setText("Wishing you a very happy birthday!");
					
					mailSender.send(msg);
				}
				catch(Exception e) {
					System.out.println(">> Error: " + e.getMessage());
				}
			}
				
		}
	}
}















