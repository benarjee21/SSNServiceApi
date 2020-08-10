package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="states_master")
public class StatesEntity {
	
	@Id
	@Column(name="state_id")
	private Integer stateId;
	@Column(name="state_name")
	private String stateName;

}
