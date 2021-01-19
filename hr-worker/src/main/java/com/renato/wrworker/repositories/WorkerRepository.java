package com.renato.wrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renato.wrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
