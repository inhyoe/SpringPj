package com.in28minutes.rest.website.restful_web_services.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// @JsonIgnoreProperties({"field1", "field2"})
// 이 방법보다는 JsonIgnore 방법을 권장함 필드 이름을 바꿨을 경우 똑같이 바꿔야 하기 때문에
public class SomeBean {

	//정적 필터링
	@JsonIgnore
	private String field1;
	@JsonIgnore
	private String field2;
	private String field3;

	public SomeBean(String field1, String field2, String field3) {
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
