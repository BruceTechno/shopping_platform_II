package com.example.shopping_platform_II.service.ifs;

import com.example.shopping_platform_II.vo.*;

public interface PayWayCodeService {
    public AddPayWayResponse addPayWay (AddPayWayRequest request) ;
    public DeletePayWayResponse deletePayWay(DeletePayWayRequest request) ;
    public GetPayWayResponse getAllPayWay ();
}
