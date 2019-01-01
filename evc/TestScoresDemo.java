package evc;

public class TestScoresDemo 
{
	public static void main (String[] arg)
	{
		double[] badScores = {86, 90, 93, 102, 89};
		double[] goodScores = {100, 84, 91, 97, 88};
		
		System.out.println("Bad Score");
		try
		{
			TestScores bad = new TestScores(badScores);
			System.out.println("The average of the bad score is " + bad.getAverage());			
		}
		catch (InvalidTestScore e)
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println("\nGood Score");
		try
		{
			TestScores good = new TestScores(goodScores);
			System.out.println("The average of the good score is " + good.getAverage());
		}
		catch (InvalidTestScore e)
		{
			System.out.println(e.getMessage());
		}
	}
}
