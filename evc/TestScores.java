package evc;

public class TestScores
{
	private double[] score;
	
	public TestScores(double[] array) throws InvalidTestScore
	{
		score = new double[array.length];
		for (int i = 0; i < array.length; i++)
		{
			if (array[i] < 0 || array[i] > 100)
			{
				throw new InvalidTestScore(i+1, array[i]);
			}
			else
			{
				score[i] = array [i];
			}
		}
	}
	
	public double getAverage()
	{
		double sum = 0;
		for (int i = 0; i < score.length; i++)
		{
			sum += score[i];
		}
		return (sum / score.length);
	}
}
