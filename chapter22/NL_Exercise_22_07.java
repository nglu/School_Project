package chapter22;

// Ngoc Luong
// COMPSCI II - Ex. 22.07


import java.util.Comparator;
import java.util.*;

public class NL_Exercise_22_07 
{
	public static void main(String[] arg)
	{
		Point[] points = new Point[100];
		for (int i = 0; i < points.length; i++)
		{
			points[i] = new Point((double)(Math.random() * 100),
					(double)(Math.random() * 100));
		}
		Pair pair = Pair.getClosestPair(points);
		System.out.println("The closest pair of point is");
		System.out.print(pair.getP1() + " and ");
		System.out.println(pair.getP2());
		System.out.println("The distance between two points is: " + pair.getDistance());
	}
}

// Step 1: Define the classes Point and CompareY in the same way as in Ex 20.4

class Point implements Comparable<Point> 
{
	private double x;
	private double y;

	Point() {}

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
	public int compareTo(Point p) 
	{
		if (x == p.getX()) 			// compares y-coordinates if x's are the same
		{
			if (y > p.getY())
				return 1;
			else if (y < p.getY())
				return -1;
			else
				return 0;
		}
		else if (x > p.getX())
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

/** Step 2: Define a class named Pair with the data fields p1 and p2 to represent
 * two points, and a method named getDistance() that returns the distance
 * between the two points. */

class Pair
{
	private Point p1, p2;
	
	public Pair (Point p1, Point p2)
	{
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public Point getP1()
	{
		return p1;
	}
	
	public Point getP2()
	{
		return p2;
	}
	
	public double getDistance()
	{
		return distance(p1, p2);
	}
	
	// compute the distance between p1 and p2
	public static double distance(Point p1, Point p2)
	{
		return distance(p1.getX(), p1.getY(), p2.getX(), p2.getY());
	}
	// compute the distance between (x1, y1) and (x2, y2)
	public static double distance(double x1, double y1, double x2, double y2)
	{
		return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
	}
	

	
	public static Pair distance(Point[] pointsOrderedOnX, int low, int high, Point[] pointsOrderedOnY)
	{
		if (low >= high)			// zero or one point
			return null;
		else if (low + 1 == high)		// two points
		{
			return new Pair(pointsOrderedOnX[low], pointsOrderedOnX[high]);
		}
		
		int medium = (high + low) / 2;
		Pair pL = distance(pointsOrderedOnX, low, medium, pointsOrderedOnY);
		Pair pR = distance(pointsOrderedOnX, medium + 1, high, pointsOrderedOnY);
		
		double d = 0;
		Pair p = null;
		
		if (pL == null && pR == null)
			d = Double.MAX_VALUE;
		else if (pL == null)
		{
			d = pR.getDistance();
			p = pR;
		}
		else if (pR == null)
		{
			d = pL.getDistance();
			p = pL;
		}
		else
		{
			d = Math.min(pR.getDistance(), pL.getDistance());
			if (pL.getDistance() <= pR.getDistance())
				p = pL;
			else
				p = pR;
		}
		
		// obtain stripL and stripR
		ArrayList<Point> stripL = new ArrayList<Point>();
		ArrayList<Point> stripR = new ArrayList<Point>();
		  for (int i = 0; i < pointsOrderedOnY.length; i++) 
		  {
			  if ((pointsOrderedOnY[i].getX() <= pointsOrderedOnX[medium].getX()) &&
					  (pointsOrderedOnY[i].getX() >= pointsOrderedOnX[medium].getX() - d))
			  {
				  stripL.add(pointsOrderedOnY[i]);
			  }
			  else
			  {
				  stripR.add(pointsOrderedOnY[i]);
			  }
		  }
		 
		// find the closet pair for a point in stripL and points in stripR
		double dd = d;
		int r = 0;
		for (int i = 0; i < stripL.size(); i++)
		{
			while (r < stripL.size() && stripL.get(i).getY() > stripR.get(r).getY() + d)
				r++;
			// compare a point in stripL with points in stripR
			int r1 = r;
			while (r1 < stripR.size() && stripR.get(r1).getY() <= stripL.get(i).getY() + d)
			{
			    if (dd > distance(stripL.get(i), stripR.get(r1))) 
			    {
			    		dd = distance(stripL.get(i), stripR.get(r1));
			    		p.p1 = stripL.get(i);
			    		p.p2 = stripR.get(r1);
			    }
			    r1++;
			}
		}
		return p;
	}
		
	// return the distance of the closest pair of points
	public static Pair getClosestPair(Point[] points) 
	{
		java.util.Arrays.sort(points);
		Point[] pointsOrderedOnY = points.clone();
		java.util.Arrays.sort(pointsOrderedOnY, new CompareY());
		return distance(points, 0, points.length - 1, pointsOrderedOnY);
	}
	
	// return the distance of the closest pair of points
	public static Pair getClosestPair(double[][] points)
	{
		Point[] points2 = new Point[points.length];
		for (int i = 0; i < points.length; i++) 
		{
		   points2[i] = new Point(points[i][0], points[i][1]);
		}
		  return getClosestPair(points2);
	}

}
