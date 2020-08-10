package com.example.demo.domains;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SSNRegister {
	
	private Long ssnNumber;
	private String firstName;
	private String lastName;
	private Date dob;
	private char gender;
	private String stateName;
	private Date createdDate;
	private Date updatedDate;


}
