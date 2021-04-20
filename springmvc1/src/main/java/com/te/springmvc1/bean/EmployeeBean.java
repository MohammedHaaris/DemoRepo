package com.te.springmvc1.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="employee_info")
public class EmployeeBean implements Serializable {
	@Id
	
	private Integer id;
	
	@Column
	private String name;
	
	@Column(name="DOB")
	private Date dob;
	
	@Column(name="Password")
	private String password;

}
