//Use a resizable array ArrayList from Java Collections:
//https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
import java.util.ArrayList;

public class Arrays
{
	public static void main(String[] args)
	{
		int n = 10;
		//Declare an array of unknown size that will hold doubles
		double[] a;
		//a = {0.0, 0.0, 0.0} //-> cannot do that!
		//Assign a double array object size n
		//Once decided, the array size cannot be changed
		a = new double[n];
		//Initialise an array by assigning a value to each element
		for (double member : a)
		{
			member = 0.0;
		}
		//Equal to all of the above
		double[] b = new double[n]; 
		//Assign values and size at declaration
		double c = {0.0, 0.01, 0.002}; 
		
		//Access an element
		System.out.println(a[0]); //-> 0.0
		//Change an element
		a[0] = 1.5;
		System.out.println(a[0]); //-> 1.5
		//Array length is stored in a constant called length
		System.out.println(a.length); //-> 10

		//Java Collection, ArrayList: resizeable array
		ArrayList<Integer> d = new ArrayList<Integer>();
		//Add an element
		d.add(1);
		d.add(22);
		//Display an element's value
		System.out.println(d.get(1)); //-> 22
		//Pop the last element
		System.out.println(d.remove(d.size() - 1)); //-> 22
		//Set an element to a value
		d.set(0, 5);
		System.out.println(d.get(0)); //-> 5
	}
}