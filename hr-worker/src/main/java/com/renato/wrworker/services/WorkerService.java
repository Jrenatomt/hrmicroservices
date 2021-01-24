package com.renato.wrworker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.renato.wrworker.entities.Worker;
import com.renato.wrworker.repositories.WorkerRepository;
import com.renato.wrworker.services.exception.ResourceNotFoundException;

@Service
public class WorkerService {
	
	@Autowired
	private WorkerRepository repository;
	
	@Transactional(readOnly = true)
	public Worker findById(Long id) {
		Optional<Worker> obj = repository.findById(id);
		Worker entity = obj.orElseThrow(() -> new ResourceNotFoundException("Worker Not Found"));
		return entity;
	}
	
	@Transactional(readOnly = true)
	public List<Worker> findAll() {
		List<Worker> list = repository.findAll();
		return list;
	}
	
	public Worker insert(Worker worker) {
		Worker obj = new Worker();
		obj.setName(worker.getName());
		obj.setDailyIncome(worker.getDailyIncome());
		obj = repository.save(obj);
		return obj;
	}
}
