package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.iAccessExamEntity;
import com.example.demo.repository.iAccessExamRepository;
import com.example.demo.unique.iAccessExamUniqueEntity;

@Service
public class iAccessExamService {
	
	@Autowired
	iAccessExamRepository repo;
	
	public iAccessExamEntity addWhiteList(iAccessExamEntity whiteList) {
		return repo.save(whiteList);
	}
	
	public List<iAccessExamEntity> getAllWhiteList() {
		return repo.findAll();
	}
	
	public void deleteWhiteList(iAccessExamEntity id) {
		repo.delete(id);
		System.out.println("Successfully deleted ID: " + id);
	}

	public List<iAccessExamEntity> findAllByEnvironment(String environment) {
		return repo.findAllByEnvironment(environment);
	}

	public List<iAccessExamEntity> findAllByApplication(String application) {
		return repo.findAllByApplication(application);
	}
	
	public List<iAccessExamEntity> findAllByClientName(String clientName) {
		return repo.findAllByClientName(clientName);
	}

	public List<iAccessExamUniqueEntity> findAllUnique() {
		return repo.findAllUnique();
	}
	
	public List<iAccessExamUniqueEntity> findAllUniqueByEnvironment(String environment) {
		return repo.findAllUniqueByEnvironment(environment);
	}

	public List<iAccessExamUniqueEntity> findAllUniqueByApplication(String application) {
		return repo.findAllUniqueByApplication(application);
	}
	
	public List<iAccessExamUniqueEntity> findAllUniqueByClientName(String clientName) {
		return repo.findAllUniqueByClientName(clientName);
	}

}
