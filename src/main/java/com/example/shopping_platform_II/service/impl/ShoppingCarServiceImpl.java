package com.example.shopping_platform_II.service.impl;

import com.example.shopping_platform_II.constants.RtnCode;
import com.example.shopping_platform_II.entity.Commodity;
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

import java.util.Optional;


@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {
    @Autowired
    private ShoppingCarDao shoppingCarDao;

    @Autowired
    private CommodityDao commodityDao;

    @Override
    public AddCommodityToCarResponse addCommodityToCar(HttpSession httpSession, AddCommodityToCarRequest request) {

        String account = (String) httpSession.getAttribute("account");

        String pwd = (String) httpSession.getAttribute("pwd");

        int number = request.getCommodityNumber();

        int qty = request.getQuantity();

        if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
            return new AddCommodityToCarResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
        }

        if (!commodityDao.existsById(number)) {
            return new AddCommodityToCarResponse(RtnCode.NOT_FOUND.getMessage());
        }

//       從購物車dao表撈資料 判斷該帳號userid在購物車是否有資料、
//       如果沒有 就set數量 user id number都要丟進去 null
//       如果有 就判斷要加入的商品編號是否有重複 如果重複就丟數量＋1
//       確認沒問題再將資料存入
        ShoppingCar result = shoppingCarDao.findByUserIdAndCommodityNumber(account, number);

//      狀況1 : if result = null, and qty ok ->存入
//      狀況2 : if result is not null , sum qty < stock ->存入
//      新增防呆條件，1. 商品假如商品表庫存數量低於要加入的數量就不可以儲存
        Optional<Commodity> checkQty = commodityDao.findById(number);

        ShoppingCar finalResult = new ShoppingCar(account, number, qty);

        if (result == null) {
            if (checkQty.get().getInventory() >= qty) {
                shoppingCarDao.save(finalResult);
            } else {
                return new AddCommodityToCarResponse(RtnCode.INVENTORY_NOT_ENOUGH.getMessage());
            }
        } else {
            if (checkQty.get().getInventory() >= result.getQuantity() + qty) {
                result.setQuantity(result.getQuantity() + qty);
                shoppingCarDao.save(result);
            } else {
                return new AddCommodityToCarResponse(RtnCode.INVENTORY_NOT_ENOUGH.getMessage());
            }
        }

        return new AddCommodityToCarResponse(RtnCode.SUCCESSFUL.getMessage());
    }

    @Override
    public DelCommodityFromCartResponse deleCommodityFromCart(HttpSession httpSession,
                                                              DelCommodityFromCartRequest request) {

//		改成多筆刪除 ？ 商品number 可以輸入多筆
        String account = (String) httpSession.getAttribute("account");

        String pwd = (String) httpSession.getAttribute("pwd");

        int number = request.getCommodityNumber();

        if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
            return new DelCommodityFromCartResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
        }

        if (!commodityDao.existsById(number)) {
            return new DelCommodityFromCartResponse(RtnCode.NOT_FOUND.getMessage());
        }

        shoppingCarDao.deleteByUserIdAndCommodityNumber(account, number);

        return new DelCommodityFromCartResponse(RtnCode.SUCCESSFUL.getMessage());
    }

    @Override
    public UpdateInfoFromCartResponse updateInfoFromCart(HttpSession httpSession, UpdateInfoFromCartRequest request) {
        // 庫存數量防呆
        String account = (String) httpSession.getAttribute("account");

        String pwd = (String) httpSession.getAttribute("pwd");

        int qty = request.getQuantity();

        int number = request.getCommodityNumber();

        Optional<Commodity> checkQty = commodityDao.findById(number);

        if (!checkQty.isPresent()) {
            return new UpdateInfoFromCartResponse(RtnCode.NOT_FOUND.getMessage());
        }

        // 這條寫在前面是否就會先updatedao裏面的qty 是不是應該改成find

        if (checkQty.get().getInventory() < qty) {
            return new UpdateInfoFromCartResponse(RtnCode.INVENTORY_NOT_ENOUGH.getMessage());
        }

        int result = shoppingCarDao.updateInfoFromCart(qty, account, number);

        if (result == 0) {
            return new UpdateInfoFromCartResponse(RtnCode.NOT_FOUND.getMessage());
        } else {
            shoppingCarDao.updateInfoFromCart(qty, account, number);
        }

        return new UpdateInfoFromCartResponse(RtnCode.SUCCESSFUL.getMessage());
    }

    @Override
    public GetShoppingCarResponse getShoppingCarInfo(HttpSession session) {
        // 先抓session Id 抓account 然後用 account 去抓購物車裡面符合的account 再把這些符合的抓出來
        String account = (String) session.getAttribute("account");
        if (!StringUtils.hasText(account)) {
            return new GetShoppingCarResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
        }
        List<ShoppingCar> result = shoppingCarDao.findAllByUserId(account);
        List<GetCommodityInfo> result2 = shoppingCarDao.getCommodityFromShoppingCar(account);

        return new GetShoppingCarResponse(RtnCode.SUCCESSFUL.getMessage(), result2);
    }
}



