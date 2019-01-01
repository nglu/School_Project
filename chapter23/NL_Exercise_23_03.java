package chapter23;

// NGOC LUONG
// COMPS II - Ex.23.03

import java.util.Comparator;

/*(Generic quick sort) Write the following two generic methods using quick sort. *
* The first method sorts the elements using the Comparable interface and the     *
* second uses the Comparator interface.                                          *
*                                                                                *
* public static <E extends Comparable<E>>                                        *
*   void quickSort(E[] list)                                                     *
* public static <E> void quickSort(E[] list,                                     *
*   Comparator<? super E> comparator) */

public class NL_Exercise_23_03 
{
	public static void main(String[] args) 
	{
		// create arrays for sorting
		Integer[] intArray = {-12, 3, 2, 5, 6, 1, -2, 0, 14, 2};
		Double[] doubleArray = {4.3, 3.1, -12.2, 18.5, 6.0, -7.9, 11.7};
		Character[] charArray = {'T', 'a', 'N', 'u', 'E', 'h','O','G','y','N'};
		String[] stringArray = {"Alicia", "Betty", "Susie", "Jill", "Nathaniel", "Danny", "Henry"};
		
		// display the arrays before sorting
		System.out.println("Arrays before sorting:");
		System.out.print("Integer array: "); print(intArray);
		System.out.print("Double array: "); print(doubleArray);
		System.out.print("Character array: "); print(charArray);
		System.out.print("String array: "); print(stringArray);
		System.out.println();
		
		// sort the arrays
		quickSort(intArray);
		quickSort(doubleArray);
		quickSort(charArray);
		quickSort(stringArray);
		
		// display arrays after being sorted
		System.out.println("Arrays after sorting:");
		System.out.print("Integer array: "); print(intArray);
		System.out.print("Double array: "); print(doubleArray);
		System.out.print("Character array: "); print(charArray);
		System.out.print("String array: "); print(stringArray);
		System.out.println();
	}

	public static <E extends Comparable<E>> void quickSort(E[] array) 
	{
		quickSort(array, 0, array.length - 1);
	}
	public static <E extends Comparable<E>> void quickSort(E[] array, int first, int last) 
	{
		if (last > first)
		{
			int pivot = partition(array, first, last);
			quickSort(array, first, pivot - 1);
			quickSort(array, pivot + 1, last);
		}
	}
	public static <E extends Comparable<E>> int partition(E[] array, int first, int last) 
	{
		E pivot = array[first];
		int low = first + 1;
		int high = last;
		
		while (high > low)
		{
			while (low <= high && array[low].compareTo(pivot) <= 0)
				low++;
			while (low <= high && array[high].compareTo(pivot) > 0)
				high--;
			if (high > low)
				swap(array, low, high);
		}
		
		while (high > first && array[high].compareTo(pivot) >= 0)
			high--;
		if (pivot.compareTo(array[high]) > 0)
		{
			array[first] = array[high];
			array[high] = pivot;
			return high;
		}
		else
			return first;
	}
	
	public static <E> void quickSort(E[] array, Comparator <? super E> comparator)
	{
		quickSort(array, 0, array.length - 1, comparator);
	}
	public static <E> void quickSort(E[] array, int first, int last, Comparator <? super E> comparator)
	{
		if (last > first)
		{
			int pivot = partition(array, first, last, comparator);
			quickSort(array, first, pivot - 1, comparator);
			quickSort(array, pivot + 1, last, comparator);
		}
	}	
	public static <E> int partition(E[] array, int first, int last, Comparator <? super E> comparator)
	{
		E pivot = array[first];
		int low = first + 1;
		int high = last;
		
		while (high > low)
		{
			while (low <= high && comparator.compare(array[low], pivot) <= 0) 	// array[low] <= pivot
				low++;
			while (low <= high && comparator.compare(array[high], pivot) > 0)
				high--;
			if(high > low)
				swap(array, low, high);
		}
		
		while (high > first && comparator.compare(array[high], pivot) >= 0)
			high--;
		if (comparator.compare(pivot, array[high]) > 0)
		{
			array[first] = array[high];
			array[high] = pivot;
			return high;
		}

		else
			return first;
	}
	
	// swap method
	public static <E> void swap(E[] array, int object1, int object2)
	{
		E temp = array[object2];
		array[object2] = array[object1];
		array[object1] = temp;
	}
	
	// printing methods
	public static void print(Object[] array)
	{
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] +", ");
		System.out.println();
	}
}
