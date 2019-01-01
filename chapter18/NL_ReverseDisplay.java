package chapter18;

import java.util.Scanner;

/**
NGOC T NGUYEN LUONG
Ex 18.9 + 18.12
COMPSCI II
09/18/2018
*/


public class NL_ReverseDisplay
{
	public static void main(String[]args)
	{
		String word;
				
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter some words: ");
		word = keyboard.nextLine();
		System.out.print("Your reverse words: ");
		reverseDisplay(word);
		System.out.println("\n");
		System.out.println("This is a test line");
	}
	
	public static void reverseDisplay(String value)
	{
		if (value.length() == 1)					// base case
			System.out.println(value);
		else
			reverseDisplay(value, value.length() - 1);
	}
	
	public static void reverseDisplay(String value, int high)
	{
		if (high >= 0)
		{
			System.out.print(value.charAt(high));
			reverseDisplay(value, high - 1);
		}		
	}
}
