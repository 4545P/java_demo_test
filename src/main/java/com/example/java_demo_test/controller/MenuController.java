package com.example.java_demo_test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_demo_test.entity.Menu;
import com.example.java_demo_test.service.ifs.MenuService;
import com.example.java_demo_test.vo.request.MenuRequest;
import com.example.java_demo_test.vo.response.MenuResponse;

@RestController
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@PostMapping("/add_menu")
	public MenuResponse addMenu(@RequestBody MenuRequest menuRequest) {
		return menuService.addMenu(menuRequest);
	}
	
	@PostMapping("/get_all_Menu")
	public List<Menu> getAllMenu() {
		return menuService.getAllMenus();
	}

	@PostMapping("/get_menu_Byid")
	public MenuResponse getMenu(@RequestBody MenuRequest menuRequest) {
		return menuService.getMenu(menuRequest);
	}
	
	@PostMapping("/order_menu")
	public MenuResponse Order(@RequestBody MenuRequest menuRequest) {
		return menuService.order(menuRequest);
	}
}
