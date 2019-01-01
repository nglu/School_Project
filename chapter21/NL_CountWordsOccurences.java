package chapter21;

//Ngoc Luong
//COMPSCI II - Ex. 21.08

import java.util.*;
import java.io.*;

public class NL_CountWordsOccurences 
{
	public static void main(String[] args) throws Exception
	{
		if (args.length != 1)
		{
			System.out.println("Usage: java NL_CountWordsOccurences [textfilename]");
			System.exit(1);
		}

		File file = new File(args[0]);
		if (!file.exists()) 
		{
			System.out.println("The file " + args[0] + " does not exists.");
			System.exit(1);
		}

/**				
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file: ");
		String filename = input.nextLine(); 
		
		File file = new File(filename);
*/		
		
		// create a TreeMap to hold words as key and count as value
		Map<String, Integer> map = new TreeMap<>();
			
		try ( Scanner text = new Scanner(file);
		) {
			while (text.hasNext())
			{
				// split text into array of words
				String[] words = text.nextLine().split("[ \n\t\r.,;:!?\'\"()]");

				for (int i = 0; i < words.length; i++)
				{
					String key = words[i].toLowerCase();
					if (key.length() > 0 && Character.isLetter(key.charAt(0)))
					{
						if (!map.containsKey(key))
							map.put(key, 1);
						else
						{
							int value = map.get(key);
							value++;
							map.put(key, value);
						}
					}
				}
			}
			text.close();
			// put all answers into a set
			Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
			for (Map.Entry<String, Integer> entry: entrySet)
				System.out.println(entry.getKey() + "\t\t" + entry.getValue());	
		}
	}
}
