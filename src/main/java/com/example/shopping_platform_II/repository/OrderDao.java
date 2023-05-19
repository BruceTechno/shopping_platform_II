package com.example.shopping_platform_II.repository;


import com.example.shopping_platform_II.entity.Order;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OrderDao extends JpaRepository<Order,Integer> {
	
	
	@Transactional
	@Modifying
	@Query(value ="insert into order_info (order_number , account_buy , account_sell , order_info "
			+ ", pay_way , delivery_way , status ) select :orderNumber ,:accountBuy, :accountSell , "
			+ ":orderInfo , :payWay , :deliveryWay , :status where not exists "
			+ "(select 1 from order_info where order_number = :orderNumber)" ,nativeQuery = true)
	public int addOrderWhereNotExists(
			@Param("orderNumber")int oorderNumber,
			@Param("accountBuy")String accountBuy,
			@Param("accountSell")String accountSell,
			@Param("orderInfo")String orderInfo,
			@Param("payWay")int payWay,
			@Param("deliveryWay")int deliveryWay,
			@Param("status")int status);
}
