import java.util.HashMap;
import java.util.Map;
/**
	Problems: "Given two strings, write a method to decide if one is a permutation of the other."
	Discussion: if the length of strings differ, then they cannot be premutations of each other.
	What is the O time? It is n as I have to pass throught each string once.
	
	Should have considered sorting both strings and then comparing them! It's less efficient,
	but very elegant and short.
	*/
public class StringPerm
{
	public static void main(String[] args)
	{
		CheckStringPerm("help", "ehlp");
		CheckStringPerm("help", "eh");
	}
	
	public static boolean CheckStringPerm(String one, String two)
	{
		if (one.length() != two.length())
		{
			return false;
		}
		
		Map<Character,Integer> map = new HashMap<>();
		Character c;
		for(int i = 0; i < one.length(); i++)
		{
			c = one.charAt(i);
			if (map.containsKey(c))
			{
				map.put(c, map.get(c) + 1);
			}
			else
			{
				map.put(c, 1);
			}
		}
		
		for(int j = 0; j < two.length(); j++)
		{
			c = two.charAt(j);
			if (map.containsKey(c))
			{
				if (map.get(c) < (-1))
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		return true;
	}
}
