package com.example.demo.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domains.SSNRegister;
import com.example.demo.entities.SSNEntity;
import com.example.demo.repositories.SSNEntityRepo;
import com.example.demo.repositories.StatesRepo;

@Service
public class SSNManageServiceImpl implements SSNManageService {
	
	@Autowired
	SSNEntityRepo ssnRepo;
	@Autowired
	StatesRepo statesRepo;

	@Override
	public List<String> getAllStateNames() {
		return statesRepo.findAllStateNames();
	}

	@Override
	public Long ssnRegister(SSNRegister register) {
		SSNEntity ssnEntity = new SSNEntity();
		BeanUtils.copyProperties(register, ssnEntity);
		SSNEntity ssnEntitySaved = ssnRepo.save(ssnEntity);
		if(ssnEntitySaved != null) {
			return ssnEntitySaved.getSsnNumber();
		}
		return null;
	}

	@Override
	public String ssnCheck(Long ssn, String stateName) {
		SSNEntity ssnEntity =ssnRepo.findBySsnNumberAndStateName(ssn, stateName);
		if(ssnEntity != null) {
			return "VALID";
		}
		return "IN-VALID";
	}

}
