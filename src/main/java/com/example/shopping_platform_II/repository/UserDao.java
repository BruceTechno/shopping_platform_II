package com.example.shopping_platform_II.repository;


import com.example.shopping_platform_II.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository

public interface UserDao extends JpaRepository<User,Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into user(account,pwd,name,address,phone)" +
            " select :inputAccount, :inputPwd, :inputName, :inputAddress, :inputPhone" +
            " where not exists (select 1 from user where account = :inputAccount)" ,nativeQuery = true)
    public int insertUserInfoWhereNotExists(
            @Param("inputAccount")String inputAccount,
            @Param("inputPwd")String inputPwd,
            @Param("inputName")String inputName,
            @Param("inputAddress")String inputAddress,
            @Param("inputPhone")String inputPhone);

    public User findByAccountAndPwd(String account ,String pwd);

    public User findByAccountAndPwdAndActive(String account ,String pwd,boolean active);
    @Transactional
    @Modifying
    @Query(value = "update User u set u.pwd = :newPwd where u.account = :newAccount")
    public int updatePwdByAccount(
            @Param("newPwd")String inputPwd,
            @Param("newAccount")String inputAccount);

    @Transactional
    @Modifying
    @Query(value = "update User u set u.name = :newName where u.account = :newAccount")
    public int updateNameByAccount(
            @Param("newName")String inputName,
            @Param("newAccount")String inputAccount);

    @Transactional
    @Modifying
    @Query(value = "update User u set u.address = :newAddress where u.account = :newAccount")
    public int updateAddressByAccount(
            @Param("newAddress")String inputAddress,
            @Param("newAccount")String inputAccount);

    @Transactional
    @Modifying
    @Query(value = "update User u set u.phone = :newPhone where u.account = :newAccount")
    public int updatePhoneByAccount(
            @Param("newPhone")String inputPhone,
            @Param("newAccount")String inputAccount);

    @Query(value = "select 1 from user where account = :account and pwd = :pwd",nativeQuery = true )
	public Integer checkAccountAndPwd(
			@Param("account")String account,
			@Param("pwd")String pwd);


//
//public interface UserDao extends JpaRepository<User,Integer> {
//
//	public User findByAccountAndPwd(String account , String pwd);
//
//
//	@Query(value = "select 1 from user where account = :account and pwd = :pwd",nativeQuery = true )
//	public Integer checkAccountAndPwd(
//			@Param("account")String account,
//			@Param("pwd")String pwd);
//>>>>>>> origin/senhao_test
}
