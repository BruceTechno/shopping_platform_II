package com.example.shopping_platform_II.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.shopping_platform_II.constants.RtnCode;
import com.example.shopping_platform_II.entity.Commodity;
import com.example.shopping_platform_II.entity.Order;
import com.example.shopping_platform_II.entity.User;
import com.example.shopping_platform_II.repository.CommodityDao;
import com.example.shopping_platform_II.repository.OrderDao;
import com.example.shopping_platform_II.repository.UserDao;
import com.example.shopping_platform_II.service.ifs.OrderService;
import com.example.shopping_platform_II.service.vo.AddOrderResponse;
import com.example.shopping_platform_II.service.vo.DeleteOrderResponse;
import com.example.shopping_platform_II.service.vo.SearchOrderResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.bytebuddy.asm.Advice.Return;

@Service
public class OrderServiceIImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private UserDao userDao;
	@Autowired
	private CommodityDao commodityDao;

	@Override
	public AddOrderResponse addOrder(HttpSession httpSession, Map<Integer, Integer> orderInfo, int payWay,
			int deliveryWay) {
		String accountBuy = (String) httpSession.getAttribute("account");
		String pwd = (String) httpSession.getAttribute("pwd");

		// login check
		if (!StringUtils.hasText(accountBuy) || !StringUtils.hasText(pwd)) {
			return new AddOrderResponse(RtnCode.PLEASE_LOGIN_FIRST.getCode());
		}

		// account pwd check
		User userInfo = userDao.findByAccountAndPwd(accountBuy, pwd);
		if (userInfo == null) {
			return new AddOrderResponse(RtnCode.ACCOUNT_PWD_ERROR.getCode());
		}

		// order check
		if (orderInfo.size() <= 0) {
			return new AddOrderResponse(RtnCode.CANNOT_EMPTY.getCode());
		}

		// commodity inventory count
		// put comNumberAndAccount
		Map<Integer, String> comAndUser = new HashMap<Integer, String>();
		// add account_sell
		Set<String> accountSaleSet =new HashSet<>();
		for (Entry<Integer, Integer> item : orderInfo.entrySet()) {
			Optional<Commodity> op = commodityDao.findById(item.getKey());

			comAndUser.put(item.getKey(), op.get().getAccountSell());
			accountSaleSet.add(op.get().getAccountSell());

			// 減少庫存
			if (!(op.get().getInventory() >= item.getValue())) {
				return new AddOrderResponse(RtnCode.INVENTORY_NOT_ENOUGH.getCode());
			}
			op.get().setInventory(op.get().getInventory() - item.getValue());
			commodityDao.save(op.get());
		}

		// test 一次買多位不同買家,分別成立訂單
		for (String accountSaleItem : accountSaleSet) {

			Map<Integer, Integer> newOrderInfo = new HashMap<Integer, Integer>();

			for (Entry<Integer, String> comAmdUesrItem : comAndUser.entrySet()) {
				for (Entry<Integer, Integer> orderItem : orderInfo.entrySet()) {
					if (accountSaleItem.equals(comAmdUesrItem.getValue())
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
				int check = orderDao.addOrderWhereNotExists(orderNumber, accountBuy, accountSaleItem, orderInfoStr,
						payWay, deliveryWay, 0);
				checkOrderNumber = check == 1 ? false : true;
			}

		}

		return new AddOrderResponse(RtnCode.SUCCESSFUL.getCode());

	}

	@Override
	public DeleteOrderResponse deleteOrder(HttpSession httpSession, int orderNumber) {

		String account_buy = (String) httpSession.getAttribute("account");
		String pwd = (String) httpSession.getAttribute("pwd");
		// login check
		if (!StringUtils.hasText(account_buy) || !StringUtils.hasText(pwd)) {
			// plz login
			return new DeleteOrderResponse(RtnCode.PLEASE_LOGIN_FIRST.getCode());
		}

		// account pwd check
		User userInfo = userDao.findByAccountAndPwd(account_buy, pwd);
		if (userInfo == null) {
			return new DeleteOrderResponse(RtnCode.ACCOUNT_PWD_ERROR.getCode());
		}

		// check account_buy have this orderNumber
		Order orderInfo = orderDao.findByAccountBuyAndOrderNumber(account_buy, orderNumber);
		if (orderInfo == null) {
			return new DeleteOrderResponse(RtnCode.NOT_FOUND.getCode());
		}

		if (orderInfo.getStatus() == 3) {
			return new DeleteOrderResponse(RtnCode.CAN_NOT_DELETE.getCode());
		}

		orderDao.deleteById(orderNumber);

		return new DeleteOrderResponse(RtnCode.SUCCESSFUL.getCode());

	}

	@Override
	public SearchOrderResponse searchOrderByAccountBuy(String accountBuy, String pwd) {
		// login check
		if (!StringUtils.hasText(accountBuy) || !StringUtils.hasText(pwd)) {
			// plz login
			return new SearchOrderResponse(RtnCode.PLEASE_LOGIN_FIRST.getCode());
		}

		// account pwd check
		Integer checkRes = userDao.checkAccountAndPwd(accountBuy, pwd)==null ? 0 :1;
		if((int)checkRes == 0) {
			return new SearchOrderResponse(RtnCode.ACCOUNT_PWD_ERROR.getCode());
		}
		
		//check order exists
		List<Order> orderInfo = orderDao.findByAccountBuy(accountBuy);
		
		if(CollectionUtils.isEmpty(orderInfo)) {
			return new SearchOrderResponse(RtnCode.NOT_FOUND.getCode());
		}
		
		return new SearchOrderResponse(RtnCode.SUCCESSFUL.getCode(), orderInfo);

	}

	@Override
	public SearchOrderResponse searchOrderByAccountsale(String accountSale, String pwd) {
		// login check
		if (!StringUtils.hasText(accountSale) || !StringUtils.hasText(pwd)) {
			// plz login
			return new SearchOrderResponse(RtnCode.PLEASE_LOGIN_FIRST.getCode());
		}

		// account pwd check
		Integer checkRes = userDao.checkAccountAndPwd(accountSale, pwd)==null ? 0 :1;
		if((int)checkRes == 0) {
			return new SearchOrderResponse(RtnCode.ACCOUNT_PWD_ERROR.getCode());
		}
		
		//check order exists
		List<Order> orderInfo = orderDao.findByAccountSale(accountSale);
		
		if(CollectionUtils.isEmpty(orderInfo)) {
			return new SearchOrderResponse(RtnCode.NOT_FOUND.getCode());
		}
		
		return new SearchOrderResponse(RtnCode.SUCCESSFUL.getCode(), orderInfo);

	}

}
