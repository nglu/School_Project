package evc;

public class FuelGauge 
{
	private int currentFuel;

	public FuelGauge(int fuel)
	{
		currentFuel = fuel;
	}
	
	// copy method
	public FuelGauge(FuelGauge object)
	{
		currentFuel = object.currentFuel;
	}
	
	// get fuel
	public int getFuel()
	{
		return currentFuel;
	}
	
	// increment
	public void fillingFuel()
	{
		if (currentFuel < 15)
			{
				currentFuel ++;
				System.out.println("Your fuel level is: " +
									getFuel());
			}
		else
			System.out.println("Your tank is full.");
	}
	
	// decrement
	public void usingFuel()
	{
		if (currentFuel > 0)
			currentFuel --;
		else
			System.out.println("Your tank is empty.");
	}
	
	// toString
	public String toString()
	{
		String str = "Fuel: " + currentFuel + " gallon(s)";
		return str;
	}
}
