package arrays;

import java.util.Scanner;

public class Sales
{
	public static void main (String[] args)
	{
		final int ONE_WEEK = 7;
		double[] sa = new double[ONE_WEEK];
		getValues(sa);
	}
	
	public static void getValues(double[] array)
	{
		double input;
		Scanner keyboard = new Scanner(System.in);
		for (int i = 0; i < array.length; i++)
		{
			System.out.print("Enter sales data for day " + (i+1) + ": ");
			array[i] = keyboard.nextDouble();
		}
	}
}
