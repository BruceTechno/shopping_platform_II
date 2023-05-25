package com.example.shopping_platform_II;

import static org.mockito.ArgumentMatchers.nullable;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.shopping_platform_II.repository.OrderDao;
import com.example.shopping_platform_II.repository.UserDao;
import com.example.shopping_platform_II.service.ifs.OrderService;
import com.example.shopping_platform_II.vo.AddOrderResponse;
import com.example.shopping_platform_II.vo.DeleteOrderResponse;

@SpringBootTest(classes =ShoppingPlatformIiApplication.class )
class OrderTest {
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	OrderService orderService;

	@Test
	public void addOrderTest() {
		Map<Integer, Integer> iteMap = new HashMap< >();
		iteMap.put(1, 1);
		iteMap.put(2, 1);
		iteMap.put(3, 1);
		
//		AddOrderResponse res = orderService.addOrder("123","123", iteMap, 0, 0);
		System.out.println();
	}
	
	@Test
	public void deleteOrderTest() {
//		DeleteOrderResponse res = orderService.deleteOrder("123", "123", 4123);
		System.out.println();
	}
	
	@Test
	public void updateOrderTest() {
		Map<Integer, Integer> iteMap = new HashMap< >();
		iteMap.put(1, 1);
		iteMap.put(2, 1);
		iteMap.put(3, 1);
		
//		orderService.updateOrder("123", "123", 4123, iteMap);

	}
	
	
	
	
	
	

}
