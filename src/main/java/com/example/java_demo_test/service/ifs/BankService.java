package com.example.java_demo_test.service.ifs;

import com.example.java_demo_test.vo.request.BankRequest;
import com.example.java_demo_test.vo.request.BankUpdateRequest;
import com.example.java_demo_test.vo.response.BankResponse;

public interface BankService {
	
	//新增帳號
	public BankResponse addAccount(BankRequest bankRequest);

	// 取得餘額
	public BankResponse getAmount(BankRequest bankRequest);

	// 存款
	public BankResponse deposit(BankRequest bankRequest);

	// 提款
	public BankResponse withdraw(BankRequest bankRequest);

	//修改密碼
	public BankResponse update(BankUpdateRequest bankUpdateRequest);
	
}
