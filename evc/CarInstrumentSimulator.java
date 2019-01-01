package evc;

import java.util.Scanner;

public class CarInstrumentSimulator 
{
	public static void main(String[] args)
	{
		int innitialFuel,
			innitialMileage;
		final int MPG = 24;
		final int fuelLevel = 15;

		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter your current amount of fuel: ");
		innitialFuel = keyboard.nextInt();
		if (innitialFuel > 15)
		{
			System.out.println("Your maximum capacity is 15");
			innitialFuel = fuelLevel;
		}
		System.out.print("Enter your current amount of mileage: ");
		innitialMileage = keyboard.nextInt();
		System.out.println("");

		FuelGauge yourFuel = new FuelGauge(innitialFuel);
		Odometer yourMile = new Odometer(innitialMileage, yourFuel);
		
		// simulating increment on fuel
		yourFuel.fillingFuel();
		System.out.println("");
		
		int flag = 1;
		while (yourFuel.getFuel() > 0)
		{
			if (flag > MPG)
			{
				yourFuel.usingFuel();
				flag = 1;
			}
			System.out.println(yourMile);
			System.out.println(yourFuel);
			System.out.println("---------------");
			yourMile.countMileage();
			flag++;
		}
		/*
		int flag = 1;
		int count = MPG * yourFuel.getFuel();
		for (int i = 0; i < count; i++)
		{
			if (flag > MPG)
			{
				yourFuel.usingFuel();
				flag = 1;
			}
			flag++;
			System.out.println(yourMile.toString());
			System.out.println(yourFuel.toString());
			System.out.println("---------------");
			yourMile.countMileage();	
		}	*/
	}
}
