package com.devsuperior.bds03.resources;


import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.bds03.services.EmployeeService;


@RestController
public class EmployeeResource {

	
	private EmployeeService employeeService;
	
	EmployeeResource(EmployeeService employeeService){
		
		this.employeeService = employeeService;
	}
	
	
}
