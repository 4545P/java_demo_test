package com.example.java_demo_test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java_demo_test.entity.PersonInfo;

@Repository
public interface PersonInfoDao extends JpaRepository<PersonInfo, String> {

	List<PersonInfo> findByAgeGreaterThanEqual(int age);

	List<PersonInfo> findByAgeLessThanEqual(int age);

	List<PersonInfo> findByCityAndAgeGreaterThanEqual(String city, int age);

	List<PersonInfo> findByCityContaining(String city);
	
	List<PersonInfo> findTop2ByCityContaining(String city);
	
	List<PersonInfo> findFirst2ByCityContaining(String city);

	List<PersonInfo> findByAgeBetween(int min, int max);

	List<PersonInfo> findByAgeLessThanOrAgeGreaterThan(int min, int max);

	List<PersonInfo> findByAgeLessThanOrAgeGreaterThanOrCityContaining(int min, int max, String city);
	
	List<PersonInfo> findByCityContainingOrderByAgeAsc(String city);
	
	List<PersonInfo> findByCityContainingOrderByAgeDesc(String city);

	List<PersonInfo> findByCityContainingOrderByAge(String city);

}
