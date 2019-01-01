package chapter19;

/**
NGOC T NGUYEN LUONG
Ex 19.9
COMPSCI II
09/25/2018
*/

import java.util.*;

class Sorting_ArrayList
{
	public static <E extends Comparable<E>> void sort(ArrayList<E> list)
	{
		E currentMin;
		int currentMinIndex;
		
		for (int i = 0; i < list.size() - 1; i++)
		{
			// Find the minimum in the ArrayList
			currentMin = list.get(i);
			currentMinIndex = i;
			for (int j = i + 1; j < list.size(); j++)
			{
				if (currentMin.compareTo(list.get(j)) > 0) 
				{
					currentMin = list.get(j);
					currentMinIndex = j;
				}
			}

			// Swap list.get(i) with list.get(currentMinIndex)
			if (currentMinIndex != i)
			{
				list.set(currentMinIndex, list.get(i));
				list.set(i, currentMin);
			}
		}
	}
	
	public static <E> void printList(ArrayList<E> list)
	{
		for (int i = 0; i < list.size(); i++)
		{
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}
}

public class NL_ArrayList
{
	public static void main(String[] args)
	{
	 	// Create a list of Integers
	 	Integer[] intArray = {new Integer(7), new Integer(3), new Integer(11)};
	 	ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(intArray));
	 	
	 	// Create a list of Doubles
	 	Double[] doubleArray = {new Double(2.3), new Double(6.9), new Double(-7.7)};
	 	ArrayList<Double> doubleList = new ArrayList<>(Arrays.asList(doubleArray));
	 		
	 	// Create a list of Characters
	 	Character[] charArray = {new Character('n'), new Character('u'), new Character('G')};
	 	ArrayList<Character> charList = new ArrayList<>(Arrays.asList(charArray));
	 	
	 	// Create a list of Strings
	 	String[] stringArray = {"Kathy", "Sandra", "Martin"};
	 	ArrayList<String> stringList = new ArrayList<>(Arrays.asList(stringArray));
	 	
	 	// Sort the lists
	 	Sorting_ArrayList.sort(intList);
	 	Sorting_ArrayList.sort(doubleList);
	 	Sorting_ArrayList.sort(charList);
	 	Sorting_ArrayList.sort(stringList);
	 
	 	System.out.print("Sorted Integer objects: ");
	 	Sorting_ArrayList.printList(intList);
	 	System.out.print("Sorted Double objects: ");
	 	Sorting_ArrayList.printList(doubleList);
	 	System.out.print("Sorted Character objects: ");
	 	Sorting_ArrayList.printList(charList);
	 	System.out.print("Sorted String objects: ");
	 	Sorting_ArrayList.printList(stringList);
	}
}