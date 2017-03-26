/**
	Problems: "Implement binary search"
	Discussion: divide a sorted array into two with low and high indexes
	*/
public class BinarySearch
{
	public static void main(String[] args)
	{
		int[] array = {1,2,3,4,5,6,7};
		System.out.println(BinarySearchMethod(array, 6, 0, array.length - 1));
	}
	
	public static int BinarySearchMethod(int[] array, int element, int low, int high)
	{
		int middle;
		while(high >= low)
		{
			middle = (high + low)/2;
			if(array[middle] == element)
				return middle;
			if(array[middle] > element)
				high = middle - 1;
			else
				low = middle + 1;
		}
		return (-1);
	}
}