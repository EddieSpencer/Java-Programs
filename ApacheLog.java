/**
* Programmer: Eddie Spencer	Date Submitted: 12/09/2011
* Instructor: Dr DePasquale	Course: CSC250
*/

package tcnj.spencee1;

import java.text.*;
	
/**
*	The ApacheLog class encapsulates the data that pertains to each ApacheLog Object. A ApacheLog object contains the data of the requestType, baseURL, numBytes, and count. Each of these values are obtained from a scanner in the Driver class that scans through an input file to retrieve this data from an access URL. The ApacheLog class takes this data and stores it into a single ApacheLog object which will be used throughout the Driver class that sorts and categorizes this data in the form of a LinkedBinarySearchTree which is then converted to a hashMap for convenient sorting and processing. It can then be accessed through accessor methods, set through setter methods, as well as a toString method that provides an output of the data written to the output file. The ApacheLog Class implements the Comparable class and sequentially contains a compareTo method used by the ApacheLog Iterator
*/

public class ApacheLog implements Comparable<ApacheLog>
{
	protected String requestType;//This is the declaration of the requestType protected String variable.
	protected String baseURL;//This is the declaration of the baseURL protected String variable.
	protected long numBytes;//This is the declaration of the numBytes protected long variable.
	public int count;//This is the declaration of the count public int variable.


	//The following is the constructor for the ApacheLog class that creates an ApacheLog object with the following parameters.
	//@param String reqType The initialized String value reqType that has been assigned from the accessURL scanner that determines the requestType value.
	//@param String bURL The initialized String value bURL that has been assigned from the accessURL scanner that determines baseURL value.
	//@param long nBytes The initialized long value nBytes that has been assigned from the accessURL scanner that determines numBytes value.
	public ApacheLog(String reqType, String bURL, long nBytes)
	{
		requestType = reqType;
		baseURL = bURL;
		numBytes = nBytes;
		count = 1;
		
	}
	//The following is the toString method of the ApacheLog class which provides the output necessary for the output text file.
	//@return result This is the concatenated String that displays the requestType, baseURL, and numBytes of each unique web page
	public String toString()
	{

		String result = "Request Type: " + requestType + "\tBase URL " + baseURL + "\tNumber of Bytes: " + numBytes + "\tCount: " + count;
		return result;
		
	}
	//The following is the compareTo method of the ApacheLog object that compares alphabetically based upon baseURL
	//@param object The ApacheLog object, object, that is being compared to the current ApacheLog object
	public int compareTo(ApacheLog object)
	{
		ApacheLog compare = (ApacheLog) object;
		
		if (this.getBaseURL().compareTo(compare.getBaseURL()) > 0)
			return 1;
		if (this.getBaseURL().compareTo(compare.getBaseURL()) < 0)
			return -1;

		
			else
			{	
				return 0;
			}

	
	}
	
	//The following is an accessor to retrieve the String value for requestType from the ApacheLog object.
	//@return requestType The String requestType value of the ApacheLog object
	public String getRequestType()
	{
		return requestType;
	}
	//The following is an accessor to retrieve the String value for baseURL from the ApacheLog object.
	//@return baseURL The String baseURL value of the ApacheLog object
	public String getBaseURL()
	{
		return baseURL;
	}
	//The following is an accessor to retrieve the long value for numBytes from the ApacheLog object.
	//@return numBytes The long numBytes value of the ApacheLog object
	public long getNumBytes()
	{
		return numBytes;
	}
	//The following is an accessor to retrieve the int value for count from the ApacheLog object.
	//@return count The int count value of the ApacheLog object
	public int getCount()
	{
		return count;
	}
	//The following is a setter to set the int value of count from the ApacheLog object.
	//@param c The int value c that count will be assigned to.
	public void setCount(int c)
	{
		count = c;
	}
	//The following is a setter to set the String value of requestType from the ApacheLog object.
	//@param rT The String value rT that requestType will be assigned to.
	public void setRequestType(String rT)
	{
		requestType = rT;
	}
	//The following is a setter to set the long value of numBytes from the ApacheLog object.
	//@param nB The long value nB that numBytes will be assigned to.
	public void setNumBytes(long nB)
	{
		numBytes = nB;
	}
	//The following is a setter to set the String value of baseURL from the ApacheLog object.
	//@param bRL The String value bRL that baseURL will be assigned to.
	public void setBaseURL(String bRL)
	{
		baseURL = bRL;
	}
	
}