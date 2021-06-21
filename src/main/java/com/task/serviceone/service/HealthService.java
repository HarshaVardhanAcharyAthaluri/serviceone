package com.task.serviceone.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.serviceone.model.Status;


@Service
public class HealthService {

	private static final Logger log = LoggerFactory.getLogger(HealthService.class);
	
	@Autowired
	private Status status;
	
	public Status isServiceUp() {
		log.info("{}",status);
		status.setStatus("up");
		return status;
	}
}
