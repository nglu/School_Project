package programFinal;

import java.util.*;

public class comsci76 
{
	public static void main(String[] args)	
	{
		double min1 = 0;
		double max1 = 99999;
		
		double min2 = 0;
		double max2 = 199999;
		
		Random random = new Random();

		// create a list Original of 0-199999
		double[] original = new double[100000];
		for(int i = 0; i < original.length; i++)
		{
			original[i] = min2 + random.nextDouble()*(max2 - min2);
		}
		
		// create HashSet
		Set<Double> set = new HashSet<>(100000);
		for(int i = 0; i < set.size(); i++)
		{
			set.add(min1 + random.nextDouble()*(max1 - min1));
		}
		// create ArrayList
		List<Double> list = new ArrayList<>(100000);
		for(int i = 0; i < list.size(); i++)
		{
			list.add(min1 + random.nextDouble()*(max1 - min1));
		}
		
		// search if an element in Original is in HashSet
		long setStartTime = System.currentTimeMillis();
		for(int i = 0; i < original.length; i++)
		{
			set.contains(original[i]);
		}
		long setResult = System.currentTimeMillis() - setStartTime;
		System.out.println("Run time for HashSet: " + setResult);
		
		
		// search if an element in Original is in ArrayList
		long arrayStartTime = System.currentTimeMillis();
		for(int i = 0; i < original.length; i++)
		{
			list.contains(original[i]);
		}
		long arrayResult = System.currentTimeMillis() - arrayStartTime;
		System.out.println("Run time for ArrayList: " + arrayResult);

	}
}
