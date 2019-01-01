package arrays;

import java.util.Scanner;

public class PassArray 
{
	public static void main (String[] args)
	{
		final int ARRAY_SIZE = 4;
		int[] numbers = new int[ARRAY_SIZE];
		
		getValue(numbers);
		System.out.print("Here are the numbers that you entered:");
		showArray(numbers);
	}
	
	private static void getValue(int[] array) // why is this one private? the getMethod are usually private?
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter a series of " + array.length + " numbers.");
		for (int i = 0; i < array.length; i++)
		{
			System.out.print("Enter number " + (i + 1) + ": ");
			array[i] = keyboard.nextInt();
		}
	}
	
	public static void showArray(int[] array) // why the other method is private but this one is public
	{
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
	}
}
