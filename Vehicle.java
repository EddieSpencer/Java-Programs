/**
* Programmer: Eddie Spencer	Date Submitted: 11/22/2011
* Instructor: Dr DePasquale	Course: CSC250
*/

import java.text.*;

/**
*	The Vehicle class encapsulates the data that pertains to each Vehicle Object. A Vehicle object contains the data of the vehicleNumber, street, direction, arrivalTime, and departureTime. The Vehicle class takes this data and stores it into a single Vehicle object which will be used throughout the Driver class that simulates the traffic intersection. This data can then be accessed through accessor methods, set through setter methods, as well as a toString method that provides a formatted output of the data that simulates the traffic light intersection.  
*/

public class Vehicle
{
	private int vehicleNumber;//This is the declaration of the vehicleNumber private int variable.
	private String street;//This is the declaration of the street private String variable.
	private char direction;//This is the declaration of the direction private char variable.
	private int arrivalTime;//This is the declaration of the arrivalTime private int variable.
	private int departureTime;//This is the declaration of the departureTime private int variable.

	//The following is the constructor for the Vehicle class that creates an Vehicle object with the following parameters.
	//@param int vehicleNumber1 The initialized int value vehicleNumber1 that has been assigned randomly according to the random number generator.
	//@param String street1 The initialized String value street1 that has been assigned according to which street the vehicle is initialized at.
	//@param char direction1 The initialized char value direction1 that has been assigned according to which direction the vehicle is initialized at.
	//@param int arrivalTime1 The initialized int value arrivalTime1 that has been assigned from the clock at the point when the vehicle is initialized.
	//@param int departureTime1 The initialized int value departureTime1 that has been assigned from the clock at the point when the vehicle passes through the intersection.
	public Vehicle(int vehicleNumber1, String street1, char direction1, int arrivalTime1, int departureTime1)
	{
		vehicleNumber = vehicleNumber1;
		street = street1;
		direction = direction1;
		arrivalTime = arrivalTime1;
		departureTime = departureTime1;	
	}	
	//The following is the toString method of the Vehicle class which provides the output of the intersection simulation.
	//@return result This is the concatenated String that displays the clock time, the vehicleNumber, which direction the car moved, and the total waitTime.
	public String toString()
	{
		NumberFormat fmt = NumberFormat.getInstance();//This is the creation of a new NumberFormat object fmt.
		fmt.setMinimumIntegerDigits(2);//This sets the minimum number of integer digits to the formatter to the integer value 2;
		String result;//This is the creation of the String object result which will store the desired output information.
		String waitTime = fmt.format(departureTime - arrivalTime);//This is the creation of the String object waitTime that is the formatted value of the arrivalTime subtracted from the departureTime.
		String depart = fmt.format(departureTime);//This is the creation of the String object depart which is the formatted departureTime.
		if(direction == 'n')//returns the result for northbound traffic.
			return result = "[Time " + depart + "] Vehicle #" + vehicleNumber + " (northbound) moved through intersection. Total wait time " + waitTime + " seconds.";
		if(direction == 's')//returns the result for southbound traffic.
			return result = "[Time " + depart + "] Vehicle #" + vehicleNumber + " (southbound) moved through intersection. Total wait time " + waitTime + " seconds.";
		if(direction == 'e')//returns the result for eastbound traffic.
			return result = "[Time " + depart + "] Vehicle #" + vehicleNumber + " (eastbound) turned right and headed southbound. Total wait time " + waitTime + " seconds.";
		else//returns the result for westbound traffic.
			return result =  "[Time " + depart + "] Vehicle #" + vehicleNumber + " (westbound) turned right and headed northbound. Total wait time " + waitTime + " seconds.";
	}
	//The following is an accessor to retrieve the int value for vehicleNumber from the Vehicle object.
	//@return vehicleNumber The int vehicleNumber value of the Vehicle object
	public int getVehicleNumber()
	{
		return vehicleNumber;
	}
	//The following is an accessor to retrieve the String value for street from the Vehicle object.
	//@return street The String street value of the Vehicle object
	public String getStreet()
	{
		return street;
	}
	//The following is an accessor to retrieve the char value for direction from the Vehicle object.
	//@return direction The char direction value of the Vehicle object
	public char getDirection()
	{
		return direction;
	}
	//The following is a setter to set the int value of arrivalTime from the Vehicle object.
	//@param a The String value a that arrivalTime will be assigned to.
	public void setArrivalTime(int a)
	{
		arrivalTime = a;
	}
	//The following is a setter to set the int value of departureTime from the Vehicle object.
	//@param d The int value d that departureTime will be assigned to.
	public void setDepartureTime(int d)
	{
		departureTime = d;
	}
	//The following is an accessor to retrieve the int value for arrivalTime from the Vehicle object.
	//@return arrivalTime The int arrivalTime value of the Vehicle object
	public int getArrivalTime()
	{
		return arrivalTime;
	}
	//The following is an accessor to retrieve the int value for departureTime from the Vehicle object.
	//@return departureTime The int departureTime value of the Vehicle object
	public int getDepartureTime()
	{
		return departureTime;
	}

	
}