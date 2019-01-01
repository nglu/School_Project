package chapter23;

public class MergeSort {
	/** The method for sorting the numbers */
	public static void mergeSort(int[] list)
	{
		if (list.length > 1) 
		{
			// Merge sort the first half
			int[] firstHalf = new int[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			mergeSort(firstHalf);
			
			// Merge sort the second half
			int secondHalfLength = list.length - list.length / 2;
			int[] secondHalf = new int[secondHalfLength];
			System.arraycopy(list, list.length / 2,secondHalf, 0, secondHalfLength);
			mergeSort(secondHalf);
			
			// Merge firstHalf with secondHalf into list
			merge(firstHalf, secondHalf, list);
		}
	}
		/** Merge two sorted lists */
	public static void merge(int[] list1, int[] list2, int[] temp) 
	{
		int cur1 = 0; // Current index in list1
		int cur2 = 0; // Current index in list2
		int curTemp = 0; // Current index in temp
		while (cur1 < list1.length && cur2 < list2.length) 
		{
			if (list1[cur1] < list2[cur2])
				temp[curTemp++] = list1[cur1++];
			else
				temp[curTemp++] = list2[cur2++];
		}
		while (cur1 < list1.length)
			temp[curTemp++] = list1[cur1++];
		while (cur2 < list2.length)
			temp[curTemp++] = list2[cur2++];
	}
	
	
		/** A test method */
	public static void main(String[] args) 
	{
		int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		mergeSort(list);
		print(list);
	}
	
	public static void print(int[] l)
	{
		for (int i = 0; i < l.length; i++)
		{
			System.out.print(l[i] + " ");
		}
	}
}

