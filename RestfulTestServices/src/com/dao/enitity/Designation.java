package com.dao.enitity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name ="designation")
public class Designation implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "desg_id")
	private long designationId;
	@Column(name = "desg_name")
	private String designationName;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Employee emp;



	public Designation(long designationId, String designationName, Employee emp) {
		super();
		this.designationId = designationId;
		this.designationName = designationName;
		this.emp = emp;
	}

	public long getDesignationId() {
		return designationId;
	}
	public void setDesignationId(long designationId) {
		this.designationId = designationId;
	}
	public String getDesignationName() {
		return designationName;
	}
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}

}
