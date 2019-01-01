package chapter20;

import java.util.*;
import java.util.Comparator;

public class RedoEx20
{
	public static void main(String[] arg) 
	{
		//create 100 random points
		Points[] point = new Points[100];
		for (int i = 0; i < point.length; i++)
		{
			point[i] = new Points(Math.random()*10,Math.random()*10);				//why do the answer change it to double type?
		}
		
		System.out.println("Displaying points with x-coordinates increasing");
		Arrays.sort(point);														//what is this for?
		List<Points> listX = Arrays.asList(point);								//and what's with this stuff??? why do you have to do this?
		System.out.println(listX);
		
		System.out.println("Displaying points with y-coordinates increasing");
		Arrays.sort(point, new NewCompareY());
		
		System.out.println("");
	}
}

class Points implements Comparable<Points>
{
	private double x, y;
	
	public Points(double num1, double num2)
	{
		x = num1;
		y = num2;
	}
	
	public double getX()
	{
		return x;
	}
	
	public double getY() 
	{
		return y;
	}

	@Override
	public int compareTo(Points pt) 
	{
		if (x > pt.getX())
			return 1;
		else if (x < pt.getX())
			return -1;
		else if (x == pt.getX())
		{
			if(y > pt.getY())
				return 1;
			else if(y < pt.getY())
				return -1;
			else
				return 0;
		}
		else
			return 0;
	}
	
	public String toString()
	{
		return "(" + String.format("%.2f", x) + ", " + String.format("%.2f", y) + ")";
	}
}

class NewCompareY implements Comparator<Points>
{

	@Override
	public int compare(Points pt1, Points pt2)
	{
		double x1 = pt1.getX();
		double x2 = pt2.getX();
		double y1 = pt1.getY();
		double y2 = pt2.getY();
		
		if (y1 > y2)
			return 1;
		else if (y1 < y2)
			return -1;
		else if (y1 == y2)
		{
			if (x1 > x2)
				return 1;
			else if (x1 < x2)
				return -1;
			else
				return 0;
		}
		else
			return 0;
	}
}
