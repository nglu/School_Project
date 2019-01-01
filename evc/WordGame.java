package evc;

public class WordGame
{
	public static void main (String[] arg)
	{
		Switch employee1 = new Switch("Susan Myers", 47899, "Accounting","Vice President");
	
		Switch employee2 = new Switch("Mark Jones", 39119);
		employee2.setDepartment("IT");
		employee2.setPosition("Programmer");		

		Switch employee3 = new Switch();
		employee3.setName("Joy Rogers");
		employee3.setIDNumber(81774);
		employee3.setDepartment("Manufacturing");
		employee3.setPosition("Engineer");
		
		System.out.println("Employee #1");
		System.out.println("Name: " + employee1.getName());
		System.out.println("ID Number: " + employee1.getIDNumber());
		System.out.println("Department: " + employee1.getDepartment());
		System.out.println("Position: " + employee1.getPosition());

		System.out.println("\nEmployee #2");
		System.out.println("Name: " + employee2.getName());
		System.out.println("ID Number: " + employee2.getIDNumber());
		System.out.println("Department: " + employee2.getDepartment());
		System.out.println("Position: " + employee2.getPosition());
		
		System.out.println("\nEmployee #3");
		System.out.println("Name: " + employee3.getName());
		System.out.println("ID Number: " + employee3.getIDNumber());
		System.out.println("Department: " + employee3.getDepartment());
		System.out.println("Position: " + employee3.getPosition());
		
	}
}