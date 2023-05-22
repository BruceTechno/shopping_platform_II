package com.example.shopping_platform_II.repository;

import com.example.shopping_platform_II.entity.Commodity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityDao extends JpaRepository<Commodity,Integer> {

	public Commodity findAllByNumber(int number);

}
