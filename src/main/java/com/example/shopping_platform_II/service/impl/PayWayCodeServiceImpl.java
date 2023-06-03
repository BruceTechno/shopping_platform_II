package com.example.shopping_platform_II.service.impl;

import com.example.shopping_platform_II.service.ifs.PayWayCodeService;
import com.example.shopping_platform_II.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PayWayCodeServiceImpl implements PayWayCodeService {
@Autowired
private PayWayCodeService payWayCodeService;
    @Override
    public AddPayWayResponse addPayWay(AddPayWayRequest request) {


        return null;
    }

    @Override
    public DeletePayWayResponse deletePayWay(DeletePayWayRequest request) {
        return null;
    }

    @Override
    public GetPayWayResponse getAllPayWay(GetPayWayRequest request) {
        return null;
    }
}
