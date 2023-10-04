package com.smart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.smart.entites.User;

public interface userRepo extends JpaRepository<User, Integer> {
	@Query("select u from user where u.email = : email")
	public User getUserByUserName(@Param("email")String email);
}
