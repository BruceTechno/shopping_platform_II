package com.example.shopping_platform_II.service.impl;

import java.util.Iterator;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.shopping_platform_II.entity.ShoppingCar;
import com.example.shopping_platform_II.repository.CommodityDao;
import com.example.shopping_platform_II.repository.ShoppingCarDao;
import com.example.shopping_platform_II.service.ifs.ShoppingCarService;
import com.example.shopping_platform_II.vo.AddCommodityToCarRequest;
import com.example.shopping_platform_II.vo.AddCommodityToCarResponse;
import com.example.shopping_platform_II.vo.DelCommodityFromCartRequest;
import com.example.shopping_platform_II.vo.DelCommodityFromCartResponse;
import com.example.shopping_platform_II.vo.UpdateInfoFromCartRequest;
import com.example.shopping_platform_II.vo.UpdateInfoFromCartResponse;

@Service
public class ShoppingCarServiceImpl implements ShoppingCarService{
	
	@Autowired
    private CommodityDao commodityDao;
	
	private ShoppingCarDao shoppingCarDao;

	@Override
	public AddCommodityToCarResponse addCommodityToCar(HttpSession httpSession, AddCommodityToCarRequest request) {
		
		String account = (String) httpSession.getAttribute("account");
		
        String pwd = (String) httpSession.getAttribute("pwd");
        
        int number = request.getCommodityNumber();
        
        int qty = request.getQuantity();
        
        if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
            return new AddCommodityToCarResponse("pls log in");
        }
        
        if (!commodityDao.existsById(number)) {
			return new AddCommodityToCarResponse("this commodity is not exist");
		}
        
//       從購物車dao表撈資料 判斷該帳號userid在購物車是否有資料、
//       如果沒有 就set數量 user id number都要丟進去 null
//       如果有 就判斷要加入的商品編號是否有重複 如果重複就丟數量＋1
//       確認沒問題再將資料存入
      ShoppingCar result = shoppingCarDao.findByUserIdAndCommodityNumber(account, number);
      
      ShoppingCar finalResult= new ShoppingCar(account,number,qty);
     
        if (result == null) {
			 shoppingCarDao.save(finalResult);
		} else {
			result.setQuantity(qty);
			shoppingCarDao.save(result);
		}
        
        return new AddCommodityToCarResponse("sucessful");
	}

	@Override
	public DelCommodityFromCartResponse deleCommodityFromCart(HttpSession httpSession,
			DelCommodityFromCartRequest request) {
		
		String account = (String) httpSession.getAttribute("account");
		
        String pwd = (String) httpSession.getAttribute("pwd");
        
        int number = request.getCommodityNumber();
        
        if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
            return new DelCommodityFromCartResponse("pls log in");
        }
        if (!commodityDao.existsById(number)) {
			return new DelCommodityFromCartResponse("this commodity is not exist");
		}
        
        shoppingCarDao.deleteByUserIdAndCommodityNumber(account, number);
        
		return new DelCommodityFromCartResponse("sucessful");
	}

	@Override
	public UpdateInfoFromCartResponse updateInfoFromCart(HttpSession httpSession, UpdateInfoFromCartRequest request) {
		
		String account = (String) httpSession.getAttribute("account");
		
        String pwd = (String) httpSession.getAttribute("pwd");
        
        int qty = request.getQuantity();
        
        int number = request.getCommodityNumber();
        
        int result = shoppingCarDao.updateInfoFromCart(qty, account, number);
        
        if (result == 0) {
			return new UpdateInfoFromCartResponse ("");
		}
       
		return new UpdateInfoFromCartResponse ("sucessful");
	}
}
