package com.example.shopping_platform_II;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.shopping_platform_II.entity.Commodity;
import com.example.shopping_platform_II.repository.CommodityDao;
import com.example.shopping_platform_II.service.ifs.CommodityService;
import com.example.shopping_platform_II.vo.CommodityResponse;
import com.example.shopping_platform_II.vo.addCommodityResponse;

@SpringBootTest(classes = ShoppingPlatformIiApplicationTests.class)

public class shoppingPlatformTest {
	
	
	@Autowired
	private CommodityDao commodityDao;
	
	@Autowired
	private CommodityService commodityService;

	
	@Test
	public void listingProducts() {
		
		Commodity goods = new Commodity(1244, "xperia6", "smartphone", 50, 3500, "pan");

		
	
//		list.add(goods);
		
//		CommodityResponse res = commodityService.listingProducts(list);
		
		// íºê⁄égópDaoéwóﬂè„ôB
		commodityDao.save(goods);
		
	}
	
	@Test
	public void noSoldProducts() {
		
		int number = 1244;
		
		commodityDao.deleteById(number);
	}

}
