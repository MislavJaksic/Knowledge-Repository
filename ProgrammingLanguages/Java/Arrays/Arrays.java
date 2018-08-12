https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html
//Use a resizable array ArrayList from Java Collections:
//https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
import java.util.ArrayList;

public class Arrays {
	public static void main(String[] args) {
		int n = 10;
		//Declare an array of unknown size that will hold doubles
    //Once decided, the array size cannot be changed
		double[] slow;
    //Initialise an array by assigning a value to each element
		//a = {0.0, 0.0, 0.0} //-> cannot do that!
    slow = new double[n];
		for (double member : slow) {
			member = 0.0;
		}
    System.out.println(slow[4]); //-> 0.0
    
		//Equal to all of the above
		double[] fast = new double[n];  //-> sets all to 0.0
    System.out.println(fast[4]); //-> 0.0
		double[] c = {0.0, 0.01, 0.002}; 
		
		//Access and change an element
		slow[0] = 1.5;
		System.out.println(slow.length); //-> 10
    
    String[][] multidimensional = {{"Arrays", "in", "an", "array", "of"},{"of", "different", "sizes"}};

		//Java Collection, ArrayList: resizeable array
		ArrayList<Integer> d = new ArrayList<Integer>();
		d.add(1);
		d.add(22);
		System.out.println(d.get(1)); //-> 22
		//Pop the last element
		System.out.println(d.remove(d.size() - 1)); //-> 22
		//Set an element to a value
		d.set(0, 5);
		System.out.println(d.get(0)); //-> 5
	}
}