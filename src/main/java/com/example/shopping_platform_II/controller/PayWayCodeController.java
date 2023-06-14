package com.example.shopping_platform_II.controller;

import com.example.shopping_platform_II.service.ifs.PayWayCodeService;
import com.example.shopping_platform_II.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class PayWayCodeController {
    @Autowired
    private PayWayCodeService payWayCodeService;
    @PostMapping(value = "add_pay_way")
    public AddPayWayResponse addPayWay(@RequestBody AddPayWayRequest request) {
        return payWayCodeService.addPayWay(request);
    }
    @PostMapping(value = "delete_pay_way")
    public DeletePayWayResponse deletePayWay(@RequestBody DeletePayWayRequest request) {
        return payWayCodeService.deletePayWay(request);
    }
    @GetMapping(value = "get_all_pay_way")
    public GetPayWayResponse getAllPayWay() {
        return payWayCodeService.getAllPayWay();
    }
}
