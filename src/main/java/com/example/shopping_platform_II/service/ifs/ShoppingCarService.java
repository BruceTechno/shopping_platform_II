package com.example.shopping_platform_II.service.ifs;

import com.example.shopping_platform_II.vo.*;

import javax.servlet.http.HttpSession;

public interface ShoppingCarService {
    public GetShoppingCarResponse getShoppingCar (HttpSession session);

}
