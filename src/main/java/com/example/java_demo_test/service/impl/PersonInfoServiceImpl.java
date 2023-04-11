package com.example.java_demo_test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.repository.PersonInfoDao;
import com.example.java_demo_test.service.ifs.PersonInfoService;
import com.example.java_demo_test.vo.request.PersonInfoRequest;
import com.example.java_demo_test.vo.response.PersonInfoResponse;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {

	@Autowired
	private PersonInfoDao personInfoDao;

	@Transactional
	@Override
	public PersonInfoResponse addPersonInfo(PersonInfoRequest personInfoRequest) {
		// 檢查多筆PersonInfo
		List<PersonInfo> infoList = personInfoRequest.getPersonInfoList();
		// 將錯誤資料新增到List
		List<PersonInfo> errorInfoList = new ArrayList<>();
		// 新增多筆PersonInfo
		for (PersonInfo item : infoList) {
			// 檢查單筆PersonInfo(item)
			if (!StringUtils.hasText(item.getId()) || !StringUtils.hasText(item.getName())) {
				errorInfoList.add(item);
			}
			Optional<PersonInfo> existing = personInfoDao.findById(item.getId());
			if (existing.isPresent()) {
				errorInfoList.add(item);
			}
		}
		// 檢查 errorInfoList 是否為空
		if (!errorInfoList.isEmpty()) {
			return new PersonInfoResponse(errorInfoList, "ID為空或重複");
		}

		// 新增多筆PersonInfo
		personInfoDao.saveAll(infoList);
		return new PersonInfoResponse(infoList, "新增成功");
	}

	@Transactional
	@Override
	public List<PersonInfo> getPersonInfo() {
		return personInfoDao.findAll();
	}

	@Transactional
	@Override
	public PersonInfoResponse getPersonInfoById(PersonInfoRequest personInfoRequest) {
		Optional<PersonInfo> op = personInfoDao.findById(personInfoRequest.getId());
		if (!op.isPresent()) {
			return new PersonInfoResponse(personInfoRequest.getId(), "ID錯誤");
		}
		PersonInfo personInfo = op.get();
		return new PersonInfoResponse(personInfo.getId(), personInfo.getName(), personInfo.getAge());
	}

	@Transactional
	@Override
	public List<PersonInfo> findByAgeLargerThanEqual(int age) {
		return personInfoDao.findByAgeGreaterThanEqual(age);
	}

	@Transactional
	@Override
	public List<PersonInfo> findByAgeLessThanEqual(int age) {
		return personInfoDao.findByAgeLessThanEqual(age);
	}

	@Transactional
	@Override
	public List<PersonInfo> findByCityAndAgeLargerThanEqual(String city, int age) {
		return personInfoDao.findByCityAndAgeGreaterThanEqual(city, age);
	}

	@Transactional
	@Override
	public List<PersonInfo> findByCityContaining(String city) {
		return personInfoDao.findByCityContaining(city);
	}

	@Transactional
	@Override
	public List<PersonInfo> findTop2ByCityContaining(String city) {
		return personInfoDao.findTop2ByCityContaining(city);
	}

	@Transactional
	@Override
	public List<PersonInfo> findFirst2ByCityContaining(String city) {
		return personInfoDao.findFirst2ByCityContaining(city);
	}

	@Transactional
	@Override
	public List<PersonInfo> findByAgeBetween(int min, int max) {
		return personInfoDao.findByAgeBetween(min, max);
	}

	@Transactional
	@Override
	public List<PersonInfo> findByAgeLessThanOrAgeGreaterThan(int min, int max) {
		return personInfoDao.findByAgeLessThanOrAgeGreaterThan(min, max);
	}

	@Transactional
	@Override
	public List<PersonInfo> findByAgeLessThanOrAgeGreaterThanOrCityContaining(int min, int max, String city) {
		return personInfoDao.findByAgeLessThanOrAgeGreaterThanOrCityContaining(min, max, city);
	}

	@Transactional
	@Override
	public List<PersonInfo> findByCityContainingOrderByAgeAsc(String city) {
		return personInfoDao.findByCityContainingOrderByAgeAsc(city);
	}

	@Transactional
	@Override
	public List<PersonInfo> findByCityContainingOrderByAgeDesc(String city) {
		return personInfoDao.findByCityContainingOrderByAgeDesc(city);
	}

	@Transactional
	@Override
	public List<PersonInfo> findByCityContainingOrderByAge(String city) {
		return personInfoDao.findByCityContainingOrderByAge(city);
	}
}
