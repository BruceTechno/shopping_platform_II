package com.example.shopping_platform_II.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

public class AddOrderRequest {



        //	Map<Integer, Integer> orderInfo,int payWay , int deliveryWay
        private Map<Integer, Integer> orderInfo;

        private int payWay;

        private int deliveryWay;

        public Map<Integer, Integer> getOrderInfo() {
            return orderInfo;
        }

        public void setOrderInfo(Map<Integer, Integer> orderInfo) {
            this.orderInfo = orderInfo;
        }

        public int getPayWay() {
            return payWay;
        }

        public void setPayWay(int payWay) {
            this.payWay = payWay;
        }

        public int getDeliveryWay() {
            return deliveryWay;
        }

        public void setDeliveryWay(int deliveryWay) {
            this.deliveryWay = deliveryWay;
        }


    }



