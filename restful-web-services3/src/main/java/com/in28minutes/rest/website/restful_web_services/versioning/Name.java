package com.in28minutes.rest.website.restful_web_services.versioning;

public class Name {
	private String firstName;
	private String lastName;

	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "PersonV2{" +
			"firstName='" + firstName + '\'' +
			", lastName='" + lastName + '\'' +
			'}';
	}
}
