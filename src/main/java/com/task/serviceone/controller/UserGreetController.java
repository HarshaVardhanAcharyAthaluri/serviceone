package com.task.serviceone.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.serviceone.exception.UserGreetException;
import com.task.serviceone.model.User;
import com.task.serviceone.service.GreetService;

@RestController
public class UserGreetController {
	
	private static final Logger log = LoggerFactory.getLogger(UserGreetController.class);

	@Autowired
	private GreetService greetService;
	

	@PostMapping("/greet")
	public ResponseEntity<String> greet(@RequestBody User user) throws InterruptedException, ExecutionException {
		log.info("{}",user);
		CompletableFuture<String> completableUser = greetService.getUserInfo(user);
			CompletableFuture<String> greet =greetService.greetUser();
			String greetmsg = greet.get();
			if(completableUser.get()==null)
				throw new UserGreetException("user greet failed");
		return new ResponseEntity<String>(greetmsg+completableUser.get(),HttpStatus.OK);
	}
}
