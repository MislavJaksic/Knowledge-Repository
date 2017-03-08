/**
	Problems: "Implement quick sort"
	Discussion: partition the array with indexes
				partition: pivot is the high element, i is low-1, j is low
						   if pivot is greater then jth element, increase i and swap ith and jth element
						   increase j until high
						   swap i+1th and high-th element
						   return i+1 as the middle element
				divide the array into two with neither array having the middle-th element
	*/
public class QuickSort
{
	public static void main(String[] args)
	{
		int[] array = {2,8,7,1,3,5,6,4};
		QuickSortMethod(array, 0, array.length - 1);
		for (int element : array) System.out.print(element);
	}
	
	public static int[] QuickSortMethod(int[] array, int low, int high)
	{
		if (high > low)
		{
			int middle = Partition(array, low, high);
			QuickSortMethod(array, low, middle - 1);
			QuickSortMethod(array, middle + 1, high);
		}
		return array;
	}
	
	public static int Partition(int[] array, int low, int high)
	{
		int pivot = array[high];
		int i = low - 1;
		int swapper;
		for(int j = low; j < high; j++)
		{
			if(pivot >= array[j])
			{
				i++;
				swapper = array[i];
				array[i] = array[j];
				array[j] = swapper;
			}
		}
		swapper = array[i + 1];
		array[i + 1] = array[high];
		array[high] = swapper;
		
		return (i + 1);
	}
}