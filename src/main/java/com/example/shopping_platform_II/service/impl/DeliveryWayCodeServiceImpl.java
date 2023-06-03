package com.example.shopping_platform_II.service.impl;

import com.example.shopping_platform_II.constants.RtnCode;
import com.example.shopping_platform_II.entity.DeliveryWayCode;
import com.example.shopping_platform_II.entity.PayWayCode;
import com.example.shopping_platform_II.repository.DeliveryWayCodeDao;
import com.example.shopping_platform_II.service.ifs.DeliveryWayCodeService;
import com.example.shopping_platform_II.vo.AddPayWayResponse;
import com.example.shopping_platform_II.vo.DeletePayWayResponse;
import com.example.shopping_platform_II.vo.DeliverWayRequest;
import com.example.shopping_platform_II.vo.DeliverWayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class DeliveryWayCodeServiceImpl implements DeliveryWayCodeService {
    @Autowired
    private DeliveryWayCodeDao deliveryWayCodeDao;

    @Override
    public DeliverWayResponse addDeliveryWay(DeliverWayRequest request) {
        int code = request.getCode();
        String deliveryWay = request.getDeliveryWay();
        if (code < 0 || !StringUtils.hasText(deliveryWay)) {
            return new DeliverWayResponse(RtnCode.DATA_ERROR.getMessage());
        }
        DeliveryWayCode result = new DeliveryWayCode(code, deliveryWay);
        deliveryWayCodeDao.save(result);
        return new DeliverWayResponse(RtnCode.SUCCESSFUL.getMessage(),result);
    }

    @Override
    public DeliverWayResponse deleteDeliveryWay(DeliverWayRequest request) {
        int code = request.getCode();
        if (!deliveryWayCodeDao.existsById(code)){
            return new DeliverWayResponse(RtnCode.NOT_FOUND.getMessage());
        }
        deliveryWayCodeDao.deleteById(code);

        return new DeliverWayResponse(RtnCode.SUCCESSFUL.getMessage());
    }

    @Override
    public DeliverWayResponse getAllDeliveryWay() {
        List<DeliveryWayCode> result = deliveryWayCodeDao.findAll();
        return new DeliverWayResponse(RtnCode.SUCCESSFUL.getMessage(),result);
    }
}
