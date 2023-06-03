package com.example.shopping_platform_II.controller;

import com.example.shopping_platform_II.service.ifs.DeliveryWayCodeService;
import com.example.shopping_platform_II.vo.DeliverWayRequest;
import com.example.shopping_platform_II.vo.DeliverWayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryWayCodeController {
    @Autowired
    private DeliveryWayCodeService deliveryWayCodeService;

    @PostMapping(value = "add_delivery_way")
    public DeliverWayResponse addDeliveryWay(@RequestBody DeliverWayRequest request) {
        return deliveryWayCodeService.addDeliveryWay(request);
    }

    @PostMapping(value = "delete_delivery_way")
    public DeliverWayResponse deleteDeliveryWay(@RequestBody DeliverWayRequest request) {
        return deliveryWayCodeService.deleteDeliveryWay(request);
    }
    @GetMapping(value = "get_all_delivery_way")
    public DeliverWayResponse getAllDeliveryWay() {
        return deliveryWayCodeService.getAllDeliveryWay();
    }

}

