package com.example.shopping_platform_II.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.shopping_platform_II.service.ifs.ShoppingCarService;
import com.example.shopping_platform_II.vo.AddCommodityToCarRequest;
import com.example.shopping_platform_II.vo.AddCommodityToCarResponse;
import com.example.shopping_platform_II.vo.DelCommodityFromCartRequest;
import com.example.shopping_platform_II.vo.DelCommodityFromCartResponse;

@RestController
public class ShoppingCarController {
	
	@Autowired ShoppingCarService shoppingCarService;
	
	@PostMapping(value = "add_Commodity_ToCar")
	public AddCommodityToCarResponse addCommodityToCar(HttpSession httpSession,@RequestBody AddCommodityToCarRequest request) {
		return shoppingCarService.addCommodityToCar(httpSession, request);
		
	}
	
	@PostMapping(value = "dele_Commodity_FromCart")
	public DelCommodityFromCartResponse deleCommodityFromCart(HttpSession httpSession,@RequestBody DelCommodityFromCartRequest request) {
		return shoppingCarService.deleCommodityFromCart(httpSession, request);
		
	}
	

}
