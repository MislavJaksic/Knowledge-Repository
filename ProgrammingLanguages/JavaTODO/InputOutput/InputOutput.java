//Library for greater input control
import java.util.Scanner;

public class InputOutput
{
	public static void main(String[] args)
	{
		System.out.println(args); //-> random nonsense
		for(int i = 0; i < args.length; i++)
		{
			System.out.println(args[i]); //-> <command_line_arguments>
		}
		
		//Declare and assign a Scanner object that will ask the user for input
		Scanner askForInput = new Scanner(System.in);
		//State expected input
		double number = askForInput.nextInteger(); //-> reads an integer
		System.out.println(number); //-> user's input

		//Formatted string output
		String.format("%s and then %d", "String", 123)
	}
}