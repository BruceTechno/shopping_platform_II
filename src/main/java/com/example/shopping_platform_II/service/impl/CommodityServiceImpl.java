package com.example.shopping_platform_II.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.shopping_platform_II.constants.RtnCode;
import com.example.shopping_platform_II.entity.Commodity;
import com.example.shopping_platform_II.repository.CommodityDao;
import com.example.shopping_platform_II.service.ifs.CommodityService;
import com.example.shopping_platform_II.vo.addCommodityResponse;


@Service
public class CommodityServiceImpl implements CommodityService{
	
	@Autowired
	private CommodityDao commodityDao;
	
	@Override
	public addCommodityResponse listingProducts(List<Commodity> goods) {
		
		// 數據集合空值防呆
		if(CollectionUtils.isEmpty(goods)) {
			
			// RtnCode回傳錯誤
			return new addCommodityResponse(RtnCode.DATALIST_EMPTY.getMessage());
		}
		
//		List<Commodity> sqlGoods = commodityDao.findAll();
		
		
		// 上架前確認: 資料漏填, 與資料庫重複商品(確認number), 是否為賣家(只有賣家可以上架)?
		for(Commodity item: goods) {
			
			if(item.getNumber() <= 0 || !StringUtils.hasText(item.getName()) || 
					!StringUtils.hasText(item.getCategory())||item.getInventory() <= 0||
					item.getPrice() <= 0 || item.getStatus() <= 0|| item.getUserId() <= 0) {
				
				return new addCommodityResponse(RtnCode.CONTENT_EMPTY.getMessage());
			}
			
			// 檢查倉庫
			Commodity resNum = commodityDao.findAllByNumber(item.getNumber());

			if(resNum.getNumber() > 0 || resNum.getNumber() < 0) {
				
				// 報錯(編號重複)
				return new addCommodityResponse(RtnCode.NUMBER_ERROR.getMessage());
			}
			
			
		}
		commodityDao.saveAll(goods);
		return new addCommodityResponse(RtnCode.SUCCESSFUL.getMessage());
	}
}
