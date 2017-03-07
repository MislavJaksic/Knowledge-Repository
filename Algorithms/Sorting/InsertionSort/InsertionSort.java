/**
	Problems: "Implement an insertion sort"
	Discussion: outer loop iterates over elements; inner loop moves backwards;
				the insertion condition is either: the current element is greater then the comparison element
				or the array index is out of bounds
				if the condiction hasn't been met, the comparison element is shifted one place to the right
	*/
public class InsertionSort
{
	public static int[] InsertionSortMethod(int[] array)
	{
		int currentElement;
		int j;
		for(int i = 1; i < array.length; i++)
		{
			currentElement = array[i];
			j = i - 1;
			while(j > (-1) && array[j] > currentElement) //array[j] is the comparison element
			{
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = currentElement;
		}
		return array;
	}
}