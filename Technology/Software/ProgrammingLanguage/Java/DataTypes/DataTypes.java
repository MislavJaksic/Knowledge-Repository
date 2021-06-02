import java.lang.String;
import java.lang.StringBuilder;

public class DataTypes {

    public static void main(String[] args) {
        // Primitive data types
        // Declare once, define multiple times
        byte eight_bit_int = 127;
        short sixteen_bit_int = 32767;
        int thirtytwo_bit_int = 999999;
        long sixtyfour_bit_int = 9999999L;
        float thirtytwo_bit_float = 345.45f;
        double sixtyfour_bit_float = 54.6477885544;

        char sixteen_bit_char = 'M';  // -> has to be single quotes
        boolean logic_value = true;
        // there also esists a special value: null
        String string = "Hello\n";  // -> immutable

        // Operators: + - * / %, == || &&, instanceof

        // Expressions - made of variables, operators and method invocations; evaluate to a single value
        // Statements - expression statements, declaration statements and control flow statements

        // Wrappers provide methods to primitive types; immutable; "box" primitives
        Integer int_wrapper = new Integer(20);  // -> equal to Integer.valueof(20);
        // Unboxing (unwrapping)
        System.out.println(int_wrapper.intValue());  // -> 20

        // String is an object, not a primitive type
        String hi_ref_one = new String("Hi");  // -> declare and create a new string object
        String hi_ref_two = new String("Hi");
        String hi_value_one = "Hi";  // -> declares and creates a new string object as well
        String hi_value_two = "Hi";
        // Compare by reference
        System.out.println((hi_ref_one == hi_ref_two));  // -> false
        System.out.println((hi_value_one == hi_value_two));  // -> true
        // Compare by value
        System.out.println(hi_ref_one.equals(hi_ref_two));  // -> true
        System.out.println(hi_value_one.equals(hi_value_two));  // -> true

        System.out.println(hi_ref_one.charAt(0));  // -> H

        // Construct a string
        StringBuilder new_string = new StringBuilder();
        new_string.append('h');
        new_string.append("ello");
        System.out.println(new_string.toString());  // -> hello

        // String formatting
        MessageFormat.format("Hello! My name is {0}.", "Alice");

        // String to number
        // <data_type>.parse<data_type>(<string_name>)
        String string_number = "39.999";
        double double_number = Double.parseDouble(string_number);
        // Casting to integer
        int int_number = (int) double_number;
        // int int_number = Integer.parseInt(string_number);  // -> cannot parse it

        // Number to string
        string_number = Integer.toString(int_number);
        string_number = Double.toString(double_number);

        // Number to char
        int bigZ = 90;
        System.out.println((char) bigZ);  // -> Z
        System.out.println((int) 'A');  // -> 65

        // Upcasting is transforming a reference from a concrete type to a generic Object type
        Integer concrete = new Integer(5);
        Object o = concrete;
        // Downcasting is the opposite of upcasting
        concrete = (Integer) o;
    }
}
