package com.example.java_demo_test.vo.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankUpdateRequest {

	private String account;

	@JsonProperty("old_Password")
	private String oldPwd;
	
	@JsonProperty("new_Password")
	private String newPwd;

	public BankUpdateRequest() {
		
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return oldPwd;
	}

	public void setPwd(String pwd) {
		this.oldPwd = pwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	
	
}
