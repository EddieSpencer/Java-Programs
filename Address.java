/**
* Programmer: Eddie Spencer	Date Submitted: 10/27/2011
* Instructor: Dr DePasquale	Course: CSC250
*/

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import java.net.URL;

/**
*	The Address class encapsulates the data that pertains to the Address of each Member object. A Member object contains an Address object that stores the data of the city, state, streetAddress, and zipCode. The Address class takes this data and stores it into a single Address object.This data can then be accessed through accessor methods, set through setter methods, as well as a toString method that provides a formatted output of the data. 
*/
public class Address
{
	private String city, state, streetAddress; //This is the declaration of the city, state, and streetAddress private String variables.
	private int zipCode; //This is the declaration of the zipCode integer variable.
	

	
	//The following is the constructor for the Address class that creates an Address object with the following parameters provided from the scanner.
	//@param String city1 The initialized String value city1 that has been assigned value by the scanner from the input file.
	//@param String state1 The initialized String value state1 that has been assigned value by the scanner from the input file.
	//@param String streetAddress1 The initialized String value streetAddress1 that has been assigned value by the scanner from the input file.
	//@param int zipCode1 The initialized int value zipCode1 that has been assigned value by the scanner from the input file.	
	public Address(String city1, String state1, String streetAddress1, int zipCode1)
	{
		city = city1;
		state = state1;
		streetAddress = streetAddress1;
		zipCode = zipCode1;
	}
	//The following is the toString method of the Address class which provides the output of the streetAddress, city, state, and formatted zipCode
	//@return result This is the concatenated String of streetAddress, city, state, and the formatted zipCode separated by a tab.
	public String toString()
	{
		
		NumberFormat fmt = NumberFormat.getInstance();//This is the creation of a new NumberFormat object fmt.
		fmt.setMinimumIntegerDigits(5);//This sets the minimum number of integer digits to the formatter to the integer value 5.
		String formZip = fmt.format(zipCode);//This creates a new String formZip that is the original zipCode formatted by fmt's format method.
		formZip = formZip.substring(0,2) + formZip.substring(3);//This reassigns the String formZip to only show the 0th, 1st, 3rd, 4th, and 5th character, thereby outputting a correctly formatted 5 integer zipcode
		String result =  streetAddress + "\t" + city + "\t" + state + "\t" + formZip;
		return result;
	}
	
	//The following is an accessor to retrieve the String value for state from the Address object.
	//@return state The String state value of the Address object
	public String getState()
	{
		return state;
	}
	//The following is an accessor to retrieve the String value for city from the Address object.
	//@return city The String city value of the Address object
	public String getCity()
	{
		return city;
	}
	//The following is an accessor to retrieve the String value for streetAddress from the Address object.
	//@return streetAddress The String streetAddress value of the Address object
	public String  getStreetAddress()
	{
		return streetAddress;
	}
	//The following is an accessor to retrieve the int value for zipCode from the Address object.
	//@return zipCode The int zipCode value of the Address object
	public int getZipCode()
	{
		return zipCode;
	}
	//The following is a setter to set the String value of state from the Address object.
	//@param s The String value s that state will be assigned to.
	public void setState(String s)
	{
		state = s;
	}
	//The following is a setter to set the String value of city from the Address object.
	//@param c The String value c that city will be assigned to.
	public void setCity(String c)
	{
		city = c;
	}
	//The following is a setter to set the String value of streetAddress from the Address object.
	//@param a The String value a that streetAddress will be assigned to.
	public void setStreetAddress(String a)
	{
		streetAddress = a;
	}
	//The following is a setter to set the int value of zipCode from the Address object.
	//@param z The int value z that zipCode will be assigned to.
	public void setState(int z)
	{
		zipCode = z;
	}

}