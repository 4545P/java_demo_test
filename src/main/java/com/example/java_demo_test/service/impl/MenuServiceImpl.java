package com.example.java_demo_test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.java_demo_test.entity.Menu;
import com.example.java_demo_test.repository.MenuDao;
import com.example.java_demo_test.service.ifs.MenuService;
import com.example.java_demo_test.vo.request.MenuRequest;
import com.example.java_demo_test.vo.response.MenuResponse;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao;

	@Transactional
	@Override
	public MenuResponse addMenu(MenuRequest menuRequest) {
		List<Menu> menuList = menuRequest.getorderList();
		List<Menu> errorList = new ArrayList<>();

		// List為零或null進入 if
		if (CollectionUtils.isEmpty(menuList)) {
			throw new IllegalArgumentException("Order list cannot be empty");
		}

		//字串為零進入if
		for (Menu menu : menuList) {
			if (menu.getFood().isBlank() || String.valueOf(menu.getPrice()).isBlank() || menu.getPrice() <= 0) {
				errorList.add(menu);
			}
			Optional<Menu> existingMenu = menuDao.findById(menu.getFood());
			if (existingMenu.isPresent()) {
				errorList.add(menu);
			}
		}

		// 字串為零進入if
		if (!errorList.isEmpty()) {
			return new MenuResponse(errorList, "餐點重複或價格錯誤：");
		}
		// orderDao.saveAll(menuList);
		return new MenuResponse(menuList, "新增餐點成功！");
	}

	@Transactional
	@Override
	public List<Menu> getAllMenus() {
		return menuDao.findAll();
	}

	@Transactional
	@Override
	public MenuResponse getMenu(MenuRequest menuRequest) {
		Optional<Menu> op = menuDao.findById(menuRequest.getFood());
		if (!op.isPresent()) {
			return new MenuResponse(menuRequest.getFood(), "餐點錯誤");
		}
		Menu order = op.get();
		return new MenuResponse(order.getFood(), order.getPrice());
	}

	@Transactional
	@Override
	public MenuResponse order(MenuRequest menuRequest) {
		// 從資料庫中讀取所有餐點價格
		Map<String, Integer> menuPriceMap = menuDao.findAll().stream()
				.collect(Collectors.toMap(Menu::getFood, Menu::getPrice));

		Map<String, Integer> orderMenu = menuRequest.getOrderMap();
		int originalTotalPrice = orderMenu.entrySet().stream().mapToInt(item -> {
			String menuItem = item.getKey();
			int quantity = item.getValue();

			// 如果餐點不存在於資料庫中，則回傳 -1
			int price = menuPriceMap.getOrDefault(menuItem, -1);
			if (price == -1) {
				throw new IllegalArgumentException("餐點不存在：" + menuItem);
			}

			return price * quantity;
		}).sum();

		// 計算打折後的價格
		double discountedPrice = originalTotalPrice * 0.9;
		return originalTotalPrice >= 500 ? new MenuResponse(orderMenu, originalTotalPrice, discountedPrice)
				: new MenuResponse(orderMenu, originalTotalPrice);
	}
}
