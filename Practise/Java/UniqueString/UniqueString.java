import java.util.Map;
import java.util.HashMap;
/**
	Problems: "Implement an algorithm to determine if a string has all unique characters. What
	if you cannot use additional data structures?"
	Discussion: is the string made up of ASCII strings? If so, then strings which have more
	char then there are ASCII chars can be discarded. I'll assume it is made of UNICODE chars.
	What is the O time? It is linear, n if I can remember all the chars that I've seen before the
	currect char. Hash table has O(1) loopup time. If I may not construct it, then it O(n*n).
	I'll assume the string is in memory.
	
	*/
public class UniqueString
{
	public static void main(String[] args)
	{
		UniqueCharsMap("hello");
		UniqueChars("hello");
	}
	public static boolean UniqueCharsMap(String string)
	{
		Map<Character,Integer> map = new HashMap<>();
		Character c;
		for (int i = 0; i < string.length(); i++)
		{
			c = string.charAt(i);
			//its not getValue(), its get()
			//null pointer exception! The map is empty
			//Use map.get(c) when you know there is a key c in the map
			if (map.containsKey(c))
			{
				return false;
			}
			else
			{
				map.put(c, 1);
			}
		}
		//missing return!
		return true;
	}
	
	public static boolean UniqueChars(String string)
	{
		Map<Character,Integer> map = new HashMap<>();
		Character c;
		for (int i = 0; i < string.length(); i++)
		{
			c = string.charAt(i);
			for (int j = i+1; j < string.length(); j++)
			{
				if (c == string.charAt(j))
				{
					return false;
				}
			}
		}
		return true;
	}
	
}