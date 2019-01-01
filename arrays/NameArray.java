package arrays;

import java.util.Scanner;

// This is a modification of SearchArray

public class NameArray 
{
	public static void main(String[] args)
	{
		String[] names = new String[5];
		String search;
		int results;
		
		Scanner keyboard = new Scanner(System.in);
		
		for (int i = 0; i < names.length; i++)
		{
			System.out.print("Enter name no." + (i + 1) + ": ");
			names[i] = keyboard.nextLine();
		}
		
		System.out.println();
		System.out.print("Enter the name you are searching for: ");
		search = keyboard.nextLine();
		System.out.println();

		results = sequentialSearch(names, search);
		
		if (results == -1)
		{
			System.out.println("The name " + search + " is not on your list.");
		}
		else
		{
			System.out.println(search + " is at no." + (results +1));
		}
	}
	
	// the return value is still int, not String
	public static int sequentialSearch(String[] array, String word)
	{
		boolean found = false;
		int i = 0;
		int flag = -1;
		
		while (!found && i < array.length)
		{
			if (array[i].equals(word))
			{
				found = true;
				flag = i;
			}
			i++;
		}
		return flag;
	}
}
