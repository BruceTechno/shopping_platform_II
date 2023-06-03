package com.example.shopping_platform_II.service.ifs;

import com.example.shopping_platform_II.vo.*;

public interface DeliveryWayCodeService  {
    public DeliverWayResponse addDeliveryWay (DeliverWayRequest request) ;
    public DeliverWayResponse deleteDeliveryWay(DeliverWayRequest request) ;
    public DeliverWayResponse getAllDeliveryWay ();
}
