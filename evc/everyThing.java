package evc;

import java.io.*;
import java.util.Scanner;

public class everyThing 
{
	public static void main (String[] arg)
    {
		int number;
		
		System.out.println("From 2 to 100, the prime numbers are:\n");
		
		for (number = 2; number <= 100; number++)
		{
			isPrime(number);
			displayAnswer(number);
		}
		System.out.println("Data has been written to the file \n");
    }

	public static boolean isPrime(int input)
	{
		boolean outcome = true;

		for (int i = 2; i <= Math.sqrt(input); i++)
		{
			if (input % i == 0)
			{
				outcome = false;
				break;
			}
			else
				outcome = true;
		}
		return outcome;
	}

	public static void displayAnswer(int number)
	{
		if(isPrime(number))
			System.out.println(number);
	}
}
