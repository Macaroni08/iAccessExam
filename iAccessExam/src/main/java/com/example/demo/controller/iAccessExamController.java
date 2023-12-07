package com.example.demo.controller;

import java.util.List;

import org.apache.commons.validator.routines.InetAddressValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.iAccessExamFilterRequestNotFoundException;
import com.example.demo.common.iAccessExamInvalidArgumentException;
import com.example.demo.entity.iAccessExamEntity;
import com.example.demo.repository.iAccessExamRepository;
import com.example.demo.service.iAccessExamService;
import com.example.demo.unique.iAccessExamUniqueEntity;

@RestController
public class iAccessExamController {
	
	@Autowired
	iAccessExamService service;
	
	@Autowired
	iAccessExamRepository repo;
	
	@PostMapping(value = "/whitelists")
	public iAccessExamEntity addWhiteList(@RequestBody iAccessExamEntity whiteList) {
		InetAddressValidator validator = InetAddressValidator.getInstance();
		if(validator.isValidInet4Address(whiteList.getIpAddress()))
			return service.addWhiteList(whiteList);
		else
			throw new iAccessExamInvalidArgumentException("Oops... Invalid IPv4 Address! "
					+ "Please make sure it is an IPv4 Address");
	}
	
	@GetMapping(value = "/whitelists")
	public List<iAccessExamEntity> getAllWhiteList(){
		return service.getAllWhiteList();
	}
	
	@DeleteMapping(value = "/whitelists")
	public void deleteWhiteList(@RequestBody iAccessExamEntity id) {
		long clientId = id.getId();
		iAccessExamEntity entity = repo.findById(clientId);
		if(entity!=null)
			service.deleteWhiteList(id);
		else
			throw new iAccessExamFilterRequestNotFoundException("Oops... User not found with ID: " + id);
	}
	
	@GetMapping(value = "/whitelists/environment/{environment}")
	public List<iAccessExamEntity> findAllByEnvironment(@PathVariable("environment") String environment){
		List<iAccessExamEntity> entity = repo.findAllByEnvironment(environment);
		if(entity.isEmpty())
			throw new iAccessExamFilterRequestNotFoundException("Oops... Environment value: '" + environment + "' "
					+ "is invalid. Please choose between DEV, PROD, or STAGE");
		else
			return service.findAllByEnvironment(environment);
	}
	
	@GetMapping(value = "/whitelists/application/{application}")
	public List<iAccessExamEntity> findAllByApplication(@PathVariable("application") String application){
		List<iAccessExamEntity> entity = repo.findAllByApplication(application);
		if(entity.isEmpty())
			throw new iAccessExamFilterRequestNotFoundException("Oops... Application value: '" + application + "' "
					+ "is invalid. Please choose between app1 or app2");
		else
			return service.findAllByApplication(application);
	}
	
	@GetMapping(value = "/whitelists/clientName/{clientName}")
	public List<iAccessExamEntity> findAllByClientName(@PathVariable("clientName") String clientName){
		List<iAccessExamEntity> entity = repo.findAllByClientName(clientName);
		if(entity.isEmpty())
			throw new iAccessExamFilterRequestNotFoundException("Oops... Client name: '" + clientName + "' "
					+ "is not found. Please try other name");
		else
			return service.findAllByClientName(clientName);
			
	}

	@GetMapping(value = "/whitelists/unique")
	public List<iAccessExamUniqueEntity> findAllUniqueByApplication(){
		return service.findAllUnique();
	}
	
	@GetMapping(value = "/whitelists/unique/environment/{environment}")
	public List<iAccessExamUniqueEntity> findAllUniqueByEnvironment(@PathVariable("environment") String environment){
		List<iAccessExamUniqueEntity> entity = repo.findAllUniqueByEnvironment(environment);
		if(entity.isEmpty())
			throw new iAccessExamFilterRequestNotFoundException("Oops... Environment value: '" + environment + "' "
					+ "is invalid. Please choose between DEV, PROD, or STAGE");
		else
			return service.findAllUniqueByEnvironment(environment);
	}
	
	@GetMapping(value = "/whitelists/unique/application/{application}")
	public List<iAccessExamUniqueEntity> findAllUniqueByApplication(@PathVariable("application") String application){
		List<iAccessExamUniqueEntity> entity = repo.findAllUniqueByApplication(application);
		if(entity.isEmpty())
			throw new iAccessExamFilterRequestNotFoundException("Oops... Application value: '" + application + "' "
					+ "is invalid. Please choose between app1 or app2");
		else
			return service.findAllUniqueByApplication(application);
	}
	
	@GetMapping(value = "/whitelists/unique/clientName/{clientName}")
	public List<iAccessExamUniqueEntity> findAllByUniqueClientName(@PathVariable("clientName") String clientName){
		List<iAccessExamUniqueEntity> entity = repo.findAllUniqueByClientName(clientName);
		if(entity.isEmpty())
			throw new iAccessExamFilterRequestNotFoundException("Oops... Client name: '" + clientName + "' "
					+ "is not found. Please try other name");
		else
			return service.findAllUniqueByClientName(clientName);
			
	}

}
