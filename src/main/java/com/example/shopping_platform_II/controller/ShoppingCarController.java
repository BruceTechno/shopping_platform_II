package com.example.shopping_platform_II.controller;

import com.example.shopping_platform_II.service.ifs.ShoppingCarService;
import com.example.shopping_platform_II.vo.AddCommodityToCarRequest;
import com.example.shopping_platform_II.vo.AddCommodityToCarResponse;
import com.example.shopping_platform_II.vo.DelCommodityFromCartRequest;
import com.example.shopping_platform_II.vo.DelCommodityFromCartResponse;
import com.example.shopping_platform_II.vo.GetShoppingCarResponse;
import com.example.shopping_platform_II.vo.UpdateInfoFromCartRequest;
import com.example.shopping_platform_II.vo.UpdateInfoFromCartResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@CrossOrigin
@RestController
public class ShoppingCarController {
    @Autowired
    private ShoppingCarService shoppingCarService;
    
    @PostMapping(value = "add_Commodity_ToCar")
	public AddCommodityToCarResponse addCommodityToCar(HttpSession httpSession,@RequestBody AddCommodityToCarRequest request) {
		return shoppingCarService.addCommodityToCar(httpSession, request);
		
	}
	
	@PostMapping(value = "dele_Commodity_FromCart")
	public DelCommodityFromCartResponse deleCommodityFromCart(HttpSession httpSession,@RequestBody DelCommodityFromCartRequest request) {
		return shoppingCarService.deleCommodityFromCart(httpSession, request);
		
	}
	
	@PostMapping(value = "update_InfoFromCar")
	public UpdateInfoFromCartResponse updateInfoFromCar(HttpSession httpSession,@RequestBody UpdateInfoFromCartRequest request) {
		return shoppingCarService.updateInfoFromCart(httpSession, request);
		
	}

    @GetMapping(value = "get_shopping_car_info")
    public GetShoppingCarResponse getShoppingCarInfo(HttpSession session){
        return shoppingCarService.getShoppingCarInfo(session);
    }
}
