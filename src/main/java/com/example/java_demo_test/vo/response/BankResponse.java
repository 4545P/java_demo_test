package com.example.java_demo_test.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;

//null 不顯示出來
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankResponse {

	private String account;
	
	private String pwd;

	private Integer amount; // 金額

	private Integer balance; // 餘額

	private String message;

	public BankResponse() {

	}

	public BankResponse(String account, String pwd) {
		this.account = account;
		this.pwd = pwd;
	}

	public BankResponse(String account, Integer amount, String message) {
		this.account = account;
		this.amount = amount;
		this.message = message;
	}

	public BankResponse(String account, Integer amount, Integer balance, String message) {
		this.account = account;
		this.amount = amount;
		this.balance = balance;
		this.message = message;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
