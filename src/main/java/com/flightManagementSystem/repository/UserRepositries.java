package com.flightManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightManagementSystem.entity.User;

public interface UserRepositries extends JpaRepository<User, Long> {

	User findByEmail(String emailId);

	User getByEmail(String emailId);


}
