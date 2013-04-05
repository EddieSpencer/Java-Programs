/**
* Programmer: Eddie Spencer	Date Submitted: 10/27/2011
* Instructor: Dr DePasquale	Course: CSC250
*/

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;
import java.net.*;

/**
*	The GoldMember class extends the Members class as it is a child of the Members class. Having said that, any GoldMember object inherits all of the Member object's data and methods as they have been declared protected enabling them to become inheritable. The GoldMember object consists of an Address object and a MemberInfo object just like the Member object, but it also contains a CreditCard object that stores the extra information that differentiates a GoldMember object from a Member object. 
*/

public class GoldMember extends Members
{
	private CreditCard credit; //This is the declaration of a credit object of type CreditCard that is private.
	
	//The following is an empty constructor for the GoldMember class that assigns the credit parameter to null.
	public GoldMember()
	{
		credit = null;
	}

	//The following is the constructor for the GoldMember class that creates a GoldMember object with the following parameters.
	//@param Address address1 The Address object created after the data has been read in by the scanner from the input file.
	//@param Memberinfo memInfo1 The MemberInfo object created after the data has been read in by the scanner from the input file.
	//@param CreditCard credit1 The CreditCard object created after the data has been read in by the scanner from the input file.
	//@param int num1 The integer num that points to the reference number of a specific member.	
	public GoldMember(Address address1, MemberInfo memInfo1, CreditCard credit1, int num1)
	{
		address = address1;
		memInfo = memInfo1;
		credit = credit1;
		num = num1;
	}

	//The following is the toString method of the Members class which includes a super method that calls the Members class toString method.
	//@return result The concatenated String of the Members class toString, which was the concatenated String of the Address object's toString method and the MemberInfo object's toString method, and the CreditCard object's toString method.
	public String toString()
	{
		String result = super.toString() + "	" + credit.toString();
		return result;
	}
}