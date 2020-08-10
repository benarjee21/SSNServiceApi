package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domains.SSNRegister;
import com.example.demo.services.SSNManageService;

@CrossOrigin(origins="*")
@RestController
public class SSNRegistrationController {
	
	@Autowired
	SSNManageService service;
	
	@PostMapping(value="/ssn-register")
	public ResponseEntity<String> register(@RequestBody SSNRegister register) {
		ResponseEntity<String> response= null;
		Long ssn = service.ssnRegister(register);
		String message = "You are successfully registered and your ssn number is "+ssn;
		response = new ResponseEntity<>(message,HttpStatus.CREATED);
		return response;
	}
	
	@GetMapping("/all-states")
	public List<String> getStates(){
		List<String> states=service.getAllStateNames();
		return states;
	}

}
