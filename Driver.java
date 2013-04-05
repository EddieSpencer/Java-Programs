/**
* Programmer: Eddie Spencer	Date Submitted: 12/09/2011
* Instructor: Dr DePasquale	Course: CSC250
*/


package tcnj.spencee1;

import java.util.*;
import java.net.*;
import java.io.*;
import java.text.*;
import javafoundations.*;

/**
*	The Driver class exists as the functioning basis of creating and sorting data from an accessLog file. To begin the Driver creates a scanner object that directly reads the accessLog file from the webserver. This file is then scanned and searched for the three parameters of an ApacheLog object. To find the first element, requestType the scanner reads in the input file line by line and stores it temporarily as a String object. A secondary scanner is then created to scan this newly formed String object. This scanner looks for the beginning of a single quotation mark, denoting the begining of the requestType, either GET or POST. Utilizing the substring method of the String class, the requestType is stored as the concatenated String from the 1st character to the last character of this String. Once the requestType is found, the scanner moves onto the next part of the String object and saves it into an array. This array is then manipulated using the split method of the String class and is split at the character of a question mark as this denotes the end of the baseURL String. Storing the baseURL as the first element in the splitted array, the scanner advances to find the numBytes requested by the accessLog. This value is stored as a long value if it exists, otherwise it is stored as a 0. Once the requestType, baseURL, and numBytes are stored, an ApacheLog object temp is then created with these elements as its parameters. Before these values are stored to a LinkedBinarySearchTree, they are sorted to ensure that no duplicates exist within the tree. If the LinkedBinarySearchTree already contains such ApacheLog object, instead of adding a duplicate, an internal counter variable within the ApacheLog object is incremented by 1 accordingly. If the LinkedBinarySearchTree does not contain this ApacheLog object, it is added to the tree, and the loop continues itsself until there remain no more elements in the accessLog file read from the webserver. Once the tree is successfully created, the number of unique elements is found by calling the size method of the LinkedBinarySearchTree. In order to efficiently process and access the data in the LinkedBinarySearchTree, a for-each loop is used to create a HashMap. The HashMap contains the stored values of each element in the LinkedBinarySearchTree's getBaseURL method. The baseURL of each ApacheLog object is truncated of its initial forward slash, and stored as a directory location. If the HashMap already contains this directory, an internal count variable is incremented such that duplicate unique directories do not exist. If the directory of an ApacheLog object does not contain a forward slash, the directory is stored within a home directory that contains such elements. After duplicates are accounted for and the count is incremented, the directories are added to the HashMap. The HashMap is then used to create a set of keys used for printing out each individual directory and the number of elements within it. After this, each unique page is listed along with the number of times it was accessed and the total number of bytes contained within it. Finally a for-each loop is used to calculate the total number of bytes in the LinkedBinarySearchTree. This data is then outputted to an output file named treeoutput.txt.
*/
public class Driver
{	
	//This is the main method that essentially drives the program, scans in data, creates a LinkedBinarySearchTree, creates a HashMap, and outputs the data to an outputfile.
	//@throws IOException	This exception is thrown in order for the FileWriter to function.
	public static void main (String [] args) throws IOException
	{
		
		try
		{
		URL accessLog = new URL ("http://s3.amazonaws.com/depasquale/access_log");//This is the creation of URL object accessLog that points to the web address of the accessLog file.	
		Scanner scan = new Scanner (accessLog.openStream());//This is the creation of a Scanner object that will scan the URL object.
		Scanner lineScan;//This is the creation of a Scanner object that will scan through the first line of the input file.
		NumberFormat fmt = NumberFormat.getInstance();//This is the creation of a NumberFormat object used to format the outputted results.
		LinkedBinarySearchTree<ApacheLog> t = new LinkedBinarySearchTree<ApacheLog>();//This is the creation of a LinkedBinarySearchTree of type ApacheLog that will store the ApacheLog objects as they are created.
		FileWriter out = new FileWriter ("treeoutput.txt");//This is the creation of a FileWriter object that is used to write to the output file treeoutput.txt.
		String strRead,addressURL1, addressURL2, requestType, baseURL, numBytes1, directory; //The following is the creation of multiple String objects to be used by the Driver that will be set values later on.
		String [] splitarray, splitarray2;//This is the creation of two String arrays that will be used for the split method later on.
		long numBytes;//This is the creation of the long object to store the number of bytes scanned from the input file.
		ApacheLog temp;//This is the creation of an ApacheLog object that will be addedd to the LinkedBinarySearchTree.
		int loopCount = 1;//This is the creation of a counter variable that will serve as an internal check to the program
		int duplicateCount = 1;//This is the creation of a counter variable that will be incremented if an ApacheLog object already exists in the LinkedBinarySearchTree.
		int directoryCount, keyCount;//This is the creation of two count variables that will be used for the HashMap ensuring that no duplicates exist.

		while (scan.hasNextLine())//This is the main loop of the program that checks to see that the accessLog has a next line to process.
		{
			strRead = scan.nextLine();//This stores in the read String value.
			lineScan = new Scanner (strRead);//This sets the Scanner to scan the read String
			
			while (loopCount == 1)//This is a secondary loop necessary to advance the scanner throughout the read String
			{
				addressURL1 = lineScan.next();//This progresses the Scanner to its next location until a quotation mark is reached

				if (addressURL1.charAt(0) == '"')
				{
					requestType = addressURL1.substring(1, addressURL1.length());//sets the requestType to the concatenated String value
					addressURL2 = lineScan.next();//progresses the Scanner until a question mark is found.
					
					while (addressURL1.charAt(addressURL1.length()-1) != '"')
					{	
						addressURL1 += lineScan.next();
					}
					
					splitarray = addressURL2.split("\\?");//Splits the String at the character question mark
					baseURL = splitarray[0];//Stores the value of baseURl as the first element in the array, essentially before the question mark.

					lineScan.next();//progresses the Scanner until it reaches the number of bytes
					numBytes1 = lineScan.next();	
		
					if (numBytes1.equals("-"))//if the number of bytes has an empty value it is stored as 0.
						numBytes1 = "0";			
					numBytes = Long.parseLong(numBytes1);//Converts the String into a long value		
					
					//Once the requestType, baseURL, and numBytes are stored an ApacheLog object is created.
					temp = new ApacheLog (requestType, baseURL, numBytes);
					//The following checks to ensure that no duplicates exist within the tree before they are added.
					if (t.contains(temp) == true)
					{
						ApacheLog temp2 = t.find(temp);//Finds the location of the duplicate ApacheLog object.
						duplicateCount = temp2.getCount();//Sets the count variable of the object
						temp2.setCount(duplicateCount + 1);//Increments the count variable of the object
						
					}
					else if (t.contains(temp) == false)
					{
						t.add(temp);//Adds the ApacheLog object to the LinkedBinarySearchTree if no duplicate exists
					}
					
					loopCount++;
				}
			}
			loopCount = 1;
		}
		//The following outputs the total number of pages served, using a formatted value of the size of the LinkedBinarySearchTree
		out.write ("Total Number of Pages Served: " + fmt.format(t.size()) + " Unique Pages were Served.");
		
		out.write ("\n");
		out.write ("\n");

		//The following outputs the unique directory sections of the log file as well as the number of pages using a HashMap
		out.write ("List of Unique Sections of Web Server and Number of Pages Residing in Each Section" + "\n");

		HashMap<String, Integer> ApacheLogMap = new HashMap<String, Integer>();//This is the creation of a HashMap that contains the unique directory listings of the LinkedBinaryTree and the number of times that directory is accessed, in this case a String directory and an Integer directory counter that will be implemented below.
		for(ApacheLog temp3 : t)//This is a for-each loop that progresses through the entire LinkedBinarySearchTree and visits each element.
		{
			directory = temp3.getBaseURL();//This sets the value of directory to the baseURL of the ApacheLog object
			directory = directory.substring(1,directory.length());//This truncates the value of directory such that it removes the first forward slash
			
			//If directory still contains a forward slash, it must then be a unique directory and is added to the HashMap of unique directories
			if(directory.contains("/"))
			{
		                splitarray2 = directory.split("/");//Splits the directory at its second forward slash
               			directory = "/" + splitarray2[0];//Saves the value of directory as its unique listing

			}
			else//if there does not exist a secondary forward slash indicitive of a unique directory, it is then added to the home directory
			{
				directory = "/home";//Sets the value of directory to a generic home value
			}
			//To ensure that no duplicates exist within the HashMap of unique directories, the HashMap checks itsself to ensure that it does not already contain this unique directory
			if (ApacheLogMap.containsKey(directory))
			{
				directoryCount = ApacheLogMap.get(directory);//Locates the directoryCount of directory
				directoryCount++;//Increases the value of the directoryCount by 1.				
				ApacheLogMap.put(directory, directoryCount);//Saves the directory and updates its directoryCount accordingly.
			}
			else
			{
				ApacheLogMap.put(directory, 1);//Adds the unique directory to the HashMap with a directory count of 1.
			}

		}
		//After the HashMap has been constructed, a Set is then created that contains the String values of the keys of the HashMap
		Set<String> key = ApacheLogMap.keySet();
		Object [] keys = key.toArray();//Creates an array of the keys to which the HashMap points to.

		Arrays.sort(keys);//Sorts the values of the keys in alphabetical order

		for (Object directoryKey: keys)//This uses a for-each loop to cycle through the Set and output the unique directory listing along with a formatted output of the number of times it was accessed.
		{
			keyCount = ApacheLogMap.get(directoryKey);//Retrieves the value from the HashMap.
			out.write (directoryKey + "\t" + fmt.format(keyCount) + "\n");
		}
	
		out.write ("\n");
		
		//The following outputs a list of each unique page, the number of times it was accessed, as well as the total number of bytes per page
		out.write ("List of Each Unique Page, the Number of Times it was Served, and the Total Number of Bytes Served by Each Page\n");
 
		for (ApacheLog temp4 : t)//This uses a for-each loop to cycle through the LinkedBinarySearchTree to output a formatted result of the baseURL, count, and numBytes
		{
			out.write (temp4.getBaseURL() + "\t" + fmt.format(temp4.getCount()) + "\t" +
							fmt.format(temp4.getNumBytes()) + "\n");
		}
		
		out.write ("\n");
		
		//The following calculates the total number of bytes served by all of the pages in the LinkedBinaryTree
		long totalNumBytes = 0;
		for (ApacheLog temp5 : t)//This for-each loop goes through the LinkedBinarySearchTree and accesses each ApacheLog's number of Bytes and adds it to the total number of Bytes
		{
			totalNumBytes += temp5.getNumBytes();
		}
				
		out.write ("Total Number of Bytes of Data Served by all Pages is:  " + fmt.format(totalNumBytes) + " Bytes.");
		out.close();
		
		
		}
		//The following catches a possible exception for an invalid input URL
		catch (IOException exception)
		{
			System.out.println ("FileWriter Error: URL Does Not Exist, Invalid Output.");
			System.exit(1);
		}
	}
}

			