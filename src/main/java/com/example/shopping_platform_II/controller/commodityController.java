package com.example.shopping_platform_II.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping_platform_II.service.ifs.CommodityService;
import com.example.shopping_platform_II.vo.CommodityResponse;
import com.example.shopping_platform_II.vo.addCommodityRequest;
import com.example.shopping_platform_II.vo.addCommodityResponse;
import com.example.shopping_platform_II.vo.noSoldCommodityRequest;
import com.example.shopping_platform_II.vo.noSoldCommodityResponse;

@RestController
public class commodityController {
	
	@Autowired
	private CommodityService commodityService;
	
	
	public addCommodityResponse listingProducts(@RequestBody addCommodityRequest request, HttpSession httpSession) {
		
		// ‰ñœärequest
		return commodityService.listingProducts(httpSession, request.getReqCommodity());
	}
	
	public noSoldCommodityResponse noSoldProducts(@RequestBody noSoldCommodityRequest request, HttpSession httpSession) {
		
		return commodityService.noSoldProducts(httpSession, request.getNumber());
	}

}
