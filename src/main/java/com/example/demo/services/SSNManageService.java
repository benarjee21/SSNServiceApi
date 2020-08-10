package com.example.demo.services;

import java.util.List;

import com.example.demo.domains.SSNRegister;

public interface SSNManageService {
	
	public List<String> getAllStateNames();
	public Long ssnRegister(SSNRegister register);
	public String ssnCheck(Long ssn,String stateName);

}
