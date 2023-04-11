package com.example.java_demo_test.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.java_demo_test.service.ifs.ActiveService;

@Service
public class ActiveImpl implements ActiveService {

	@Transactional
	@Override
	public void fiy(String name, int age) {
		System.out.println(name + " " + age);	
	}
	
}
