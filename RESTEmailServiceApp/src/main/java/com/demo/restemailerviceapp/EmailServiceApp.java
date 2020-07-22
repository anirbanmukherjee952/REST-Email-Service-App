package com.demo.restemailerviceapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EmailServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApp.class, args);
	}

}
