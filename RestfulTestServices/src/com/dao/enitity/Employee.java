package com.dao.enitity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name ="emp_id")
	private Long empId;
	@Column(name ="emp_name")
	private String fullName;

	@OneToOne(mappedBy= "emp")
	@JoinColumn(name ="emp_desg_id")
	private Designation designation;

	@ManyToOne
	@JoinColumn(name = "emp_manager_id")
	private Employee manager;

	@OneToMany(mappedBy ="manager")
	private Set<Employee> subordinates = new HashSet<>();

	public Employee(){
	}

	public Employee(Long empId, String fullName, Designation designation,
			Employee manager, Set<Employee> subordinates) {
		super();
		this.empId = empId;
		this.fullName = fullName;
		this.designation = designation;
		this.manager = manager;
		this.subordinates = subordinates;
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

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Set<Employee> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(Set<Employee> subordinates) {
		this.subordinates = subordinates;
	}

}
