package com.example.java_demo_test.service.ifs;


import java.util.List;

import com.example.java_demo_test.entity.Menu;
import com.example.java_demo_test.vo.request.MenuRequest;
import com.example.java_demo_test.vo.response.MenuResponse;

public interface MenuService {

	// 新增單筆或多筆餐點
	public MenuResponse addMenu(MenuRequest orderRequest);

	// 取得所有品項與價格
	public List<Menu> getAllMenus();

	// 取得單一品項的價格
	public MenuResponse getMenu(MenuRequest orderRequest);

	// 點餐單筆或多筆
	public MenuResponse order(MenuRequest orderRequest);
}
