package evc;

import java.util.Scanner;

public class StringOperationsDemo
{
	public static void main(String[] arg)
	{
		String sentence;
		char[] list = {'H', 'o', 'w', ' ', 'n', 'o', 'w', ' ', 
					   'b', 'r', 'o', 'w', ' ', 'c', 'o', 'w' };
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter anything: ");
		sentence = keyboard.nextLine();
		
		// count words
		StringOperations.wordCount(sentence);
	
		// find out the most frequent char
		StringOperations.mostFrequent(sentence);

		// replace "the" with "that"
		StringOperations.replaceSubstring(sentence, "the", "that");
		
		// change the char array to a string
		StringOperations.arrayToString(list);
	}
}
