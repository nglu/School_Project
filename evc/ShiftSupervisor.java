package evc;

public class ShiftSupervisor extends Employee
{
	private double salary;
	private double bonus;
	
	public ShiftSupervisor(String n, String num, String date, double s, double b)
	{
		super(n, num, date);
		salary = s;
		bonus = b;
	}
	
	public ShiftSupervisor()
	{
		salary = 0.0;
		bonus = 0.0;
	}
	
	public void setSalary(double s)
	{
		salary = s;
	}
	
	public void setBonus(double b)
	{
		bonus = b;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public double getBonus()
	{
		return bonus;
	}
	
	public String toString()								// need to test if employeeID is valid
	{
		String str = super.toString();
		str += String.format("%nAnnual salary: $%,.2f", salary);
		str += String.format("%nProduction bonus: $%,.2f", bonus);
		
		return str;
	}
}
