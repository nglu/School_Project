import java.util.Scanner;

public class Experiment 
{
	public static void main (String[] arg)
	{
		final int NUMQUESTIONS = 20;
		char[] yourAnswer = new char[NUMQUESTIONS];
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter your answer");
		for (int i = 0; i < yourAnswer.length; i++) 
		{
			System.out.print((i+1) + ": ");
			yourAnswer[i] = keyboard.nextLine().charAt(0);
			while ('A'> yourAnswer[i] || yourAnswer[i] > 'D')
			{
				System.out.println("Answer must be A, B, C, or D.");
				System.out.print("Try again: ");
				yourAnswer[i] = keyboard.nextLine().charAt(0);
			}
		}
		
		NLuongDriverLicense test = new NLuongDriverLicense(yourAnswer);
//		test.markTest(yourAnswer);		you don't need this line anymore
		if (test.passed()) // don't have to == true, it already is by default
			System.out.println("You passed the exam.");
		else
			System.out.println("You failed the exam.");
		
		System.out.println("Correct answers: " + test.totalCorrect());
		System.out.println("Incorrect answers: " + test.totalIncorrect());
		System.out.println("Questions you have missed: ");
		
		int[] missAnswer = new int[test.totalIncorrect()];
		missAnswer = test.makeMissedArray(yourAnswer);
		
		for (int i = 0; i < missAnswer.length; i++)
		{
			System.out.print(missAnswer[i] + " ");
		}
	}
}
