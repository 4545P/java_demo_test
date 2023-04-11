package com.example.java_demo_test.service.ifs;

import java.util.List;

import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.vo.request.PersonInfoRequest;
import com.example.java_demo_test.vo.response.PersonInfoResponse;

public interface PersonInfoService {

	// 新增資訊多
	public PersonInfoResponse addPersonInfo(PersonInfoRequest personInfoRequest);

	// 取得所有個人資訊
	public List<PersonInfo> getPersonInfo();

	// 透過id取得資訊
	public PersonInfoResponse getPersonInfoById(PersonInfoRequest personInfoRequest);

	// 找出年紀大於輸入條件的所有資訊
	public List<PersonInfo> findByAgeLargerThanEqual(int age);

	// 找出年紀小於輸入條件的所有資訊
	public List<PersonInfo> findByAgeLessThanEqual(int age);

	// 透過city找出大於輸入條件的所有資訊
	public List<PersonInfo> findByCityAndAgeLargerThanEqual(String city, int age);

	// 透過city取的資訊 模糊搜尋
	public List<PersonInfo> findByCityContaining(String city);

	// 找出前兩筆資料
	public List<PersonInfo> findTop2ByCityContaining(String city);

	public List<PersonInfo> findFirst2ByCityContaining(String city);

	// 找出min到max之間的資訊
	public List<PersonInfo> findByAgeBetween(int min, int max);

	// 找出小於min或大於max的資訊
	public List<PersonInfo> findByAgeLessThanOrAgeGreaterThan(int min, int max);

	// 找出小於min或大於max或城市是city的資訊
	public List<PersonInfo> findByAgeLessThanOrAgeGreaterThanOrCityContaining(int min, int max, String city);
	
	//遞增排序
	public List<PersonInfo> findByCityContainingOrderByAgeAsc(String city);

	//遞減排序
	public List<PersonInfo> findByCityContainingOrderByAgeDesc(String city);

	//預設排序是遞增
	public List<PersonInfo> findByCityContainingOrderByAge(String city);

}
