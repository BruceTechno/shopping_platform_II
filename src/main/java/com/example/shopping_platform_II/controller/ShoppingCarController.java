package com.example.shopping_platform_II.controller;

import com.example.shopping_platform_II.service.ifs.ShoppingCarService;
import com.example.shopping_platform_II.vo.GetShoppingCarResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@CrossOrigin
@RestController
public class ShoppingCarController {
    @Autowired
    private ShoppingCarService shoppingCarService;

    @GetMapping(value = "get_shopping_car_info")
    public GetShoppingCarResponse getShoppingCarInfo(HttpSession session){
        return shoppingCarService.getShoppingCarInfo(session);
    }
}
