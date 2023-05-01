package com.flightManagementSystem.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightManagementSystem.dto.ReservationRequest;
import com.flightManagementSystem.entity.Passenger;
import com.flightManagementSystem.entity.Reservation;
import com.flightManagementSystem.repository.FlightRepositries;
import com.flightManagementSystem.repository.PassengerRepositries;
import com.flightManagementSystem.repository.ReservationRepositries;
import com.flightManagementSystem.utilites.PdfGenerator;

@Service
public class ReservatoinServicesImpl implements ReservationServices {

	
	@Autowired
	private FlightRepositries flightRepo;
	
	@Autowired
	private PassengerRepositries passengerRepo;
	
	@Autowired
	private ReservationRepositries reservationRepo;
	
	
	
	public Reservation bookFlight(ReservationRequest request) {
		
		String filePath = "C:\\Users\\MILAN RAJA\\Desktop\\STS\\sts-4.8.1.RELEASE\\Project\\tickets\\";
		
			long flightId = request.getFlightId();
				Optional<com.flightManagementSystem.entity.Flight> findById = flightRepo.findById(flightId);
					com.flightManagementSystem.entity.Flight flight = findById.get();
				
				Passenger passenger  = new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setEmail(request.getEmail());
		passenger.setMobile(request.getMobile());
		
		passengerRepo.save(passenger);
		
		Reservation reservation  = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(passenger);
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		reservationRepo.save(reservation);
		
		PdfGenerator pdf = new PdfGenerator();
		pdf.generatePDF(filePath+reservation.getId()+".pdf", request.getFirstName(), request.getEmail(),request.getMobile(),flight.getOperatingAirlines(),flight.getDateOfDeparture(), flight.getDepartureCity(), flight.getArrivalCity());
		
		
		return reservation;
		
				
	}

}
