package com.prabin.coding.personal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prabin.coding.personal.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
