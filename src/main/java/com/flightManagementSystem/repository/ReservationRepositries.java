package com.flightManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightManagementSystem.entity.Reservation;

public interface ReservationRepositries extends JpaRepository<Reservation, Long> {

}
