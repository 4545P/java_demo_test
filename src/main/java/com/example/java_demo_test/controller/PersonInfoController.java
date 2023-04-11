package com.example.java_demo_test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.service.ifs.PersonInfoService;
import com.example.java_demo_test.vo.request.PersonInfoRequest;
import com.example.java_demo_test.vo.response.PersonInfoResponse;

@RestController
public class PersonInfoController {

	@Autowired
	private PersonInfoService personInfoService;

	@PostMapping("/add_person_Info")
	public PersonInfoResponse addPersonInfo(@RequestBody PersonInfoRequest personInfoRequest) {
		return personInfoService.addPersonInfo(personInfoRequest);
	}

	@PostMapping("/get_person_Info")
	public List<PersonInfo> getPersonInfo() {
		return personInfoService.getPersonInfo();
	}

	@PostMapping("/get_person_Byid")
	public PersonInfoResponse getPersonInfoById(@RequestBody PersonInfoRequest personInfoRequest) {
		return personInfoService.getPersonInfoById(personInfoRequest);
	}

	@PostMapping("/get_age_Larger")
	public List<PersonInfo> findByAgeLargerThanEqual(@RequestBody PersonInfoRequest personInfoRequest) {
		return personInfoService.findByAgeLargerThanEqual(personInfoRequest.getAge());
	}

	@PostMapping("/get_age_Less")
	public List<PersonInfo> findByAgeLessThanEqual(@RequestBody PersonInfoRequest personInfoRequest) {
		return personInfoService.findByAgeLessThanEqual(personInfoRequest.getAge());
	}

	@PostMapping("/get_city_Age")
	public List<PersonInfo> findByCityAndAgeLargerThanEqual(@RequestBody PersonInfoRequest personInfoRequest) {
		return personInfoService.findByCityAndAgeLargerThanEqual(personInfoRequest.getCity(),
				personInfoRequest.getAge());
	}

	@PostMapping("/get_city_Containing")
	public List<PersonInfo> findByCityContaining(@RequestBody PersonInfoRequest personInfoRequest) {
		return personInfoService.findByCityContaining(personInfoRequest.getCity());
	}

	@PostMapping("/get_city_Top2")
	public List<PersonInfo> findTop2ByCityContaining(@RequestBody PersonInfoRequest personInfoRequest) {
		return personInfoService.findTop2ByCityContaining(personInfoRequest.getCity());
	}

	@PostMapping("/get_city_First2")
	public List<PersonInfo> findFirst2ByCityContaining(@RequestBody PersonInfoRequest personInfoRequest) {
		return personInfoService.findFirst2ByCityContaining(personInfoRequest.getCity());
	}

	@PostMapping("/get_age_Between")
	public List<PersonInfo> findByBetween(@RequestBody PersonInfoRequest personInfoRequest) {
		return personInfoService.findByAgeBetween(personInfoRequest.getMin(), personInfoRequest.getMax());
	}

	@PostMapping("/get_age_Min_Or_Max")
	public List<PersonInfo> findByAgeLessThanOrAgeGreaterThan(@RequestBody PersonInfoRequest personInfoRequest) {
		return personInfoService.findByAgeLessThanOrAgeGreaterThan(personInfoRequest.getMin(),
				personInfoRequest.getMax());
	}

	@PostMapping("/get_age_Min_Max_Or_city")
	public List<PersonInfo> findByAgeLessThanOrAgeGreaterThanOrCityContaining(
			@RequestBody PersonInfoRequest personInfoRequest) {
		return personInfoService.findByAgeLessThanOrAgeGreaterThanOrCityContaining(personInfoRequest.getMin(),
				personInfoRequest.getMax(), personInfoRequest.getCity());
	}

	@PostMapping("/get_city_Asc")
	public List<PersonInfo> findByCityContainingOrderByAgeAsc(@RequestBody PersonInfoRequest personInfoRequest) {
		return personInfoService.findByCityContainingOrderByAgeAsc(personInfoRequest.getCity());
	}

	@PostMapping("/get_city_Desc")
	public List<PersonInfo> findByCityContainingOrderByAgeDesc(@RequestBody PersonInfoRequest personInfoRequest) {
		return personInfoService.findByCityContainingOrderByAgeDesc(personInfoRequest.getCity());
	}

	@PostMapping("/get_city_Order")
	public List<PersonInfo> findByCityContainingOrderByAge(@RequestBody PersonInfoRequest personInfoRequest) {
		return personInfoService.findByCityContainingOrderByAge(personInfoRequest.getCity());
	}
}
