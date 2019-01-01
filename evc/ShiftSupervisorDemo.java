package evc;

public class ShiftSupervisorDemo 
{
	public static void main (String[] arg)
	{
		ShiftSupervisor john = new ShiftSupervisor("John Smith","123-A","11-15-2005", 48000, 6500);
		ShiftSupervisor joan = new ShiftSupervisor("Joan Jones", "222-L", "12-12-2005", 55000, 8000);
		
		System.out.println("Here's the first shift supervisor.");
		System.out.println(john);
		System.out.println();
		System.out.println("Here's the second shift supervisor");
		System.out.println(joan);
		System.out.println();
	}
}
