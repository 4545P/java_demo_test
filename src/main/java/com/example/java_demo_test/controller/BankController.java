package com.example.java_demo_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_demo_test.service.ifs.BankService;
import com.example.java_demo_test.vo.request.BankRequest;
import com.example.java_demo_test.vo.request.BankUpdateRequest;
import com.example.java_demo_test.vo.response.BankResponse;

@RestController
public class BankController {

	@Autowired
	private BankService bankService;

	@PostMapping("/add_account")
	public BankResponse addAccount(@RequestBody BankRequest bankRequest) {
		return bankService.addAccount(bankRequest);
	}
	
//	@RequestMapping(value = "/get_amount", method = RequestMethod.POST)
	@PostMapping("/get_amount")
	public BankResponse gatAmount(@RequestBody BankRequest bankRequest) {
		return bankService.getAmount(bankRequest);
	}

	@PostMapping("/deposit_amount")
	public BankResponse depositAmount(@RequestBody BankRequest bankRequest) {
		return bankService.deposit(bankRequest);
	}

	@PostMapping("/withdraw_amount")
	public BankResponse withdrawAmount(@RequestBody BankRequest bankRequest) {
		return bankService.withdraw(bankRequest);
	}
	
	@PostMapping("/update_password")
	public BankResponse updatePassword(@RequestBody BankUpdateRequest bankUpdateRequest) {
		return bankService.update(bankUpdateRequest);
	}
}
