package arrays;

import java.util.Scanner;

public class LoShuDemo
{
	public static void main (String[] args)
	{
		int[][] square = new int[3][3];
		
		Scanner keyboard = new Scanner(System.in);
		
		for (int row = 0; row < square.length; row ++)
		{
			for (int col = 0; col < square[row].length; col++) // because a row is also considered an array with the length of col
			{
				System.out.print("Enter number in row " + (row + 1) + " column " + (col + 1) + ": ");
				square[row][col] = keyboard.nextInt(); // put the validation in here if needed
			}
		}
		System.out.println();
		
		LoShu game = new LoShu(square);
		System.out.println();
		
		if (game.equalsFifteen())
			System.out.println("This is a magic square!");
		else
			System.out.println("This is not a magic square.");
	}
}

/* 
Validation for input from 1-9, ***** IF NEEDED *****

while (square[row][col] < 1 || square[row][col] > 9)
{
	System.out.println("Lo Shu magic square contains numbers 1 through 9 exactly.");
	System.out.print("Enter number in row " + (row + 1) + " column " + (col + 1) + ": ");
	square[row][col] = keyboard.nextInt();
}
*/
