public class LoopsAndConditions
{
	public static void main(String[] args)
	{
    int i = 0;
		if (i != 0) { //-> must evaluate to a boolean value
			i = 1;
		}
		else {
			System.out.println("i is 0");
		}
    
    boolean is_prime;
    switch (i) {
      case 1: is_prime = false;
      case 2: is_prime = true;
      default is_prime = false;
    }
    
		int con = 6;
		while (con < 5) {
			System.out.println("Cannot be true");
		}
    do {
      System.out.println("Will execute at least once");
    } while(con < 5)
		
		int[] some_numbers = {1, 22, 333, 4444, 55555};
		for (int i = 0; i < some_numbers.length; i++) {
			System.out.print(some_numbers[i]); //-> 122333444455555
		}
		//Foreach
		for (int number : some_numbers) {
			System.out.print(number); //-> 122333444455555
		}
    
    //Labeled and unlabled break exist, as well as continue and reutrn
	}
}