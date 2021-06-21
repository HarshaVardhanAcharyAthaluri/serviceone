package com.task.serviceone.model;

import org.springframework.stereotype.Component;

@Component
public class User {

	private String name;
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
