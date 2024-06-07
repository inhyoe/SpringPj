package com.in28minutes.rest.website.restful_web_services.user;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {
	private Integer userId;
	@Size(min = 2, message = "이름 2글자 이상")
	private String name;
	@Past(message = "생일 제대로")
	@NotNull(message = "널 안됨")
	private LocalDate date;

	public User(Integer userId, String name, LocalDate date) {
		this.userId = userId;
		this.name = name;
		this.date = date;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void add(User user) {
		++userId;
	}
}
