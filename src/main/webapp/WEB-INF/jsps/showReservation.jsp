<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Reservation</title>
</head>
<body>
	<h1>Flight Details</h1>
	
	Flight Number: <br/>
	Operating Airlines: ${flight.operatingAirlines} <br/>
	Departure City: ${flight.departureCity} <br/>
	Arrival City: ${flight.arrivalCity} <br/>
	Date Of Departure: ${flight.dateOfDeparture} <br/>
	Estimated DepartureTime:${flight.estimatedDepature} <br/>
	
	<h1> Enter Passenger Details</h1>
	<form action="compleateReservation" method="post">
	<pre>
		First Name<input type="text" name="firstName"/>
		last Name<input type="text" name="lastName"/>
		Middle Name<input type="text" name="middleName"/>
		Email<input type="text" name="email"/>
		Mobile<input type="text" name="mobile"/>
		<input type="hidden" name="flightId" value="${flight.id}"/>
		
		<h2>Enter the card details</h2>
		Card Number<input type="text" /><br/>
		CVV<input type="text"/><br/>
		Expiry Date<input type="text" /><br/>
		Amount<input type="text"/><br/>
		
		<input type="Submit" value="proceed"/>
		
		
		
	</pre>
	</form>
	
	
</body>
</html>