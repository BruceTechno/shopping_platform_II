package com.example.shopping_platform_II.repository;

import com.example.shopping_platform_II.entity.IdentityCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentityCodeDao extends JpaRepository<IdentityCode,Integer> {
}
