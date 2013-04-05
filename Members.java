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
*	The Members class encapsulates a large amount of read in personal data for customers of a gym. Each Member has specific criteria that defines it as a Member. There exists a child class of Members called GoldMembers that hold more information that Members as shown in the GoldMember Class. A Member consists of an Address object and a MemberInfo object that repectively store information based upon the Member's address and personal information. It implements the Comparable class such that it is able to use the Arrays.sort() command to sort the Members based on zipCode, state, streetAddress, and SurName.
*/
public class Members implements Comparable
{
	protected Address address; //This is the declaration of an address object of type Address that is protected such that it may be inherited from the GoldMember class.
	protected MemberInfo memInfo; //This is the declaration of a memInfo object of type MemberInfo that is protected such that it may be inherited from the GoldMember class.
	//The following are protected declarations of String objects that are to be used by the Address and MemberInfo classes to create address and memInfo objects as they exist as the parameters to these objects.
	protected String gender, givenName, middleInitial, surName, streetAddress, city, state, emailAddress, telephoneNumber, nationalID, birthday;
	////The following are protected declarations of int objects that are to be used by the Address and MemberInfo classes to create address and memInfo objects as they exist as the parameters to these objects.
	protected int num, zipCode;
	
	
	//The following is an empty constructor for the Members class that assigns the three parameters address, memInfo, and num to null and 0 respectively.
	public Members()
	{
		address = null;
		memInfo = null;
		num = 0;

	}
	
	//The following is the implementation of the Comparable class's compareTo method necessary for sorting the array of members that will be created in the Squale driver class.

	//@param object The compareTo method in the Comparable class requires an object parameter of type Object such that it knows what to compare
	//@return 1, -1, or 0 These numbers are returned according to the following if else statements. 
	//As defined, a 1 is returned if the zipCode is larger than the compared member's zipCode, if the state comes before the compared member's state, if the streetAddress comes before the compared member's streetAddress, and if the surName comes before the compared member's surName. 
	//As defined, a -1 is returned if the zipCode is less than the compared member's zipCode, if the state comes after the compared member's state, if the streetAddress comes after the compared member's streetAddress, and if the surName comes after the compared member's surName. 
	//As defined, a 0 is returned if any of the fields of zipCode, state, streetAddress, or surName are equal.
	public int compareTo(Object object)
	{
		Members compare = (Members) object;
		
		if (address.getZipCode() < compare.address.getZipCode())
			return 1;
		if (address.getZipCode() > compare.address.getZipCode())
			return -1;

		else
		{
			if(address.getState().compareTo(compare.address.getState()) > 0)
				return -1;
			if(compare.address.getState().compareTo(address.getState()) < 0)
				return 1;

			else
			{
				if(address.getStreetAddress().compareTo(compare.address.getStreetAddress()) > 0)
					return 1;
				if(compare.address.getStreetAddress().compareTo(address.getStreetAddress()) < 0)
					return -1;
				else
				{
					if(memInfo.getSurName().compareTo(compare.memInfo.getSurName()) > 0)
						return 1;
					if (compare.memInfo.getSurName().compareTo(memInfo.getSurName()) < 0)
						return -1;
					
					else
						return 0;
				}
			}
		}
	

	}
	//The following is an accessor to retrieve the integer value for num from the Member object.
	//@return num The reference number of any specific Member object.
	public int getNum()
	{
		return num;
	}
	
	//The following is the constructor for the Members class that creates a Members object with the following parameters.
	//@param Address address1 The Address object created after the data has been read in by the scanner from the input file.
	//@param Memberinfo memInfo1 The MemberInfo object created after the data has been read in by the scanner from the input file.
	//@param int num1 The integer num that points to the reference number of a specific member.
	
	public Members(Address address1, MemberInfo memInfo1, int num1)
	{
		address = address1;
		memInfo = memInfo1;
		num = num1;
	}
	
	//The following is the toString method of the Members class
	//@return result The concatenated String of the Address object's toString method and the MemberInfo object's toString method.
	public String toString()
	{
		String result = address.toString() + "	" + memInfo.toString();
		return result;
	}
	
	public Address getAddress()
	{
		return address;
	}

	public MemberInfo getMemberInfo()
	{
		return memInfo;
	}
	
	
}