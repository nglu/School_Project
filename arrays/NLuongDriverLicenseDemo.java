package arrays;

// this one should contains all the totalcorrect, totalincorrect, passed methods
// missedQuestions method to point out which questions you answer wrong

import java.util.Scanner;

public class NLuongDriverLicenseDemo 
{
	public static void main (String[] arg)
	{
		char[] correctAns = {
			'B', 'D', 'A', 'A', 'C', 
			'A', 'B', 'A', 'C', 'D', 
			'B', 'C', 'D', 'A', 'D', 
			'C', 'C', 'B', 'D', 'A'};
		char[] studentAns = new char[20];
		int correct = 0,
			incorrect = 0;
		boolean result = true;
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Type your answers");
		// get the answers from the student & validating them
		for (int i = 0; i < studentAns.length; i++) // can we use enhanced loop here?
		{
			System.out.print((i+1) + ": ");
			studentAns[i] = keyboard.nextLine().charAt(0);
			while ('A'> studentAns[i] || studentAns[i] > 'D')
			{
				System.out.println("Answer must be A, B, C, or D.");
				System.out.print("Try again: ");
				studentAns[i] = keyboard.nextLine().charAt(0);
			}
		}
		
		for (int i = 0; i < correctAns.length; i++) // compare the student's answer to the answer key & count the correct and incorrect number
		{
			if (correctAns[i] == studentAns[i])
				correct += 1;
			else 
				incorrect += 1;
		}
		
		if (passed(result, correct) == true) // call the passed method
			System.out.println("You passed the exam.");
		else
			System.out.println("You failed the exam.");
			
		System.out.println("Correct answers: " + totalCorrect(correct)); // call the totalCorrect method
		System.out.println("Incorrect answers: " + totalIncorrect(incorrect)); // call the totalIncorrect method
		for (int i = 0; i < correctAns.length; i ++)
			System.out.print(makeMissedArray(correctAns, studentAns) + " ");

	}

	public static boolean passed(boolean status, int number) // passed method
	{
		status = true;
		if (number >= 15)
		{
			return status;
		}
		else
			return status = false;
	}
	
	public static int totalCorrect(int number) // totalCorrect method
	{
		return number;
	}
	
	public static int totalIncorrect(int number) // totalIncorrect method
	{
		return number;
	}
	
	public static int[] makeMissedArray(char[] arrayCorrect, char[]arrayAnswer) //remember to check if student make any mistake
	{
		int[] missed = new int[20];
		int k = 0;
			for (int i = 0; i < arrayCorrect.length; i++)
			{
				if (arrayCorrect[i] != arrayAnswer[i])
				{
					missed[k] = i + 1;
					k++;
				}
			}
		return missed;
	}
}


//private void gradeExam() I think this one is the compare thing that we did above, just put it in a method
//private void makeMissedArray() This one is the one that I'm struggling with right now. Wait, VOID, why haven't I thought of that?
// Next time if you're stuck, try void dear

