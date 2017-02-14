public class Functions
{	
	public static void main(String[] args)
	{
		int x = 2;
		int n = 10;
		double xTon = nPowerX(x, n);
		System.out.println(xTon); //-> very big number
		
		PassByValue(new Integer(x), new Integer(n));
		System.out.println(x); //-> 2
		System.out.println(n); //-> 10
		
		int sum = sumAll(1, 2, 3, 4, 5);
		
	}
	//Functions are declared as follows:
	//<visibility> <is_static?> <is_final?> <return_type> <function_name>(<parameter_names_and_types>)
	//The line above is called a function signature
	private static final double nPowerX(int x, int n)
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
	private static void PassByValue(Integer x, Integer y)
	{
		Integer swapper = x;
		x = y;
		y = swapper;
	}
	//Variable number of arguments
	//<data_type>... <paramater_name>
	private static int sumAll(int... numbers)
	{
		return 15; //-> fake return
	}
}