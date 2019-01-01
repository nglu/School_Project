package practice;

import java.util.*;

public class Practice 
{
	/* Learning Outcome:
	 * 
	 * 							Static vs non-static
	 * 
	 * a) non-static classes can access both static and non static-classes
	 * 	  in the same outer class
	 * b) An instance of non-static inner class cannot be created without
	 * 	  an instance of outer class
	 * 	  ex: OuterClass o = new OuterClass();
	 * 		  NonStaticInnerClass ns = o.new NonStaticInnerClass();
	 * 	  or
	 * 		  OuterClass.NonStaticInnerClass ons = new OuterClass().new NonStaticInnerClass();
	 * 
	 * 
	 * 						Generic Type
	 * 
	 * 
	 * 						Comparable vs Comparator 
	 */
	
/*	public class Movie implements Comparable<Movie>			// without the word "static" I could not create
	{																// a Movie object in the main class. Why?
		String name;
		int year;
		double rating;
		
		// Constructor
		public Movie() {}
		public Movie(String n, int y, double r)
		{
			name = n;
			year = y;
			rating = r;
		}
		
		// getter methods
		public String getName() { return name; }
		public int getYear() { return year; }
		public double getRating() { return rating; }

		@Override
		public int compareTo(Movie other) 
		{
			int result = Integer.compare(year, other.year);
			return result;
		}	
	}
	
	public static void main(String[] args)
	{
		ArrayList<Movie> mv = new ArrayList<Movie>();
		mv.add(new Movie("Harry Potter", 2000, 8.7));
		mv.add(new Movie("Alice in Wonderland", 2008, 7.8));
		mv.add(new Movie("Charlie and the chocolate factory", 2003, 8.0));
				
		Collections.sort(mv);
		
		System.out.println("Movies after sorting : "); 
        for (Movie movie: mv) 
        { 
            System.out.println(movie.getName() + " " + 
                               movie.getRating() + " " + 
                               movie.getYear()); 
        } 
	}	*/
	
	public static void quickSort(int[] list, int first, int last)
	{
		if (last > first)
		{
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}
	}
	
	public static int partition(int[] list,int first ,int last)
	{
		int pivot = list[first];
		int low = first;
		int high = last;
		
		while (high > low)
		{
			while (low <= high && list[low] <= pivot)
				low++;
			while (low <= high && list[high] > pivot)
				high--;
			if (high > low)
			{
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}
		
		while (high > first && list[high] >= pivot)
			high--;
		
		if (pivot > list[high])
		{
			list[first] = list[high];
			list[high] = pivot;
			return high;
		}
		else
			return first;
	}
}
