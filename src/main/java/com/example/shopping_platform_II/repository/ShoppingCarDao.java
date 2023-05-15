package com.example.shopping_platform_II.repository;


import com.example.shopping_platform_II.entity.ShoppingCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCarDao extends JpaRepository<ShoppingCar,Integer> {//todo Integer對嗎
}
