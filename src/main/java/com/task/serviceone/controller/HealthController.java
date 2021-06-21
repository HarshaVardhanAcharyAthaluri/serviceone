package com.task.serviceone.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.serviceone.model.Status;
import com.task.serviceone.service.HealthService;

@RestController
public class HealthController {

	private static final Logger log = LoggerFactory.getLogger(HealthController.class);
	
	@Autowired
	private HealthService healthService;
	
	@GetMapping("/health")
	public Status healthCheck(){
		log.info("{}","HealthCheck");
		return healthService.isServiceUp();
	}
	
}
