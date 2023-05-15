package com.example.shopping_platform_II.repository;

import com.example.shopping_platform_II.entity.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityDao extends JpaRepository<Commodity,Integer> {//todo Integer對嗎???
}
