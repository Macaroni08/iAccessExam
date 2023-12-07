package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "whitelist")
public class iAccessExamEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false)
	private String clientName;
	
	@Column(nullable=false)
	private String ipAddress;
	
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private Environment environment;
	
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private Application application;
	
	iAccessExamEntity(){
		
	}
	
	iAccessExamEntity(long id, String clientName, String ipAddress, Environment environment, Application application){
		this.id = id;
		this.clientName = clientName;
		this.ipAddress = ipAddress;
		this.environment = environment;
		this.application = application;
	}
	
	public enum Application {
		app1,
		app2
	}
	
	public enum Environment {
		DEV,
		STAGE,
		PROD
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
		}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}
	
}
