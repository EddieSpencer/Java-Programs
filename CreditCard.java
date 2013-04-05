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
*	The CreditCard class encapsulates the data that pertains to the CreditCard object of each GoldMember object. A GoldMember object contains a CreditCard object that stores the data of the CCType, CCExpires, upsTrackingCode, CVV2, and CCNumber. The CreditCard class takes this data and stores it into a single CreditCard object.This data can then be accessed through accessor methods, set through setter methods as well as a toString method that provides an output of the data. 
*/

public class CreditCard
{
	protected String CCType, CCExpires, upsTrackingCode;//This is the declaration of protected String variables CCType, CCExpires, and upsTrackingCode.
	protected int CVV2;//This is the declaration of the protected int value CVV2.
	protected long CCNumber;//This is the declaration of the protected long value CCNumber.
	
	//The following is the constructor for the CreditCard class that creates an CreditCard object with the following parameters provided from the scanner.
	//@param String CCType1 The initialized String value CCType1 that has been assigned value by the scanner from the input file.
	//@param String CCExpires1 The initialized String value CCExpires1 that has been assigned value by the scanner from the input file.
	//@param String upsTrackingCode1 The initialized String value upsTrackingCode1 that has been assigned value by the scanner from the input file.
	//@param long CCNumber1 The initialized long value CCNumber1 that has been assigned value by the scanner from the input file.	
	//@param int CVV21 The initialized int value CVV21 that has been assigned value by the scanner from the input file.	
	public CreditCard(String CCType1, String CCExpires1, String upsTrackingCode1, long CCNumber1, int CVV21)
	{
		CCType = CCType1;
		CCExpires = CCExpires1;
		upsTrackingCode = upsTrackingCode1;
		CCNumber = CCNumber1;
		CVV2 = CVV21;
	}
	//The following is the toString method of the CreditCard class which provides the output of the CCType, CCExpires, upsTrackingCode, formatted CCNumber, and formatted CVV2.
	//@return result This is the concatenated String of CCType, CCExpires, upsTrackingCode, formatted CCNumber, and formatted CVV2 separated by a tab.
	public String toString()
	{
		NumberFormat fmt = NumberFormat.getInstance();//This is the creation of a new NumberFormat object fmt.
		fmt.setMinimumIntegerDigits(3);//This sets the minimum number of integer digits to the formatter to the integer value 3.
		String formCVV2 = fmt.format(CVV2);//This creates a new String formCVV2 that is the original CVV2 formatted by fmt's format method.
		NumberFormat fmt2 = NumberFormat.getInstance();//This is the creation of a new NumberFormat object fmt2.
		fmt2.setMinimumIntegerDigits(16);//This sets the minimum number of integer digits to the formatter to the integer value 16.
		String formCCNumber = fmt.format(CCNumber);//This creates a new String formCCNumber that is the original CCNumber formatted by fmt's format method.
		formCCNumber = formCCNumber.substring(0,1) + formCCNumber.substring(2,5) + formCCNumber.substring(6,9) + formCCNumber.substring(10,13) + formCCNumber.substring(14,17) + formCCNumber.substring(18,21);//This utilized the String's substring method that reassigns the String formCCNumber to only show the 0th, 2nd, 3rd, 4th, 6th, 7th, 8th, 10th, 11th, 12th, 14th, 15th, 16th, 18th, 19th, and 20th character, thereby outputting a correctly formatted 16 integer CCNumber.
		String result = CCType + "\t" + CCExpires + "\t" + upsTrackingCode + "\t" + formCCNumber + "\t" + formCVV2;
		return result;
	}

	//The following is an accessor to retrieve the String value for CCType from the CreditCard object.
	//@return CCType The String CCType value of the CreditCard object
	public String getCCType()
	{
		return CCType;
	}
	//The following is an accessor to retrieve the String value for CCExpires from the CreditCard object.
	//@return CCExpires The String CCExpires value of the CreditCard object
	public String getCCExpires()
	{
		return CCExpires;
	}
	//The following is an accessor to retrieve the String value for upsTrackingCode from the CreditCard object.
	//@return upsTrackingCode The String upsTrackingCode value of the CreditCard object
	public String getUpsTrackingCode()
	{
		return upsTrackingCode;
	}
	//The following is an accessor to retrieve the String value for CVV2 from the CreditCard object.
	//@return CVV2 The String CVV2 value of the CreditCard object
	public int getCVV2()
	{
		return CVV2;
	}
	//The following is an accessor to retrieve the String value for CCNumber from the CreditCard object.
	//@return CCNumber The String CCNumber value of the CreditCard object
	public long getCCNumber()
	{
		return CCNumber;
	}
	//The following is a setter to set the String value of CCType from the CreditCard object.
	//@param cT The String value cT that city will be assigned to.
	public void setCCType(String cT)
	{
		CCType = cT;
	}
	//The following is a setter to set the String value of CCExpires from the CreditCard object.
	//@param cE The String value cE that city will be assigned to.
	public void setCCExpires(String cE)
	{
		CCExpires = cE;
	}
	//The following is a setter to set the String value of upsTrackingCode from the CreditCard object.
	//@param uT The String value uT that city will be assigned to.
	public void setupsTrackingCode(String uT)
	{
		upsTrackingCode = uT;
	}
	//The following is a setter to set the int value of CVV2 from the CreditCard object.
	//@param cV The int value cV that city will be assigned to.
	public void setCCV2(int cV)
	{
		if(cV > 0)//This checks to make sure the input for CVV2 is not negative.
		CVV2 = cV;
	}
	//The following is a setter to set the long value of CCNumber from the CreditCard object.
	//@param cN The long value cN that city will be assigned to.
	public void setCCNumber(long cN)
	{
		if(cN > 0)//This checks to make sure the input for CCNumber is not negative.
		CCNumber = cN;
	}


}