package com.task.serviceone.model;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

@Component
public class User {
	
	@NotBlank(message = "name is manditory")
	private String name;
	@NotBlank(message = "surname is manditory")
	private String surName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
}
