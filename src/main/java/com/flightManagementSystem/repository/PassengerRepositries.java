package com.flightManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightManagementSystem.entity.Passenger;

public interface PassengerRepositries extends JpaRepository<Passenger,Long> {

}
