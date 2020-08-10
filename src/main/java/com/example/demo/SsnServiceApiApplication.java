package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SsnServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsnServiceApiApplication.class, args);
		System.out.println("SSN Service Started");
	}

}
