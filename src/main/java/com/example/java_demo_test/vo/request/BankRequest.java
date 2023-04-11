package com.example.java_demo_test.vo.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankRequest {

	private String account;

	@JsonProperty("password")
	private String pwd;
	
	private int  amount;

	public BankRequest() {

	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
