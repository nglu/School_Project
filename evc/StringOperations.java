package evc;

public class StringOperations
{
	// word count
	public static void wordCount(String input)
	{
		String[] tokens = input.split(" ");
		System.out.printf("Number of words in \"%s\" is %d\n", input ,
						tokens.length);
	}
	
	// array to string
	public static void arrayToString(char[] input)
	{
		System.out.println(String.valueOf(input));
	}
	
	// most frequent character
	public static void mostFrequent(String input)
	{
		char[] array = input.toCharArray();	// convert the string to an array
		int count = 1;
		int max = 0;
		int position = 0;
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 1; j < array.length; j++)
			{
				if (array[i] == array [j] && array[i] != ' ')
				{
					count++;
				}
			}
			if(count > max)
			{
				max = count;
				position = i;
			}
			count = 1;
		}
		System.out.printf("Most repeated character: %s\n", array[position]);
	}
	
	// replace
	public static void replaceSubstring(String str1, String str2, String str3)
	{
		if (str2.equals(str3))
			System.out.println(str1);

		// i understand that .replace(ch, ch) but somehow it works 
		String str;
		str = str1.replace(str2, str3);
		System.out.println(str);
	}
}

/*
StringBuffer str = new StringBuffer(str1);
int i = str.indexOf(str2);
while (i != -1)
{
	str.replace(i, i + str2.length(), str3);
}
System.out.println(str);
*/
