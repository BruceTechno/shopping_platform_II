package com.example.shopping_platform_II;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.shopping_platform_II.entity.ShoppingCar;
import com.example.shopping_platform_II.repository.ShoppingCarDao;
import com.example.shopping_platform_II.service.ifs.ShoppingCarService;

@SpringBootTest
class ShoppingPlatformIiApplicationTests {
	
	@Autowired 
	private ShoppingCarDao shoppingCarDao;
	
	@Autowired 
	ShoppingCarService shoppingCarService;

	@Test
	public void addCommodityToCarTest() {
		
		
		
	}

}
