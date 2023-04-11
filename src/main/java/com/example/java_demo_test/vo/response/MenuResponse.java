package com.example.java_demo_test.vo.response;

import java.util.List;
import java.util.Map;

import com.example.java_demo_test.entity.Menu;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuResponse {

	@JsonProperty("menu_list")
	private List<Menu> menuList;

	@JsonProperty("menu_map")
	private Map<String, Integer> menuMap;

	private String food;

	private Integer price;

	private Integer originalTotalprice;

	private Double discountPrice;

	private String message;

	public MenuResponse(List<Menu> menuList, String message) {
		this.menuList = menuList;
		this.message = message;
	}

	public MenuResponse(String message) {
		this.message = message;
	}

	public MenuResponse(String food, Integer price) {
		this.food = food;
		this.price = price;
	}

	public MenuResponse(String food, String message) {
		this.food = food;
		this.message = message;
	}
	
	

	public MenuResponse(Map<String, Integer> menuMap, Integer originalTotalprice, Double discountPrice) {
		super();
		this.menuMap = menuMap;
		this.originalTotalprice = originalTotalprice;
		this.discountPrice = discountPrice;
	}

	public MenuResponse(Map<String, Integer> orderMenu, Integer origonalTotalPrice) {
		this.menuMap = orderMenu;
		this.originalTotalprice = originalTotalprice;
	}

	public List<Menu> getOrderList() {
		return menuList;
	}

	public void setOrderList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public Map<String, Integer> getMenuMap() {
		return menuMap;
	}

	public void setMenuMap(Map<String, Integer> menuMap) {
		this.menuMap = menuMap;
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

	public Integer getOriginalTotalprice() {
		return originalTotalprice;
	}

	public void setOriginalTotalprice(Integer originalTotalprice) {
		this.originalTotalprice = originalTotalprice;
	}

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
