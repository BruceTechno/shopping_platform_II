package com.example.shopping_platform_II.repository;


import com.example.shopping_platform_II.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends JpaRepository<Order,Integer> {//todo Integer對嗎??
}
