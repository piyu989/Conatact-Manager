package com.smart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.entites.User;

public interface userRepo extends JpaRepository<User, Integer> {

}
