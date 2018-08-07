import java.lang.String;
import java.lang.StringBuilder;

public class AlgebraAndStrings
{
	public static void main(String[] args)
	{
		//Primitive data types
		//Declarations can only be made once
		byte eight_bit_int = 127;
		short sixteen_bit_int = 32767;
		int thirtytwo_bit_int = 999999;
		long sixtyfour_bit_int = 9999999L;
    float thirtytwo_bit_float = 345.45f;
		double sixtyfour_bit_float = 54.6477885544;
		
		char sixteen_bit_char = 'M'; //-> has to be single quotes
		boolean logic_value = true;
    int null_value = null;
    String string = "Hello\n"; //-> immutable
    
    //Operators: + - * / %, == || &&, instanceof
		
		//Wrappers provide methods to primitive types
		//Wrappers are immutable objects
		//Wrapping a primitive is called boxing
		Integer intWrapper = new Integer(20); //-> equal to Integer.valueof(20);
		Character charWrapper = new Character('P');
		Double dWrapper = new Double(0.5);
		//Unboxing (unwrapping)
		System.out.println(intWrapper.intValue()); //-> 20
		
		//String is not a primitive data type, it's an object with its own methods
		String text1 = new String("Hi"); //-> declare and create a new string object
		String text2 = new String("Hi");
		String nonObject1 = "Hi"; //-> declares and creates a new string object as well
		String nonObject2 = "Hi";
		//Compare references
		System.out.println((text1 == text2)); //-> false
		System.out.println((nonObject1 == nonObject2)); //-> true
		//Compare stored data
		System.out.println(text1.equals(text2)); //-> true
		System.out.println(nonObject1.equals(nonObject2)); //-> true
		//Character at position
		System.out.println(text1.charAt(0)); //-> H
		
		//Constructing strings from characters and strings
		StringBuilder newString = new StringBuilder();
		//Add to the end
		newString.append('h'); newString.append("ello");
		System.out.println(newString.toString()); //-> hello
		
		//Transform a string to a number
		//<data_type>.parse<data_type>(<string_name>)
		String sNum = "39.999";
		double dNum = Double.parseDouble(sNum);
		System.out.println(dNum); //-> 39.999
		//Cast a double into an integer
		int iNum = (int) dNum;
		//int iNum = Integer.parseInt(sNum); //-> double cannot be parsed into a string
		System.out.println(iNum); //-> 39
		
		//Transform a number to a string
		sNum = Integer.toString(iNum);
		sNum = Double.toString(dNum);
		System.out.println(sNum); //-> 39.999
		
		//Transform an integer to a character
		int bigZ = 90;
		System.out.println((char) bigZ); //-> Z
		System.out.println((int) 'A'); //-> 65
		
		//Upcasting is transforming a reference from a concrete type to a generic Object type
		Integer concrete = new Integer(5);
		Object o = concrete;
		//Downcasting is opposite of upcasting
		concrete = (Integer) o;
	}
}