import java.util.ArrayList;

public class LoShu 
{
	private int[][] table = new int[3][3];
	private final int MAGICNUM = 15;
	ArrayList<Integer> total = new ArrayList<Integer>();
	
	public LoShu(int[][] array)
	{
		table = array;
		totalRow(table);
		totalCol(table);
		totalDiag(table);
	}
	
	private void totalRow(int[][] array)
	{
		for (int r = 0; r < array.length; r++)
		{
			int sumRow = 0;
			for (int c = 0; c < array[0].length; c++)
			{
				sumRow += array[r][c];
			}
			System.out.println("The sum of row " + (r + 1) + " is: " + sumRow);
			total.add(sumRow);
		}
	}
	
	private void totalCol(int[][] array)
	{
		for (int c = 0; c < array[0].length; c++)
		{
			int sumCol = 0;
			for (int r = 0; r < array.length; r++)
			{
				sumCol += array[r][c];
			}
			System.out.println("The sum of column " + (c + 1) + " is: " + sumCol);
			total.add(sumCol);
		}
	}
	
	private void totalDiag(int[][] array)
	{		
		int sumDiag1 = 0;
		for (int r = 0, c = 0; r < array.length; r++, c++)
		{
			sumDiag1 += array[r][c];
		}
		System.out.println("The sum of first diagonal is: " + sumDiag1);
		total.add(sumDiag1);
		
		int sumDiag2 = 0;
		for (int r = 0, c = (array.length - 1); r <  array.length; r++, c--)
		{
			sumDiag2 += array[r][c];
		}
		System.out.println("The sum of second diagonal is: " + sumDiag2);
		total.add(sumDiag2);
	}
	
	public boolean equalsFifteen()
	{
		int i = 0;
		boolean status = true;
		while (i < total.size())
		{
			if (total.get(i) != MAGICNUM)
			{
				status = false;
				i++;
			}			
			else
				i++;
		}
		return status;
	}	
}
