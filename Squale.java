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
*	The Squale class exists as the driver of the program that creates a URL object to access the web address where the input data file is located and sequentially creates a Scanner object that reads this URL in order to access data. This data is then passed to its corresponding object class. The data necessary for the Address class is stored in a new Address address that is passed the scanned in data. The data necessary for the MemberInfo class is stored in a new MemberInfo memInfo that is passed the scanned in data. The data necessary for the CreditCard class is stored in a new CreditCard credit that is passed the scanned in data. The Address and MemberInfo objects are then used as the parameters to create a new Member object. The created Member object is then inserted into an array of 40,000 Members. The CreditCard object is used as the parameter of the GoldMember object. Any GoldMember that is created this way is also stored into the Member array. This array is then sorted by zipCode, state, streetAddress, and surName using the Arrays.sort() method. After the sorting takes place, the data of the array is then stored in an output file sortedData using the FileWriter and BufferedWriter. 
*/

public class Squale
{
	//This is the main method that essentially drives the program. 
	//@throws IOException	This exception is thrown in order for the FileWriter to function.
	//@throws MalformedURLException This exception is thrown if the inputted URL does not exist or is erroneous.
	//@throws InputMismatchException This exception is thrown if the scanner detects an input that does not match the desired data type.
	public static void main (String[] args) throws IOException, MalformedURLException, InputMismatchException
	{
		URL url = new URL("https://s3.amazonaws.com/depasquale/personalData.txt");//This declares a new URL url that points to the input web address.
		Scanner scan = new Scanner(url.openStream());//This creates a new Scanner scan that will read through the URL of the input file.
		String gender, givenName, middleInitial, surName, streetAddress, city, state, emailAddress, telephoneNumber, nationalID, birthday, CCType, CCExpires, upsTrackingCode;//This is the declaration of the String data types used to instantiate the Address, MemberInfo, and CreditCard objects.
		long CCNumber;//This is the declaration of the CCNumber as a long, since it is too large to be stored as an int value.
		int num, zipCode, CVV2; //This is the declaration of the int data types used to instantiate the Address, MemberInfo, and CreditCard objects.
		
		scan.useDelimiter("\t"); //This method restricts the scanner to read to the next tab token rather than white space.
		String firstLine = scan.nextLine(); //This uses the scanner to set the first line of the input file to the String firstLine.
			
		Members [] list = new Members [40000];//This creates a new array of type Members called list that has a size of 40000.

		int j = 0; //This is the declaration of a counter variable to cycle through the while loop.
		String[] arr;//This is the creation of an empty array to be used in the while loop.
		String line;//This is the creation of an empty String.

		while (scan.hasNextLine())//This is a while loop that is satisfied if the scanner reads that the input file has a next line.
		{
			line = scan.nextLine();//This assigns line to the next line of the input file.
			arr = line.split("\t");//This command removes the tabs that exist within String line and set the remaining Strings to arr.
							
			if (arr.length > 13)//This if statement is statisfied if the array arr has more than 13 elements, essentially a GoldMember.
			{
				//The following sets each data variable to a specific location in arr, where the scanner has detected its value is stored.
				num = Integer.parseInt(arr[0]);//This parses the String at location 0 to an integer value such that it can be stored as num.
				gender = arr[1];
				givenName = arr[2];
				middleInitial = arr[3];
				surName = arr[4];
				streetAddress = arr[5];
				city = arr[6];
				state = arr[7];
				zipCode = Integer.parseInt(arr[8]);//This parses the String at location 8 to an integer value such that it can be stored as zipCode.
				emailAddress = arr[9];
				telephoneNumber = arr[10];
				nationalID = arr[11];
				birthday = arr[12];
							
				//The following creates a new MemberInfo object memInfo that is being passed the parameters that the scanner has read in.
				MemberInfo memInfo = new MemberInfo(givenName, middleInitial, surName, gender, emailAddress, nationalID, telephoneNumber, birthday);
				//The following creates a new Address object address that is being passed the parameters that the scanner has read in.
				Address address = new Address(city, state, streetAddress, zipCode);

				CCType = arr[13];
				CCNumber = Long.parseLong(arr[14]);//This parses the String at location 14 to an integer value such that it can be stored as CCNumber.
				CVV2 = Integer.parseInt(arr[15]);//This parses the String at location 15 to an integer value such that it can be stored as CVV2.
				CCExpires = arr[16];
				upsTrackingCode = arr[17];
			
				//The following creates a new CreditCard object credit that is being passed the parameters that the scanner has read in.
				CreditCard credit = new CreditCard(CCType, CCExpires, upsTrackingCode, CCNumber, CVV2);
				//Once the Address, MemberInfo, and Credit objects have been created, they are then passed into the parameters of GoldMember to create a new GoldMember object gmember.
				GoldMember gmember = new GoldMember(address, memInfo, credit, num);
				list[j] = gmember;//After gmember is created, it is then set to the jth location of the Members array list[].
				
				
				
			}
			else
			{
				num = Integer.parseInt(arr[0]);//This parses the String at location 0 to an integer value such that it can be stored as num.
				gender = arr[1];
				givenName = arr[2];
				middleInitial = arr[3];
				surName = arr[4];
				streetAddress = arr[5];
				city = arr[6];
				state = arr[7];
				zipCode = Integer.parseInt(arr[8]);//This parses the String at location 8 to an integer value such that it can be stored as zipCode
				emailAddress = arr[9];
				telephoneNumber = arr[10];
				nationalID = arr[11];
				birthday = arr[12];
				//The following creates a new MemberInfo object memInfo that is being passed the parameters that the scanner has read in.	
				MemberInfo memInfo = new MemberInfo(givenName, middleInitial, surName, gender, emailAddress, nationalID, telephoneNumber, birthday);
				//The following creates a new Address object address that is being passed the parameters that the scanner has read in.
				Address address = new Address(city, state, streetAddress, zipCode);
				//Once the Address, MemberInfo, and Credit objects have been created, they are then passed into the parameters of Member to create a new Member object member.
				Members member = new Members(address, memInfo, num);
				list[j] = member;//After member is created, it is then set to the jth location of the Members array list[].
				
				
				
			}

			j++;//This increases j by one to progress the while loop such that the scanner moves to the next line of the input file.
		}

		Arrays.sort(list);//This command uses the sort() method of the Arrays class. It utilizes the compareTo method implemented in the Members class to sort the Members array list by zipCode, state, streetAddress, and finalyl surName. 
		
		//The following is uses to produce the output file of the sorted data. Using the FileWriter object, a text file named sortedData.txt is created in the directory. The BufferedWriter object is used to write the actual data that will be stored in the text file. Using the write() method, anything in the parameters of write will be written to the sortedData.txt
		FileWriter file = new FileWriter("sortedData.txt");//This is the creation of the FileWriter object file that creates sortedData.txt
		BufferedWriter output = new BufferedWriter(file);//This is the creation of the BufferedWriter object output that writes to FileWriter file.
		//The following writes the column headers in the output file on the first line of the sortedData.txt with and then goes to a new line.
		output.write("Number	StreetAddress	City	State	ZipCode	GivenName	MiddleInitial	SurName	EmailAddress	NationalID	TelephoneNumber	Birthday	CCType	CCExpires	UPSTrackingCode	CCNumber	CCExpires" + "\n");
		//The following for loop goes through the 40000 members in the array and prints them out using the Members.toString() method
		for (int k = 0; k < 40000; k++)
		output.write(list[k].getNum() + "	" + list[k].toString() + "\n");	
		//The following uses the BufferedWriter close() method that ends the BufferdWriter output from writing to the file.
		output.close();

	}
	
}