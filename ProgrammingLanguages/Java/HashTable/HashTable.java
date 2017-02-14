//Java Collections implements a HashMap
//https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
import java.util.HashMap;
import java.util.Map;

public class HashTable
{
	public static void main(String[] args)
	{
		String bigString = new String("ksjsjdjsidskdjajjsdjsiskdkjajasdkksdjjjasdfghzt");
		Map<Character,Integer> hashTable = new HashMap<>();
		// Map<Character, Integer> names = new TreeMap<>(); //5b
		// Map<Character, Integer> names = new LinkedHashMap<>(); //5c
		//Cannot iterate over the string with for each loop
		for(int i = 0; i < bigString.length()-1; i++)
		{
			Character c = bigString.charAt(i);
			if(hashTable.containsKey(c))
			{
				hashTable.put(c, hashTable.get(c)+1);
			}
			else
			{
				hashTable.put(c, 1);
			}
		}

		for(Map.Entry<Character,Integer> entry : hashTable.entrySet())
		{
			System.out.println(entry.getKey() + "=>" + entry.getValue());
		}
		
		System.out.println(hashTable);
	}
}