package com.example.java_demo_test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank")
public class Bank {

	// @Column : 指定DB中哪個欄位的值 賦予到 Entity Bank 的 account 此屬性
	// name = "account" : "account" 是資料庫 bank 的 account這個欄位

	@Id // 表示主鍵
	@Column(name = "account")
	public String account;

	@Column(name = "pwd")
	public String pwd;

	@Column(name = "amount")
	public int amount;

	public Bank() {
		super();
	}

	public Bank(String account, String pwd) {
		this.account = account;
		this.pwd = pwd;
	}

	public Bank(String account, String pwd, int amount) {
		this.account = account;
		this.pwd = pwd;
		this.amount = amount;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
