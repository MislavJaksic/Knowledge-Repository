public class Functions
{
	//Declare a constant with final
	//final notes that it is shared by all objects of a class
	final int MAX_NUMBER = 15;
	
	public static void main(String[] args)
	{
		int x = 2;
		int n = 10;
		double xTon = nPowerX(x, n);
		System.out.println(xTon); //-> very big number
		
		int sum = sumAll(1, 2, 3, 4, 5);
		
	}
	//Functions are declared as follows:
	//<visibility> <is_static?> <return_type> <function_name>(<parameter_names_and_types>)
	//The above line is called a function signature
	private static double nPowerX(int x, int n)
	{
		if (n == 0)
		{
			return 1;
		}
		double power = x;
		for(int i = 1; i < n; i++)
		{
			power = power * x;
		}
		return power;
	}
	//Variable number of arguments
	//<data_type>... <paramater_name>
	private static int sumAll(int... numbers)
	{
		return 15; //-> fake return
	}
}