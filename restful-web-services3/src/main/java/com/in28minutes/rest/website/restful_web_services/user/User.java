package com.in28minutes.rest.website.restful_web_services.user;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

// HATEOAS를 사용하기위한 가장 선행되어야 할 과정은 EntityModel을 래핑하는 것
public class User {
	private Integer userId;
	@Size(min = 2, message = "이름 2글자 이상")
	// 직렬화를 하는 가장 유명한 라이브러리
	@JsonProperty("user_name")
	private String name;
	@Past(message = "생일 제대로")
	@NotNull(message = "널 안됨")
	@JsonProperty("birth_date")
	private LocalDate date;

	// 선택된 필드 필터링하기
	// 유저에는 비밀번호도 있기 때문에 응답같은 경우 동적 필터링, 정적 필터링이 있음.
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
