package com.example.shopping_platform_II.repository;


import com.example.shopping_platform_II.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {//todo Integer
	
	public User findByAccountAndPwd(String account , String pwd);
}
