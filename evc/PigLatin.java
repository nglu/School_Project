package evc;

import java.util.Scanner;

public class PigLatin 
{
	public static void main(String[] arg)
	{
		String english;
		String pig = "AY";
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter your sentence in English: ");
		english = keyboard.nextLine();
		System.out.println("----- Translating to Pig Latin -----");
		
		String[] englishWords = english.split(" ");					// split the string into an array of words
		
		for(int i = 0; i < englishWords.length; i++)
		{
			String word;
			word = englishWords[i].toUpperCase();
			StringBuilder pigLatin = new StringBuilder(word);			// create a StringBuilder object in order to change the content
			char firstLetter = pigLatin.charAt(0);					// grab the first letter of each word
			
			pigLatin.append(firstLetter);							// add the first letter to the last position
			pigLatin.append(pig);									// add "ay"
			pigLatin.deleteCharAt(0);								// remove the first letter
			System.out.print(pigLatin + " ");
		}		
	}
}
