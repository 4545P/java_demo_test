package com.example.java_demo_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.service.ifs.ActiveService;
import com.example.java_demo_test.service.ifs.BankService;
import com.example.java_demo_test.service.ifs.MenuService;
import com.example.java_demo_test.vo.request.BankRequest;

@SpringBootTest(classes = JavaDemoTestApplication.class)
public class JavaDemoTestApplicationTests {

	@Autowired
	private ActiveService active;

	@Autowired
	private BankService bankService;

	@Autowired
	private MenuService orderService;

//	@Test
//	public void contextLoads() {
//		Bird bird = new Bird("Lili", 15);
//		active.fiy(bird.getName(), bird.getAge());
//	}
//
//	@Test
//	public void bankServiceTest() {
//		Bank bank = new Bank("4", 500);
//		BankRequest bankRequest = new BankRequest();
//		bankService.getAmount(bankRequest);
//		bankService.deposit(bank, 500);
//		bankService.withdraw(bank, 2000);
//	}

//	@Test
//	public void orderServiceTest() {
//		Scanner count = new Scanner(System.in);
//		System.out.println("輸入 1 繼續點餐 0結束點餐");
//		int count1 = count.nextInt();
//		while (true) {
//			if (count1 == 1) {
//				Scanner scan = new Scanner(System.in);
//				System.out.println("輸入餐點");
//				String menu = scan.next();
//				System.out.println("輸入數量");
//				int quantity = scan.nextInt();
//				orderService.order(menu, quantity);
//				System.out.println("輸入 1 繼續點餐 0結束點餐");
//				 count1 = count.nextInt();
//			} else {
//				System.out.println("結束點餐");
//				break;
//			}
//		}
//	}

}