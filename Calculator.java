/**
* Programmer: Eddie Spencer	Date Submitted: 10/4/2011
* Instructor: Dr DePasquale	Course: CSC250
*/

import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;

//The Calculator class represents a simplistic calculator that reads input from a file and processes the provided computations.

public class Calculator
{
	public static void main (String[] args) throws IOException //Used to catch FileNotFoundException within the Scanner
	{
		int commands = 0; //Determines the number of line commands that the program will read and compute.
		int counter = 0; //A counter variable that will be used for the while loop to read through the input file.
		String operation; //Determines which command will be computed from the input file.
		Scanner fileScan; //Scanner variable that will be used multiple times to read through the file for commands and values.
		
		fileScan = new Scanner (new File("calculator.txt")); //Allows scanner to read the input file.
		DecimalFormat fmt = new DecimalFormat ("0.000"); //Initial decimal formatting of three decimal places.

		commands = fileScan.nextInt(); //Sets commands variable to the number of lines read in from the file.

		while (counter < commands && fileScan.hasNext()) //While loop that returns true if the scanner has another token in its input.
		{
			operation = fileScan.next(); //Sets operation variable to the next String token in the file preparing to be computed each time
							//the loop is run.
				//Preceding if statements use the String operation .equals() to compare String literal values.
				if(operation.equals("precision")) //Sets the precision of the calculation to a specific value
								//for all subsequent calculations and returns no output.
				{
					int num1 = new Integer(fileScan.nextInt());
					fmt.setMaximumFractionDigits(num1); //Overrides the initial value of fmt to the specific value in the file.

				}
				
				if (operation.equals("+")) //This line is executed if the operation variable is an addition sign.
								//It then adds the values of two double values and returns double value sum.
				{
					double num1 = fileScan.nextDouble();
					double num2 = fileScan.nextDouble();
					double num3 = num1 + num2;
					System.out.println (operation + " " + num1 + " " + num2 + " = " + fmt.format(num3));
				}
				
				if (operation.equals("-")) //This line is executed if the operation variable is a subtraction sign.
								//It subtracts the values of two double values and returns double value result.
				{
					double num1 = fileScan.nextDouble();
					double num2 = fileScan.nextDouble();
					double num3 = num1 - num2;
					System.out.println (operation + " " + num1 + " " + num2 + " = " + fmt.format(num3));
				}
				
				if (operation.equals("sin")) //This line is executed if the operation variable is the sine operation.
								//It computes the sine of a degree integer and returns the rounded double value in degrees.
				{
					int sin1 = fileScan.nextInt();
					int sin2 = sin1;

					if (sin1 > 360)	//The preceding if statements are used to calculate a reference angle of the value if necessary.
					{
						while (sin1 > 360)
							sin1 -= 360;
					}
					
					if (sin1 < -360)
					{
						while (sin1 < 360)
							sin1 += 360;			
					}
					//The following line converts the value to radians to operate Math.sin() method.
					double sin = Math.sin(Math.toRadians(sin1)); 
					System.out.println(operation + " " + sin2 + " = " + fmt.format(sin));
				}
				
				if (operation.equals("sqrt")) //This line is executed if the operation variable is the square root operation.
							// It calculates the square root of a double and returns the rounded double value
				{
					double sqrt1 = fileScan.nextDouble();
					if (sqrt1 >= 0) //This avoids a negative input value.
					{
						double sqrt = Math.sqrt(sqrt1);
						System.out.println(operation + " " + sqrt1 + " = " + fmt.format(sqrt));
					}
				}
				
				if (operation.equals("power")) //This line is executed if the operation variable is the power operation.
							// It calculates the value of num1 raised to the num2 power and returns double value.
				{
					double num1 = fileScan.nextDouble();
					double num2 = fileScan.nextDouble();
					double num3 = Math.pow(num1, num2);
					System.out.println (operation + " " + num1 + " " + num2 + " = " + fmt.format(num3));
					
				}

				if (operation.equals("*")) //This line is executed if the operation variable is the multiplication operation.
								//It multiplies the values of two doubles and returns the double value product.
				{
					double num1 = fileScan.nextDouble();
					double num2 = fileScan.nextDouble();
					double num3 = num1 * num2;
					System.out.println (operation + " " + num1 + " " + num2 + " = " + fmt.format(num3));
				}
			
				if (operation.equals("/")) //This line is executed if the operation variable is the division operation.
								// It divides the values of two doubles and returns the double value quotient.
				{
					double num1 = fileScan.nextDouble();
					double num2 = fileScan.nextDouble();
					if (num2 != 0) //This if statement avoids a divide by zero error.
					{
						double num3 = num1 / num2;
						System.out.println (operation + " " + num1 + " " + num2 + " = " + fmt.format(num3));
					}
				}
				
				if (operation.equals("%")) //This line is executed if the operation variable is the modulus operation.
								// It calculates the modulus division of two integers and returns the result.
				{
					int num1 = fileScan.nextInt();
					int num2 = fileScan.nextInt();
					if (num2 != 0) //Avoids a divide by zero error
					{
						int num3 = num1 % num2;
						System.out.println (operation + " " + num1 + " " + num2 + " = " + fmt.format(num3));
					}
				}

				if (operation.equals("n!")) //This line is executed if the operation variable is the factorial operation.
							//It calculates the factorial of a non negative long and returns the computed factorial result.
				{
					long num1 = fileScan.nextInt();
					if (num1 >= 0)
					{
					long factorial = 1;
					for (long count = 1;  count <= num1; count++)
					{
						factorial *= count;
					}
					System.out.println (operation + " " + num1 + " = " + factorial);
					}
				}
				
				if (operation.equals("min")) //This line is executed if the operation variable is the minimum value operation.
					//This creates an integer array of variable max length. It prints out each element of the array in the order they
					//were scanned in. It then sorts the values from lowest to highest
					//and returns the lowest integer value in the array.
				{
					int max = fileScan.nextInt();
					int[] numbers = new int[max];
					for (int i = 0; i < max; i++)
					{
						numbers[i] = fileScan.nextInt();
					}	
					System.out.print(operation + " ");
					for(int i=0;i<numbers.length;i++)
					System.out.print(numbers[i] + " ");
					Arrays.sort(numbers);	
					System.out.println(" = " + numbers[0]);
					
				}
				
				if (operation.equals("round")) //This line is executed if the operation variable is the round operation.
								//It returns the closest integer value to the double value provided.
				{
					double num1 = fileScan.nextDouble();
					int num2 = (int)(Math.round(num1));
					System.out.println(operation + " " + num1 + " = " + num2);
									
				}
				
				else
				operation = fileScan.nextLine(); //This line is executed if there are any erroneous commands presented in the input file.
								//It tells the scanner to go to the next line and disregard the erroneous command while 
								//still counting this towards the total command count it first calculated before the loop.
				
			counter++; //This counter variable is used to keep the bounds of the while loop true 
					//until all commands have been read and computed.
			
		}
	}

	
}