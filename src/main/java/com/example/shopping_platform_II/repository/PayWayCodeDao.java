package com.example.shopping_platform_II.repository;


import com.example.shopping_platform_II.entity.PayWayCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayWayCodeDao extends JpaRepository<PayWayCode,Integer> {
}
