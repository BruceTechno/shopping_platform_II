package com.example.shopping_platform_II.service.impl;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.shopping_platform_II.constants.RtnCode;
import com.example.shopping_platform_II.entity.User;
import com.example.shopping_platform_II.repository.OrderDao;
import com.example.shopping_platform_II.repository.UserDao;
import com.example.shopping_platform_II.service.ifs.OrderService;
import com.example.shopping_platform_II.service.vo.AddOrderResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OrderServiceIImpl implements OrderService {

	@Autowired
	OrderDao orderDao;

	@Autowired
	UserDao userDao;

	@Override
	public AddOrderResponse addOrder(HttpSession httpSession, Map<Integer, Integer> orderInfo, int payWay, int deliveryWay) {
		String account = (String) httpSession.getAttribute("account");
		String pwd = (String) httpSession.getAttribute("pwd");

		//login check
		if (StringUtils.hasText(account) || StringUtils.hasText(pwd)) {
			return new AddOrderResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
		}

		// order check
		if (orderInfo.size() <= 0) {
			return new AddOrderResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}

		//change map to string
		ObjectMapper mapper = new ObjectMapper();
		String orderInfoStr = "";
		try {
			orderInfoStr = mapper.writeValueAsString(orderInfo);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean checkOrderNumber = true;
		while (checkOrderNumber) {
			int orderNumber = (int) (Math.random() * 10000 + 1);
			int check = orderDao.addOrderWhereNotExists(orderNumber, account, orderInfoStr, payWay, deliveryWay, 0);
			checkOrderNumber = check == 1 ? false : true;
		}
		
		return new AddOrderResponse(orderInfoStr, orderInfo);

	}

	@Override
	public void deleteOrder() {
		// TODO Auto-generated method stub
		
	}

}
