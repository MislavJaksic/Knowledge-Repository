/**
	Problems: "Implement a method to perform basic string compression using the counts
	of repeated characters. For example, the string aabcccccaaa would become
	a2blc5a3. If the "compressed" string would not become smaller than the original
	string, your method should return the original string."
	Discussion: remember if the current string is the same as the previous one: if yes, then
	keep iterating until the answer is no.
	*/
public class StringComp
{
	public static void main(String[] args)
	{
		System.out.println(StringCompMethod("aabcccccaaa"));
	}
	
	public static String StringCompMethod(String string)
	{
		if (string.length() < 1)
		{
			return string;
		}
		StringBuilder newString = new StringBuilder();
		Character c = string.charAt(0);
		int counter = 0;
		for(int i = 1; i < string.length(); i++)
		{
			counter = counter + 1;
			if (c != string.charAt(i))
			{
				newString.append(c); newString.append(counter);
				c = string.charAt(i);
				counter = 0;
			}
			/*c = string.charAt(i);
			i = i + 1;
			counter = 1;
			while (c == string.charAt(i)) //-> goes out of bounds!!!
			{
				counter = counter + 1;
				i = i + 1;
				if (i > string.length()-1) //there has to be a more elegant solution!
				{
					break;
				}
			}
			newString.append(c); newString.append(counter);*/
		}
		counter = counter + 1;
		newString.append(c); newString.append(counter); //what a mess! Do it again sometimes later!
		if (newString.length() >=  string.length())
		{
			return string;
		}
		return newString.toString();
	}
}