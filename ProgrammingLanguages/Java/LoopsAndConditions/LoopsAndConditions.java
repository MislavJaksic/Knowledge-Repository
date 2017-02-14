public class LoopsAndConditions
{
	public static void main(String[] args)
	{
		//while (false) //-> cannot be stated; unreachable statement error
		int con = 6;
		while (con < 5)
		{
			System.out.println("Cannot be true");
		}
		
		int[] manyNumbers = {1, 22, 333, 4444, 55555};
		for (int i = 0; i < manyNumbers.length; i++)
		{
			System.out.print(manyNumbers[i]); //-> 122333444455555
		}
		//For each array member do the block of code
		for (int number : manyNumbers)
		{
			System.out.print(number); //-> 122333444455555
		}
		
		int i = 0;
		//if i //-> not allowed; number is not a boolean value
		if (i != 0) //-> statement behind if has to be in brackets
		{
			i = 1;
		}
		else
		{
			System.out.println("i is 0");
		}
	}
}