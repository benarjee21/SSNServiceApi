package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name="ssn_master")
public class SSNEntity {
	
	@Id
	@Column(name="ssn_number")
	@GenericGenerator(name = "custom_ssnId", strategy ="com.example.demo.utils.CustomSSNIdGenerator")
	@GeneratedValue(generator = "custom_ssnId")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ssnNumber;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="gender")
	private char gender;
	
	@Column(name="state_name")
	private String stateName;
	
	@Column(name="created_date",updatable=false)
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Column(name="updated_date",insertable=false)
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date updatedDate;

}
