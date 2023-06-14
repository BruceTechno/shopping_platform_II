package com.example.shopping_platform_II.repository;

import com.example.shopping_platform_II.entity.ShoppingCar;
import com.example.shopping_platform_II.vo.GetCommodityInfo;
import com.example.shopping_platform_II.vo.GetShoppingCarResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ShoppingCarDao extends JpaRepository<ShoppingCar, Integer> {
	public List<ShoppingCar> findAllByUserId(String userId);

    @Transactional
    @Modifying
    @Query("select new com.example.shopping_platform_II.vo.GetCommodityInfo(sc.userId,sc.commodityNumber,sc.quantity,c.name,c.category,c.inventory,c.price,c.accountSell,c.imgPath)" +                                     //
            " from ShoppingCar sc join Commodity c on c.number = sc.commodityNumber" +
            " where sc.userId = :newUserId")
    public List<GetCommodityInfo> getCommodityFromShoppingCar (@Param("newUserId")String newUserid);

	public ShoppingCar findByUserIdAndCommodityNumber(String userId, int commodityNumber);


	@Transactional
//	delete不用回傳型態 要加transactional 因為有報錯
	public void deleteByUserIdAndCommodityNumber(String userId, int commodityNumber);

	@Transactional
	@Modifying
	@Query(value = "update shopping_car SC set SC.quantity = :inputQty"
			+ " where SC.user_id = :inputId and SC.commodity_number = :inputCommodityNo", nativeQuery = true)

	public int updateInfoFromCart(@Param("inputQty") int qty, @Param("inputId") String account,
			@Param("inputCommodityNo") int number);


}
