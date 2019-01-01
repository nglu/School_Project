package chapter13;

/**
NGOC T NGUYEN LUONG
Ex 13.1
COMPSCI II
09/11/2018
*/

import java.util.Scanner;
import java.lang.Math;

// abstract class
abstract class GeometricObject
{
	  private String color = "white";
	  private boolean filled;
	  private java.util.Date dateCreated;

	  protected GeometricObject()
	  {
		  dateCreated = new java.util.Date();
	  }
	  
	  protected GeometricObject(String color, boolean filled)
	  {
		  dateCreated = new java.util.Date();
		  this.color = color;
		  this.filled = filled;
	  }

	  public String getColor()
	  {
		  return color;
	  }

	  public void setColor(String color)
	  {
		  this.color = color;
    }

	  public boolean isFilled()
	  {
		  return filled;
	  }

	  public void setFilled(boolean filled)
	  {
		  this.filled = filled;
	  }

	  public java.util.Date getDateCreated()
	  {
		  return dateCreated;
	  }

	  public String toString()
	  {
		  return "created on " + dateCreated + "\ncolor: " + color + 
				  " and filled: " + filled;
	  }

	  public abstract double getArea();

	  public abstract double getPerimeter();
}


// triangle class that extends GeometricObject
class NL_Triangle extends GeometricObject
{
	private double side1, side2, side3;
	private String color;
	private boolean filled;
		
	//default constructor
	public NL_Triangle()
	{
		side1 = 0;
		side2 = 0;
		side3 = 0;
		color = "clear";
		filled = false;
	}
	
	public NL_Triangle(double s1, double s2, double s3, String col, boolean status)
	{
		side1 = s1;
		side2 = s2;
		side3 = s3;
		color = col;
		filled = status;
	}
	
	public double getArea()
	{
		double p = getPerimeter() / 2;
		double area = p * (p-side1) * (p-side2) * (p-side3);
		return area = Math.sqrt(area);
	}
	
	public double getPerimeter()
	{
		return side1 + side2 + side3;
	}
	
	public String toString()
	{
		setColor(color);
		setFilled(filled);
		return ("\nArea: " +getArea() +
				"\nPerimeter: " + getPerimeter() +
				"\nColor: " + getColor() +
				"\nFilled: " + isFilled()); 
	}
}


public class NL_TriangleDemo
{
	public static void main(String[]args)
	{
		double s1, s2, s3;
		String color;
		char ans;
		boolean status = false;
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the length of the 1st side: ");
		s1 = keyboard.nextDouble();
		System.out.print("Enter the length of the 2nd side: ");
		s2 = keyboard.nextDouble();
		System.out.print("Enter the length of the 3rd side: ");
		s3 = keyboard.nextDouble();
		keyboard.nextLine();

		System.out.print("Enter a color: ");
		color = keyboard.nextLine();
		do
		{
			System.out.print("Is the triangle filled (Yes/No)? ");
			ans = keyboard.nextLine().charAt(0);
			if (ans == 'y' || ans == 'Y')
				status = true;
			else if (ans == 'n' || ans == 'N')
				status = false;
			else
				System.out.println("Please answer [Y] or [N]");
		}
		while (ans != 'y' && ans != 'Y' && ans != 'n' && ans != 'N');
		
		NL_Triangle tri = new NL_Triangle(s1,s2,s3,color,status);
		System.out.print(tri);
	}
}
