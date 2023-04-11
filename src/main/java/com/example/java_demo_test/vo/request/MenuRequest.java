package com.example.java_demo_test.vo.request;

import java.util.List;
import java.util.Map;

import com.example.java_demo_test.entity.Menu;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuRequest {

	@JsonProperty("menu_list")
	private List<Menu> menuList;

	@JsonProperty("menu_map")
	private Map<String, Integer> menuMap;
	
	private String food;

	private Integer price;

	private Integer quantity;

	public MenuRequest() {
		super();
	}

	public List<Menu> getorderList() {
		return menuList;
	}

	public void setorderList(List<Menu> orderList) {
		this.menuList = orderList;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Map<String, Integer> getOrderMap() {
		return menuMap;
	}

	public void setOrderMap(Map<String, Integer> orderMap) {
		this.menuMap = orderMap;
	}
	
	
}
