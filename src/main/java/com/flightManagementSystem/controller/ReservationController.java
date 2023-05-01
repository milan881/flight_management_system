package com.flightManagementSystem.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightManagementSystem.dto.ReservationRequest;
import com.flightManagementSystem.entity.Flight;
import com.flightManagementSystem.entity.Reservation;
import com.flightManagementSystem.repository.FlightRepositries;
import com.flightManagementSystem.repository.ReservationRepositries;
import com.flightManagementSystem.services.ReservationServices;
import com.flightManagementSystem.services.ReservatoinServicesImpl;
import com.flightManagementSystem.utilites.PdfGenerator;

@Controller
public class ReservationController {

	@Autowired
	FlightRepositries flightRepositries;
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam ("flightsId") long flightsId,ModelMap modelMap) {
			Optional<Flight> findById = flightRepositries.findById(flightsId);
			Flight flight = findById.get();
			modelMap.addAttribute("flight", flight);
		return "showReservation";
	}
	
	@Autowired
	private ReservatoinServicesImpl reservationServices;
			
	@RequestMapping("/compleateReservation")
	public String compleateReservation(ReservationRequest request,ModelMap modelMap) {
		Reservation reservationId = reservationServices.bookFlight(request);
		modelMap.addAttribute("reservationId", reservationId.getId());
		return "confirmReservation";
	}
	
}
