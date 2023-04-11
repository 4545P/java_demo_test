package com.example.java_demo_test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {

	@Id // 表示主鍵
	@Column(name = "food")
	private String food;

	@Column(name = "price")
	private int price;

	public Menu() {
		super();

	}

	public Menu(String food, int price) {
		super();
		this.food = food;
		this.price = price;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
