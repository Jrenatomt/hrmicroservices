package com.renato.wrworker.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.renato.wrworker.dto.WorkerDTO;
import com.renato.wrworker.entities.Worker;
import com.renato.wrworker.repositories.WorkerRepository;
import com.renato.wrworker.services.exception.ResourceNotFoundException;

@Service
public class WorkerService {
	
	@Autowired
	private WorkerRepository repository;
	
	@Transactional(readOnly = true)
	public WorkerDTO findById(Long id) {
		Optional<Worker> obj = repository.findById(id);
		Worker entity = obj.orElseThrow(() -> new ResourceNotFoundException("Worker Not Found"));
		return new WorkerDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public List<WorkerDTO> findAll() {
		List<Worker> list = repository.findAll();
		return list.stream().map(x -> new WorkerDTO(x)).collect(Collectors.toList());
	}
	
	public WorkerDTO insert(WorkerDTO dto) {
		Worker obj = new Worker();
		obj.setName(dto.getName());
		obj.setDailyIncome(dto.getDailyIncome());
		obj = repository.save(obj);
		return new WorkerDTO(obj);
	}
}
