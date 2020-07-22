package com.demo.restemailerviceapp.controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartFile;

public class EmailMessage {
	@NotNull
	@Email
	private String sender;
	
	@NotNull
	@Email
	private String receiver;
	
	@NotNull
	private String subject;
	
	@NotNull
	private String body;
	
	private MultipartFile attachment;
	
	public EmailMessage() {
		System.out.println(">> EmailMessage: invoked no-arg constructor\n");
	}
	
	public String getSender() {
		System.out.println(">> EmailMessage: invoked getSender()\n");
		return sender;
	}
	public void setSender(String sender) {
		System.out.println(">> EmailMessage: invoked setSender()\n");
		this.sender = sender;
	}
	public String getReceiver() {
		System.out.println(">> EmailMessage: invoked getReceiver()\n");
		return receiver;
	}
	public void setReceiver(String receiver) {
		System.out.println(">> EmailMessage: invoked setReceiver()\n");
		this.receiver = receiver;
	}
	public String getSubject() {
		System.out.println(">> EmailMessage: invoked getSubject()\n");
		return subject;
	}
	public void setSubject(String subject) {
		System.out.println(">> EmailMessage: invoked setSubject()\n");
		this.subject = subject;
	}
	public String getBody() {
		System.out.println(">> EmailMessage: invoked getBody()\n");
		return body;
	}
	public void setBody(String body) {
		System.out.println(">> EmailMessage: invoked setBody()\n");
		this.body = body;
	}
	public MultipartFile getAttachment() {
		System.out.println(">> EmailMessage: invoked getAttachment()\n");
		return attachment;
	}
	public void setAttachment(MultipartFile attachment) {
		System.out.println(">> EmailMessage: invoked setAttachment()\n");
		this.attachment = attachment;
	}
}
