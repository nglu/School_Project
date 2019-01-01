package arrays;

public class SalesData 
{
	private double[] sales; // why don't we innitialize it right now?
	
	//why do we need to copy? I really don't get this part. Wait... I think I'm getting there...
	public SalesData(double[] s)
	{
		sales = new double[s.length];
		for (int i = 0; i < s.length; i++)
			sales[i] = s[i];
	}
	
	//total
	public double getTotal()
	{
		double total = 0.0;
		for (int i = 0; i < sales.length; i++)
		{
			total += sales[i];
		}
		return total;
	}
	//average
	public double getAverage()
	{
		double average = getTotal() / sales.length;
		return average;
	}
	//highest
	public double getHighest()
	{
		double highest = sales[0];
		for (int i = 0; i < sales.length; i++)
		{
			if (sales[i] < sales [i+1])
				highest = sales[i+1];
		}
		return highest;
	}
	//lowest
	public double getLowest()
	{
		double lowest = sales[0];
		for (int i = 0; i < sales.length; i++)
		{
			if (sales[i] > sales [i+1])
				lowest = sales[i+1];
		}
		return lowest;
	}
}
