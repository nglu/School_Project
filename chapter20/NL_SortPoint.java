package chapter20;

import java.util.Comparator;
import java.util.*;


public class NL_SortPoint 
{
	public static void main(String[] args) 
	{
		// Randomly create 100 points
		Point[] points = new Point[100];
		for (int i = 0; i < points.length; i++) 
		{
			points[i] = new Point((double)(Math.random() * 5),
				(double)(Math.random() * 5));
		}

		// Display the points in increasing order of their x-coordinates
		Arrays.sort(points);
		List<Point> list1 = Arrays.asList(points);
		System.out.println("\nPoints in increasing order of their x-coordinates:");
		System.out.println(list1);
		
		
		// Display the points in increasing order of their y-coordinates
		Arrays.sort(points, new CompareY());
		List<Point> list2 = Arrays.asList(points);
		System.out.println("\nPoints in increasing order of their y-coordinates:");
		System.out.println(list2);
		System.out.println();
	}
}

class Point implements Comparable<Point> 
{
	private double x;
	private double y;

	Point() 
	{
		
	}

	// create a point (x, y)
	Point(double x, double y) 
	{
		this.x = x;
		this.y = y;
	}

	public void setX(double x) 
	{
		this.x = x;
	}

	public void setY(double y) 
	{
		this.y = y;
	}

	public double getX() 
	{
		return x;
	}

	public double getY() 
	{
		return y;
	}

	@Override // Override the compareTo method in the Comparable class
	public int compareTo(Point point) 
	{
		if (x == point.getX()) 			// compares y-coordinates if x's are the same
		{
			if (y > point.getY())
				return 1;
			else if (y < point.getY())
				return -1;
			else
				return 0;
		}
		else if (x > point.getX())
			return 1;
		else
			return -1;
	}

	@Override
	public String toString() 
	{
		return "(" + String.format("%.2f", x) + ", " 
			+ String.format("%.2f", y) + ")";
	}
}


// compares two points on their y-coordinates
class CompareY implements Comparator<Point> {

	public int compare(Point p1, Point p2) 
	{
		double x1 = p1.getX();
		double y1 = p1.getY();
		double x2 = p2.getX();
		double y2 = p2.getY();

		if (y1 == y2) 
		{
			if (x1 < x2)
				return -1;
			else if (x1 == x2)
				return 0;
			else
				return 1;
		}
		else if (y1 < y2)
			return -1;
		else 
			return 1;

	}
}

