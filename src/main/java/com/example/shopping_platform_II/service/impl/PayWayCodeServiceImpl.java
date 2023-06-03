package com.example.shopping_platform_II.service.impl;

import com.example.shopping_platform_II.constants.RtnCode;
import com.example.shopping_platform_II.entity.PayWayCode;
import com.example.shopping_platform_II.repository.PayWayCodeDao;
import com.example.shopping_platform_II.service.ifs.PayWayCodeService;
import com.example.shopping_platform_II.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service

public class PayWayCodeServiceImpl implements PayWayCodeService {
@Autowired
private PayWayCodeDao payWayCodeDao;
    @Override
    public AddPayWayResponse addPayWay(AddPayWayRequest request) {
    int code = request.getCode();
    String payWay = request.getPayWay();
    if (code < 0 || !StringUtils.hasText(payWay)){
        return new AddPayWayResponse(RtnCode.DATA_ERROR.getMessage());
    }
        PayWayCode result = new PayWayCode(code,payWay);
        payWayCodeDao.save(result);

        return new AddPayWayResponse(RtnCode.SUCCESSFUL.getMessage(),result);
    }

    @Override
    public DeletePayWayResponse deletePayWay(DeletePayWayRequest request) {
        int code = request.getCode();
        if (!payWayCodeDao.existsById(code)){
            return new DeletePayWayResponse(RtnCode.NOT_FOUND.getMessage());
        }
        payWayCodeDao.deleteById(code);

        return new DeletePayWayResponse(RtnCode.SUCCESSFUL.getMessage());
    }

    @Override
    public GetPayWayResponse getAllPayWay() {
        List<PayWayCode> result = payWayCodeDao.findAll();
        return new GetPayWayResponse(RtnCode.SUCCESSFUL.getMessage(), result);
    }
}
