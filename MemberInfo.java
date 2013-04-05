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
*	The MemberInfo class encapsulates the data that pertains to the MemberInfo object of each Member object. A Member object contains a MemberInfo object that stores the data of the givenName, middleInitial,surName, gender, emailAddress, nationalID, telephoneNumber, and birthday. The MemberInfo class takes this data and stores it into a single MemberInfo object.This data can then be accessed through accessor methods, set through setter methods, as well as a toString method that provides an output of the data. 
*/
public class MemberInfo
{
	//This is the declaration of the givenName, middleInitial, surName, gender, emailAddress, nationalID, telephoneNumber, and birthday private String variables.
	private String givenName, middleInitial, surName, gender, emailAddress, nationalID, telephoneNumber, birthday;
	
	//The following is the constructor for the MemberInfo class that creates an MemberInfo object with the following parameters provided from the scanner.
	//@param String givenName1 The initialized String value givenName1 that has been assigned value by the scanner from the input file.
	//@param String middleInitial1 The initialized String value middleInitial1 that has been assigned value by the scanner from the input file.
	//@param String surName1 The initialized String value surName1 that has been assigned value by the scanner from the input file.
	//@param String gender1 The initialized String value gender1 that has been assigned value by the scanner from the input file.
	//@param String emailAddress1The initialized String value emailAddress1The that has been assigned value by the scanner from the input file.
	//@param String nationalID1 The initialized String value nationalID1 that has been assigned value by the scanner from the input file.
	//@param String telephoneNumber1 The initialized String value telephoneNumber1 that has been assigned value by the scanner from the input file.
	//@param String birthday1 The initialized String value birthday1 that has been assigned value by the scanner from the input file.
	public MemberInfo(String givenName1, String middleInitial1, String surName1, String gender1, String emailAddress1, String nationalID1, String telephoneNumber1, String birthday1)
	{
		givenName = givenName1;
		middleInitial = middleInitial1;
		surName = surName1;
		gender = gender1;
		emailAddress = emailAddress1;
		nationalID = nationalID1;
		telephoneNumber = telephoneNumber1;
		birthday = birthday1;
	}
	//The following is the toString method of the MemberInfo class which provides the output of the givenName, middleInitial, surName, gender, emailAddress, nationalID, telephoneNumber,and birthday.
	//@return result This is the concatenated String of givenName, middleInitial, surName, gender, emailAddress, nationalID, telephoneNumber, and birthday separated by a tab.
	public String toString()
	{
		String result = givenName + "\t" + middleInitial + "\t" + surName+ "\t" + gender+ "\t" + emailAddress + "\t" + nationalID + "\t" + telephoneNumber + "\t" + birthday;
		return result;
	}
	
	//The following is an accessor to retrieve the String value for surName from the MemberInfo object.
	//@return state The String surName value of the MemberInfo object
	public String getSurName()
	{
		return surName;
	}
	//The following is an accessor to retrieve the String value for givenName from the MemberInfo object.
	//@return state The String givenName value of the MemberInfo object
	public String getGivenName()
	{
		return givenName;
	}
	//The following is an accessor to retrieve the String value for middleInitial from the MemberInfo object.
	//@return state The String middleInitial value of the MemberInfo object
	public String getMiddleInitial()
	{
		return middleInitial;
	}
	//The following is an accessor to retrieve the String value for gender from the MemberInfo object.
	//@return state The String gender value of the MemberInfo object
	public String getGender()
	{
		return gender;
	}
	//The following is an accessor to retrieve the String value for emailAddress from the MemberInfo object.
	//@return state The String emailAddress value of the MemberInfo object
	public String getEmailAddress()
	{
		return emailAddress;
	}
	//The following is an accessor to retrieve the String value for nationalID from the MemberInfo object.
	//@return state The String nationalID value of the MemberInfo object
	public String getNationalID()
	{
		return nationalID;
	}
	//The following is an accessor to retrieve the String value for telephoneNumber from the MemberInfo object.
	//@return state The String telephoneNumber value of the MemberInfo object
	public String getTelephoneNumber()
	{
		return telephoneNumber;
	}
	//The following is an accessor to retrieve the String value for birthday from the MemberInfo object.
	//@return state The String birthday value of the MemberInfo object
	public String getBirthday()
	{
		return birthday;
	}
	//The following is a setter to set the String value of surName from the MemberInfo object.
	//@param sN The String value sN that city will be assigned to.
	public void setSurName(String sN)
	{
		surName = sN;
	}
	//The following is a setter to set the String value of givenName from the MemberInfo object.
	//@param gN The String value gN that city will be assigned to.
	public void setGivenName(String gN)
	{
		givenName = gN;
	}
	//The following is a setter to set the String value of middleInitial from the MemberInfo object.
	//@param mI The String value mI that city will be assigned to.
	public void setMiddleInitial(String mI)
	{
		middleInitial = mI;
	}
	//The following is a setter to set the String value of gender from the MemberInfo object.
	//@param g The String value g that city will be assigned to.
	public void setGender(String g)
	{
		gender = g;
	}
	//The following is a setter to set the String value of emailAddress from the MemberInfo object.
	//@param eA The String value eA that city will be assigned to.
	public void setEmailAddress(String eA)
	{
		emailAddress = eA;
	}
	//The following is a setter to set the String value of nationalID from the MemberInfo object.
	//@param nI The String value nI that city will be assigned to.
	public void setNationalID(String nI)
	{
		nationalID = nI;
	}
	//The following is a setter to set the String value of telephoneNumber from the MemberInfo object.
	//@param tN The String value tN that city will be assigned to.
	public void setTelephoneNumber(String tN)
	{
		telephoneNumber = tN;
	}
	//The following is a setter to set the String value of birthday from the MemberInfo object.
	//@param b The String value b that city will be assigned to.
	public void setBirthday(String b)
	{
		birthday = b;
	}
	
}