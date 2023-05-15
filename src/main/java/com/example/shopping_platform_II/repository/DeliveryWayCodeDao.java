package com.example.shopping_platform_II.repository;

import com.example.shopping_platform_II.entity.DeliveryWayCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryWayCodeDao extends JpaRepository<DeliveryWayCode,Integer> {//todo Integer對嗎????
}
