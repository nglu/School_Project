package arrays;

import java.util.Scanner;

// There is a modification of this program named NameArray which inputs are String, not int

public class SearchArray 
{
	public static void main(String[] args)
	{
		int[] tests = new int[5];
		int score;
		int results;
		
		Scanner keyboard = new Scanner(System.in);
		
		for (int i = 0; i < tests.length; i++)
		{
			System.out.print("Enter score of test " + (i + 1) + ": ");
			tests[i] = keyboard.nextInt();
		}
		
		System.out.println();
		System.out.print("Enter the test score you are searching for: ");
		score = keyboard.nextInt();
		System.out.println();

		results = sequentialSearch(tests, score);
		
		if (results == -1)
		{
			System.out.println("You did not score " + score + " on any test.");
		}
		else
		{
			System.out.println("You earned " + score + " on test " + (results +1));
		}
	}
	
	public static int sequentialSearch(int[] array, int number)
	{
		boolean found = false;
		int i = 0;
		int flag = -1;
		
		while (!found && i < array.length)
		{
			if (array[i] == number)
			{
				found = true;
				flag = i;
			}
			i++;
		}
		return flag;
	}
}
