package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.iAccessExamEntity;
import com.example.demo.unique.iAccessExamUniqueEntity;

@Repository
public interface iAccessExamRepository extends JpaRepository<iAccessExamEntity, Long>{
	
	@Query(value = "SELECT * FROM whitelist w WHERE w.environment = ?", nativeQuery = true)
	List<iAccessExamEntity> findAllByEnvironment(String environment);
	
	@Query(value = "SELECT * FROM whitelist w WHERE w.application = ?", nativeQuery = true)
	List<iAccessExamEntity> findAllByApplication(String application);
	
	@Query(value = "SELECT * FROM whitelist w WHERE w.client_name = ?", nativeQuery = true)
	List<iAccessExamEntity> findAllByClientName(String clientName);

	@Query(value = "SELECT MAX(w.id) as id, MAX(w.client_name) as clientName, w.ip_address as ipAddress, "
			+ "MAX(w.environment) as environment, MAX(w.application) as application FROM whitelist w "
			+ "GROUP BY w.ip_address", nativeQuery = true)
	List<iAccessExamUniqueEntity> findAllUnique();
	
	@Query(value = "SELECT MAX(w.id) as id, MAX(w.client_name) as clientName, w.ip_address as ipAddress, "
			+ "MAX(w.environment) as environment, MAX(w.application) as application FROM whitelist w "
			+ "WHERE w.environment = ? GROUP BY w.ip_address", nativeQuery = true)
	List<iAccessExamUniqueEntity> findAllUniqueByEnvironment(String environment);
	
	@Query(value = "SELECT MAX(w.id) as id, MAX(w.client_name) as clientName, w.ip_address as ipAddress, "
			+ "MAX(w.environment) as environment, MAX(w.application) as application FROM whitelist w "
			+ "WHERE w.application = ? GROUP BY w.ip_address", nativeQuery = true)
	List<iAccessExamUniqueEntity> findAllUniqueByApplication(String application);
	
	@Query(value = "SELECT MAX(w.id) as id, MAX(w.client_name) as clientName, w.ip_address as ipAddress, "
			+ "MAX(w.environment) as environment, MAX(w.application) as application FROM whitelist w "
			+ "WHERE w.client_name = ? GROUP BY w.ip_address", nativeQuery = true)
	List<iAccessExamUniqueEntity> findAllUniqueByClientName(String clientName);

	iAccessExamEntity findById(long id);
	
	iAccessExamEntity findByClientName(String clientName);

}
