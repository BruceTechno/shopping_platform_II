package com.example.shopping_platform_II.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping_platform_II.service.ifs.CommodityService;
import com.example.shopping_platform_II.vo.CommodityResponse;
import com.example.shopping_platform_II.vo.addCommodityRequest;
import com.example.shopping_platform_II.vo.addCommodityResponse;
import com.example.shopping_platform_II.vo.deleteCommodityRequest;
import com.example.shopping_platform_II.vo.deleteCommodityResponse;

@RestController
public class commodityController {
	
	@Autowired
	private CommodityService commodityService;
	
	@PostMapping(value = "addProduct")
	public addCommodityResponse listingProducts(@RequestBody addCommodityRequest request, HttpSession httpSession) {
		
		// ‰ñœärequest("")
		return commodityService.listingProducts(httpSession, request.getReqCommodity());
	}
	
	@PostMapping(value = "deleteProduct")
	public deleteCommodityResponse noSoldProducts(@RequestBody deleteCommodityRequest request, HttpSession httpSession) {
		
		return commodityService.noSoldProducts(httpSession, request.getNumber());
	}

}
