package com.example.shopping_platform_II;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.shopping_platform_II.repository.OrderDao;

@SpringBootTest(classes =ShoppingPlatformIiApplication.class )
class orderTest {
	
	@Autowired
	OrderDao orderDao;

	@Test
	void addOrderTest() {
		
		int x = orderDao.addOrderWhereNotExists(00001, "13456", "123465", 0, 0, 0);
		System.out.println();
	}

}
