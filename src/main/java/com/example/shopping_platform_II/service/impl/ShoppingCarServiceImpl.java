package com.example.shopping_platform_II.service.impl;

import com.example.shopping_platform_II.constants.RtnCode;
import com.example.shopping_platform_II.entity.ShoppingCar;
import com.example.shopping_platform_II.repository.CommodityDao;
import com.example.shopping_platform_II.repository.ShoppingCarDao;
import com.example.shopping_platform_II.service.ifs.ShoppingCarService;
import com.example.shopping_platform_II.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
//back up for test
@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {
    @Autowired
    private ShoppingCarDao shoppingCarDao;

    @Override
    public GetShoppingCarResponse getShoppingCarInfo(HttpSession session) {
        //先抓session Id 抓account 然後用 account 去抓購物車裡面符合的account 再把這些符合的抓出來
        String account = (String) session.getAttribute("account");
        if (!StringUtils.hasText(account)) {
            return new GetShoppingCarResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
        }
        List<ShoppingCar> result = shoppingCarDao.findAllByUserId(account);
        List<GetCommodityInfo> result2 = shoppingCarDao.getCommodityFromShoppingCar(account);

        return new GetShoppingCarResponse(RtnCode.SUCCESSFUL.getMessage(), result2);
    }
}
