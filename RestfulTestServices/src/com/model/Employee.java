package com.model;

import java.io.Serializable;

import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Long empId;
	private String fullName;
	private String designation;

	public Employee(){
	}

	public Employee(Long empId, String fullName, String designation) {
		super();
		this.empId = empId;
		this.fullName = fullName;
		this.designation = designation;
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
