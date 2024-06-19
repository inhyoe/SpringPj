package com.in28minutes.rest.website.restful_web_services.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

// @JsonFilter("SomeBeanFilter") // FilteringController에 에 있는 addFilter의 id와 같아야함
@JsonFilter("SomeBeanFilter")
public class SomeBeanWithDynamicFiltering {

	private String field1;
	private String field2;
	private String field3;

	public SomeBeanWithDynamicFiltering(String field1, String field2, String field3) {
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}
}
