package com.example.shopping_platform_II.repository;


import com.example.shopping_platform_II.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {//todo Integer
	
	public User findByAccountAndPwd(String account , String pwd);
	
	
	@Query(value = "select 1 from user where account = :account and pwd = :pwd",nativeQuery = true )
	public Integer checkAccountAndPwd(
			@Param("account")String account,
			@Param("pwd")String pwd);
}
