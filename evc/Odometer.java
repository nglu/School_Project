package evc;

public class Odometer 
{
	private int currentMileage;
	private FuelGauge car; //remember you haven't innitialized it yet!

	public Odometer(int mileage, FuelGauge object1)
	{
		currentMileage = mileage;
		car = new FuelGauge(object1);	// deep copy
	}
	
	public int getMileage()
	{
		return currentMileage;
	}

	public void countMileage()
	{
		if (currentMileage < 99999)
			currentMileage += 1;
		else
			currentMileage = 0;
	}
	
	public String toString()
	{
		String str = "Mileage: " + currentMileage;
		return str;
	}
}
