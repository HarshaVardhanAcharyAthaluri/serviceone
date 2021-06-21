package com.task.serviceone.service;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.task.serviceone.model.User;

@Service
public class GreetService {

	private static final Logger log = LoggerFactory.getLogger(GreetService.class);
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${serviceTwoUri}")
	private String serviceTwoUri;
	
	@Value("${serviceThreeUri}")
	private String serviceThreeUri;
	
	@Async
	public CompletableFuture<String> greetUser() {
		log.info("{}","servicetwoURI: "+serviceTwoUri);
		ResponseEntity<String> response =  restTemplate.getForEntity(serviceTwoUri, String.class);
		return CompletableFuture.completedFuture(response.getBody());
	}
	
	@Async
	public CompletableFuture<String> getUserInfo(User user) {
		log.info("{}","servicethreeURI: "+serviceThreeUri);
		String savedUser = restTemplate.postForObject(serviceThreeUri, user, String.class);
		return CompletableFuture.completedFuture(savedUser);
	}
}
