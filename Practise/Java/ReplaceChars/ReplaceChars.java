import java.util.ArrayList;
import java.lang.StringBuilder;
/**
	Problems: "Write a method to replace all spaces in a string with'%20'. You may assume that
	the string has sufficient space at the end of the string to hold the additional
	characters, and that you are given the "true" length of the string. (Note: if implementing
	in Java, please use a character array so that you can perform this operation
	in place.)"
	Discussion: O time is linear; have to trim the whitespaces at the end and front
	*/
public class ReplaceChars
{
	public static void main(String[] args)
	{
		System.out.println(ReplaceCharsMethod("Mr John Smith    "));
	}
	
	public static String ReplaceCharsMethod(String string)
	{
		//String can be converted to a char array
		//String has a method called trim that will delete trailing whitespaces
		//Consider using the StringBuilder
		string = string.trim();
		StringBuilder newString = new StringBuilder();
		Character c;
		//ArrayList<Character> array = new ArrayList<>();
		for (int i = 0; i < string.length(); i++)
		{
			//' ' is not the same as " "
			//' ' is a character!
			c = string.charAt(i);
			if (c == ' ')
			{
				//array.add('%');array.add('2');array.add('0');
				newString.append("%20");
			}
			else
			{
				//array.add(string.charAt(i));
				newString.append(c);
			}
		}
		return newString.toString();//array.toString();
	}
}