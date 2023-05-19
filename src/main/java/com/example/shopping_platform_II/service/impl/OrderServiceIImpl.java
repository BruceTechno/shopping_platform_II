package com.example.shopping_platform_II.service.impl;

import java.util.HashMap;
import java.util.HashSet;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.util.StringUtils;

import com.example.shopping_platform_II.constants.RtnCode;
import com.example.shopping_platform_II.entity.Commodity;

import com.example.shopping_platform_II.repository.CommodityDao;
import com.example.shopping_platform_II.repository.OrderDao;

import com.example.shopping_platform_II.service.ifs.OrderService;
import com.example.shopping_platform_II.service.vo.AddOrderResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OrderServiceIImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private CommodityDao commodityDao;

	@Override
	public AddOrderResponse addOrder(HttpSession httpSession, Map<Integer, Integer> orderInfo, int payWay,
			int deliveryWay) {
		String account_buy = (String) httpSession.getAttribute("account");
		String pwd = (String) httpSession.getAttribute("pwd");

		// login check
		if (!StringUtils.hasText(account_buy) || !StringUtils.hasText(pwd)) {
			return new AddOrderResponse(RtnCode.PLEASE_LOGIN_FIRST.getCode());
		}

		// order check
		if (orderInfo.size() <= 0) {
			return new AddOrderResponse(RtnCode.CANNOT_EMPTY.getCode());
		}

		// commodity inventory count
		// put comNumberAndAccount
		Map<Integer, String> comAndUser = new HashMap<Integer, String>();
		// add account_sell
		Set<String> accountCount = new HashSet<>();
		for (Entry<Integer, Integer> item : orderInfo.entrySet()) {
			Optional<Commodity> op = commodityDao.findById(item.getKey());

			comAndUser.put(item.getKey(), op.get().getAccountSell());
			accountCount.add(op.get().getAccountSell());

			// 減少庫存
			if (!(op.get().getInventory() >= item.getValue())) {
				return new AddOrderResponse(RtnCode.INVENTORY_NOT_ENOUGH.getCode());
			}
			op.get().setInventory(op.get().getInventory() - item.getValue());
			commodityDao.save(op.get());
		}

		// test 一次買多位不同買家
		for (String accountNumItem : accountCount) {

			Map<Integer, Integer> newOrderInfo = new HashMap<Integer, Integer>();

			for (Entry<Integer, String> comAmdUesrItem : comAndUser.entrySet()) {
				for (Entry<Integer, Integer> orderItem : orderInfo.entrySet()) {
					if (accountNumItem.equals(comAmdUesrItem.getValue())
							&& comAmdUesrItem.getKey() == orderItem.getKey()) {

						newOrderInfo.put(orderItem.getKey(), orderItem.getValue());

					}

				}
			}
			// change map to string
			ObjectMapper mapper = new ObjectMapper();
			String orderInfoStr = "";
			try {
				orderInfoStr = mapper.writeValueAsString(newOrderInfo);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			boolean checkOrderNumber = true;
			while (checkOrderNumber) {
				int orderNumber = (int) (Math.random() * 10000 + 1);
				int check = orderDao.addOrderWhereNotExists(orderNumber, account_buy, accountNumItem, orderInfoStr,
						payWay, deliveryWay, 0);
				checkOrderNumber = check == 1 ? false : true;
			}

		}

		return new AddOrderResponse(RtnCode.SUCCESSFUL.getCode(), orderInfo);

	}

	@Override
	public void deleteOrder() {

	}

}
