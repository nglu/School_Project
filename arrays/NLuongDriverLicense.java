package arrays;

public class NLuongDriverLicense
{
	final private int NUMBER = 15;
	private char[] answerKey = {
			'B', 'D', 'A', 'A', 'C', 
			'A', 'B', 'A', 'C', 'D', 
			'B', 'C', 'D', 'A', 'D', 
			'C', 'C', 'B', 'D', 'A'};
	private int correct = 0, incorrect = 0;
	private char[] studentAnswer;

	
	public NLuongDriverLicense(char[] ans)
	{
		studentAnswer = ans; // should make a copy
		char[] copyStudentAnswer = new char[studentAnswer.length];
		for (int i = 0; i < studentAnswer.length; i++)
		{
			copyStudentAnswer[i] = studentAnswer[i];
		}
		markTest(copyStudentAnswer); // pass the copied version
	}
	
	private void markTest(char[] ans) // compare the 2 array & count correct/incorrect ans
	{
		for (int i = 0; i < answerKey.length; i++) 
		{
			if (answerKey[i] == ans[i])
				correct += 1;
			else 
				incorrect += 1;
		}
	}
	
	public boolean passed()
	{
		boolean status = true;
		if (correct >= NUMBER)
		{
			return status;
		}
		else
			return status = false;
	}
	
	public int totalCorrect()
	{
		return correct;
	}
	
	public int totalIncorrect()
	{
		return incorrect;
	}
	
	public int[] makeMissedArray(char[] ans)
	{
		int[] missed = new int[incorrect];
		int k = 0;
		for (int i = 0; i < ans.length; i++)
		{
			if (ans[i] != answerKey[i])
			{
				missed[k] = (i + 1);
				k++;
			}
		}
		return missed;
	}

}