package com.devsuperior.bds03.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devsuperior.bds03.dto.DepartmentDTO;
import com.devsuperior.bds03.entities.Department;
import com.devsuperior.bds03.repositories.DepartmentRepository;

import java.util.stream.Collectors;

@Service
public class DepartmentService {

	private DepartmentRepository repository;

	
	DepartmentService(DepartmentRepository repository){
		this.repository = repository;
	}
	
	
	public List<DepartmentDTO> findAll(){
		List<Department> list = repository.findAll();
		
		/* 
		List<DepartmentDTO> listDTO = new ArrayList<>();
		for(Department x : list ) {
			DepartmentDTO dto = new DepartmentDTO(x);
			listDTO.add(dto);
		}
		return listDTO;*/
		
		return list.stream().map(x -> new DepartmentDTO(x)).collect(Collectors.toList());
	}
	
}
