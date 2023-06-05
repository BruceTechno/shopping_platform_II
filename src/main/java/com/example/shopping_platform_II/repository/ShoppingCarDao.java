package com.example.shopping_platform_II.repository;


import com.example.shopping_platform_II.entity.ShoppingCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCarDao extends JpaRepository<ShoppingCar,Integer> {
    public List<ShoppingCar> findAllByUserId (String userId);
}
