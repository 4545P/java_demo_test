package com.example.java_demo_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.repository.PersonInfoDao;

@SpringBootTest(classes = JavaDemoTestApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS) //用於@BeforeAll And @AfterAll
public class PersonInfoTest {

	private List<PersonInfo> list = new ArrayList<>();
	
	@Autowired
	private PersonInfoDao personInfoDao;

	@Test
	public void findByAgeGreaterThanTest() {
		// test findByAgeGreaterThanEqual
		List<PersonInfo> result = personInfoDao.findByAgeGreaterThanEqual(70);
		// 驗證結果是否正確
		Assert.isTrue(result.size() == 3, "測試結果錯誤");
		// 刪除新增的假資料(Optional)
		personInfoDao.deleteAll(list);
	}

	
	@BeforeEach // 通常用在測試假資料  每個程式碼開始前執行
	public void beforeEachTest() {
		System.out.println("BeforeEachTest=====");
	}

	@AfterEach // 用來刪除BeforeEach的資料  每個程式碼結束後執行
	public void afterEachTest() {
		System.out.println("AfterEach===========");
	}
	
	@BeforeAll  // 所有程式碼開始前執行
	public void beforeAll() {
		PersonInfo personInfo1 = new PersonInfo("testA", "testB", 70, "桃園");
		PersonInfo personInfo2 = new PersonInfo("testB", "testB", 72, "桃園");
		PersonInfo personInfo3 = new PersonInfo("testC", "testB", 74, "桃園");
		list = Arrays.asList(personInfo1, personInfo2, personInfo3);
		personInfoDao.saveAll(list);
	}
	
	@AfterAll  //所有程式碼結束後執行
	public void afterAll() {
		personInfoDao.deleteAll(list);
	}
}