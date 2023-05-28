package com.example.shopping_platform_II.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.shopping_platform_II.constants.RtnCode;
import com.example.shopping_platform_II.entity.Commodity;
import com.example.shopping_platform_II.repository.CommodityDao;
import com.example.shopping_platform_II.service.ifs.CommodityService;
import com.example.shopping_platform_II.vo.CommodityResponse;
import com.example.shopping_platform_II.vo.addCommodityResponse;
import com.example.shopping_platform_II.vo.noSoldCommodityResponse;


@Service
public class CommodityServiceImpl implements CommodityService{
	
	@Autowired
	private CommodityDao commodityDao;
	
	/*
	 * checkLogin: 檢查是否有登錄
	 */
	private RtnCode checkLogin(String account, String pwd) {
		
		/* 
		 * login check
		 */
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			// plz login
			return RtnCode.PLEASE_LOGIN;
		}
		
		// userDao: 不屬於order功能的範圍, 是否要先merge後才能使用checkLogin?
		Integer checkRes = userDao.checkAccountAndPwd(account, pwd) == null ? 0 : 1;
		if ((int) checkRes == 0) {
			return RtnCode.ACCOUNT_PWD_ERROR;
		}

		return null;

	}
	
	
	// method1: 上架商品
	@Override
	public addCommodityResponse listingProducts(HttpSession httpSession, List<Commodity> goods) {
		
//		addCommodityResponse a = new addCommodityResponse();
		
		/*
		 * 帳號密碼檢查(merge後除錯)
		 */
		String account = (String) httpSession.getAttribute("account");
		
		String pwd = (String) httpSession.getAttribute("pwd");
		
		
		RtnCode res = checkLogin(account, pwd);

		
		if (res != null) {
			return new addCommodityResponse(res.getCode());
		}
		
		
		
		
		// 數據集合空值防呆
		if(CollectionUtils.isEmpty(goods)) {
			

			// RtnCode回傳錯誤
			return new addCommodityResponse(RtnCode.CONTENT_EMPTY.getMessage());
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

			// 檢查商品架上是否有重複的編號
			if(resNum.getNumber() > 0) {
				
				// 報錯(編號重複)
				return new addCommodityResponse(RtnCode.NUMBER_ERROR.getMessage());
			}
			
			
		}
		commodityDao.saveAll(goods);
		return new addCommodityResponse(RtnCode.SUCCESSFUL.getMessage());
	}

	// method2: 下架商品
	@Override
	public noSoldCommodityResponse noSoldProducts(HttpSession httpSession, int number) {

		/*
		 * 帳號密碼驗證
		 */
		String account = (String) httpSession.getAttribute("account");
		
		String pwd = (String) httpSession.getAttribute("pwd");
		
		// 呼叫checkLogin方法驗證帳號密碼
		RtnCode res = checkLogin(account, pwd);

		// RtnCode收到結果(錯誤訊息): 驗證失敗
		if(res != null) {
			// 取得錯誤代碼
			return new noSoldCommodityResponse(res.getCode());
		}
		
		// 輸入的商品編號為空直
		if(number == 0) {
			
			return new noSoldCommodityResponse(RtnCode.NUMBER_EMPTY.getMessage());
		}
		
		// 去資料庫找對應的編號
		Commodity resNum = commodityDao.findAllByNumber(number);

		// 找不到對應的產品編號
		if(resNum == null) {
			
			return new noSoldCommodityResponse(RtnCode.NO_NUM_GOODS_LIST.getMessage());
		}
		// ???
		if(resNum.getStatus() == 3) {
		
			return new noSoldCommodityResponse(RtnCode.CAN_NOT_DELETE.getMessage());
		}
		
		// 刪除產品編號
		commodityDao.deleteById(number);
		
		return new noSoldCommodityResponse(RtnCode.SUCCESSFUL.getMessage());
	}


	
}
