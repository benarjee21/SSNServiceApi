package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.SSNManageService;

@CrossOrigin(origins="*")
@RestController
public class SSNValidationController {
	
	@Autowired
	SSNManageService service;
	
	@GetMapping("/validate/{ssn}/{state}")
	public ResponseEntity<String> validate(@PathVariable String ssn,@PathVariable String state){
		ResponseEntity<String> response= null;
		String result = service.ssnCheck(Long.parseLong(ssn), state);
		response = new ResponseEntity<>(result,HttpStatus.OK);
		return response;
	}
	
}
