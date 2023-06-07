package com.example.shopping_platform_II.repository;

import com.example.shopping_platform_II.entity.Commodity;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityDao extends JpaRepository<Commodity,Integer> {

//	public Commodity findByNumber(int number);

	
	// 加入商品的Dao
//	@Transactional
//    @Modifying
//    @Query(value = "insert into commodity(number,name,category,inventory,price,account_sell)" +
//            " select :inputNumber, :inputName, :inputCategory, :inputInventory, :inputPrice, :inputAccountSell" +
//            " where not exists (select 1 from commodity where number = :inputNumber)" ,nativeQuery = true)
//    public int addCommodityWhereNotExists(
//            @Param("inputNumber")int number,
//            @Param("inputName")String inputName,
//            @Param("inputCategory")String inputCategory,
//            @Param("inputInventory")int inputInventory,
//            @Param("inputPrice")int inputPrice,
//            @Param("inputAccountSell")String inputAccountSell,
//            @Param("inputNumber")int inputNumber);
	
//	@Transactional
//	@Modifying
//	@Query(value = "")
//	public default int updateAllByNumber() {
//		return null;
//	}
}
