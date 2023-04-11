package com.example.java_demo_test.vo.response;

import java.util.List;

import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.vo.request.PersonInfoRequest;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonInfoResponse extends PersonInfoRequest {

	@JsonProperty("person_info_list")
	private List<PersonInfo> personInfoList;

	private String message;

	public PersonInfoResponse(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public PersonInfoResponse(List<PersonInfo> personInfoList, String message) {
		super();
		this.personInfoList = personInfoList;
		this.message = message;
	}

	public PersonInfoResponse(String message) {
		super();
		this.message = message;
	}

	public PersonInfoResponse(String id, String message) {
		super();
		this.id = id;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<PersonInfo> getPersonInfoList() {
		return personInfoList;
	}

	public void setPersonInfoList(List<PersonInfo> personInfoList) {
		this.personInfoList = personInfoList;
	}

}
