package com.controller.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dao.HibernateUtils;
import com.model.Employee;

@Path("/award")
public class AwardServices {

	public final static List<Employee> listEmployee= new ArrayList<>();
	static{
		Employee emp = new Employee(1L, "Sahil Bansal", "Sr. Software Eng.");
		Employee emp1 = new Employee(2L, "Monica Rani", "Sr. Software Eng.");
		Employee emp2 = new Employee(3L, "Sandeep Sharma", "Sr. Software Eng.");
		listEmployee.add(emp);
		listEmployee.add(emp1);
		listEmployee.add(emp2);
		HibernateUtils.getSessionFactory();
	}
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getAward(){
		return Response.ok().entity("By default Service called").build();
	}

	@GET
	@Path("/serachEmployee")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployee(@QueryParam("empId") Long empId) {
		Employee emp = listEmployee.stream()
				.filter(empt -> empt.getEmpId() == empId).findAny().orElse(null);

		return Response.ok().entity(emp).build();
	}

	@POST
	@Path("/addhEmployee")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEmployee(@FormParam("empId") Long empId,
			@FormParam("fullName") String fullName, @FormParam("designation") String designation) {
		listEmployee.add(new Employee(empId, fullName, designation));
		return Response.ok().entity(listEmployee.get(listEmployee.size()-1)).build();
	}

	@POST
	@Path("/addhEmployeeTest")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEmployee(Employee emp) {
		listEmployee.add(emp);
		return Response.ok().entity(listEmployee.get(listEmployee.size()-1)).build();
	}

	@GET
	@Path("/employee")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEmployee(){
		GenericEntity<List<Employee>> genericList = new GenericEntity<List<Employee>>(listEmployee){};
		return Response.ok().entity(genericList).build();
	}

	@GET
	@Path("/employeexml")
	@Produces(MediaType.APPLICATION_XML)
	public Response getAllEmployeeXML(){
		GenericEntity<List<Employee>> genericList = new GenericEntity<List<Employee>>(listEmployee){};
		return Response.ok().entity(genericList).build();
	}

	@GET
	@Path("/employee1")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseList getAllEmployees(){

		ResponseList emps=new ResponseList();
		return emps;
	}

}
