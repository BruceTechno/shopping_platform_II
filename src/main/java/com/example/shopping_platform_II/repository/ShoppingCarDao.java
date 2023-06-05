package com.example.shopping_platform_II.repository;


import com.example.shopping_platform_II.entity.ShoppingCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ShoppingCarDao extends JpaRepository<ShoppingCar,Integer> {
	
	public ShoppingCar findByUserIdAndCommodityNumber(String userId, int commodityNumber);
	
	public ShoppingCar deleteByUserIdAndCommodityNumber(String userId, int commodityNumber);
	
	@Transactional
	@Modifying
	@Query (value= "update shopping_car SC set SC.quantity=:inputQty" 
			+ " where SC.user_id =: inputId and SC.commodity_number=:inputCommodityNo)",nativeQuery = true)
	
	public int updateInfoFromCart (
			@Param ("inputQty") int qty,
			@Param ("inputId") String account,
			@Param ("inputCommodityNo") int number);
	
}
