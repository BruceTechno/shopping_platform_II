package com.example.shopping_platform_II.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping_platform_II.service.ifs.CommodityService;
import com.example.shopping_platform_II.vo.addCommodityRequest;
import com.example.shopping_platform_II.vo.addCommodityResponse;

@RestController
public class commodityController {
	
	@Autowired
	private CommodityService commodityService;
	
	
	public addCommodityResponse listingProducts(@RequestBody addCommodityRequest request) {
		
		// ‰ñœärequest
		return commodityService.listingProducts(request.getReqCommodity());
	}

}
