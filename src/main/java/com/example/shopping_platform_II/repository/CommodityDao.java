package com.example.shopping_platform_II.repository;

import com.example.shopping_platform_II.entity.Commodity;
import com.example.shopping_platform_II.vo.DistinctSearchResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CommodityDao extends JpaRepository<Commodity,Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into commodity(number,name,category,inventory,price,account_sell)" +
            " select :inputNumber, :inputName, :inputCategory, :inputInventory, :inputPrice, :inputAccountSell" +
            " where not exists (select 1 from commodity where number = :inputNumber)" ,nativeQuery = true)
    public int addCommodityWhereNotExists(
            @Param("inputNumber")int number,
            @Param("inputName")String inputName,
            @Param("inputCategory")String inputCategory,
            @Param("inputInventory")int inputInventory,
            @Param("inputPrice")int inputPrice,
            @Param("inputAccountSell")String inputAccountSell,
            @Param("inputNumber")int inputNumber);
    @Transactional
    @Modifying
    @Query(value = "update Commodity c set c.name = :newName where c.number = :inputNumber")
    public int updateNameByNumber(
            @Param("newName")String inputName,
            @Param("inputNumber")int inputNumber);
    @Transactional
    @Modifying
    @Query(value = "update Commodity c set c.category = :newCategory where c.number = :inputNumber")
    public int updateCategoryByNumber(
            @Param("newCategory")String inputCategory,
            @Param("inputNumber")int inputNumber);
    @Transactional
    @Modifying
    @Query(value = "update Commodity c set c.inventory = :newInventory where c.number = :inputNumber")
    public int updateInventoryByNumber(
            @Param("newInventory")int inputInventory,
            @Param("inputNumber")int inputNumber);
    @Transactional
    @Modifying
    @Query(value = "update Commodity c set c.price = :newPrice where c.number = :inputNumber")
    public int updatePriceByNumber(
            @Param("newPrice")int inputPrice,
            @Param("inputNumber")int inputNumber);
    public List<Commodity> findByName (String name);
    public List<Commodity> findByCategory (String category);
    @Transactional
    @Modifying
    @Query("select new com.example.shopping_platform_II.vo.DistinctSearchResponse(c.number,c.name,c.category,c.inventory,c.price,c.accountSell)" +
            " from Commodity c" +
            " where c.name like concat('%',:inputName,'%')")
    public List<DistinctSearchResponse> distinctSearchByName (@Param("inputName")String name);

    @Transactional
    @Modifying
    @Query("select new com.example.shopping_platform_II.vo.DistinctSearchResponse(c.number,c.name,c.category,c.inventory,c.price,c.accountSell)" +
            " from Commodity c" +
            " where c.name like concat('%',:inputCategory,'%')")
    public List<DistinctSearchResponse> distinctSearchByCategory (@Param("inputCategory")String category);

    @Transactional
    @Modifying
    @Query("select new com.example.shopping_platform_II.vo.DistinctSearchResponse(c.number,c.name,c.category,c.inventory,c.price,c.accountSell)" +
            " from Commodity c" +
            " where c.name like concat('%',:inputKeyword,'%')   ")
    public List<DistinctSearchResponse> distinctSearchByNameOrCategory (@Param("inputKeyword")String nameOrCategory);

//    @Transactional
//    @Modifying
//    @Query("select new com.example.subject_system.vo.StudentResponse(s.number,s.name,c.code,c.name,c.day,c.startTime,c.endTime,c.credit)" +
//            " from Course c join Student s on s.code" +
//            " Like concat('%',c.code,'%')" +
//            " where s.number = :newNumber")
//    public List<StudentResponse> searchByStudentNumber(@Param("newNumber")int newNumber);

}
