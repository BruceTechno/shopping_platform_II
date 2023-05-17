package com.example.shopping_platform_II;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.shopping_platform_II.repository.OrderDao;
import com.example.shopping_platform_II.service.ifs.OrderService;

@SpringBootTest(classes =ShoppingPlatformIiApplication.class )
class orderTest {
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	OrderService orderService;

	@Test
	void addOrderTest() {
		Map<Integer, Integer> iteMap = new HashMap< >();
		iteMap.put(1, 1);
		iteMap.put(2, 1);
		iteMap.put(3, 1);
		
//		orderService.addOrder("123","123", iteMap, 0, 0);
		System.out.println();
	}

}
