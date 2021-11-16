package com.devsuperior.bds03.services;


import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds03.dto.EmployeeDTO;
import com.devsuperior.bds03.entities.Department;
import com.devsuperior.bds03.entities.Employee;
import com.devsuperior.bds03.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository repository;

	
	
	EmployeeService(EmployeeRepository repository){
		this.repository = repository;
	}

	
	@Transactional(readOnly = true)
	public Page<EmployeeDTO> findAll(Pageable pegeable){
		Page<Employee> page = repository.findAll(pegeable);
		
		return page.map(x -> new EmployeeDTO(x));
	}


	@Transactional
	public EmployeeDTO insert(EmployeeDTO dto) {
		Employee entity = new Employee();
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setDepartment(new Department(dto.getDepartmentId(), null));
		
		entity = repository.save(entity);
		return new EmployeeDTO(entity);
	}
}
