/**
	Problems: "Implement merge sort"
	Discussion: divide an array using indexes until there is only a single element between high and low
				merge step: put half an array into the left stack and the other in the right stack
							both stacks are sorted
							compare stacks until one is empty by keeping track of three indexes
							put the rest of the elements into the array
	*/
public class MergeSort
{
	public final static int SENTINEL = 9999;
	
	public static void main(String[] args)
	{
		int[] array = {6,5,4,3,2,1,0};
		MergeSortMethod(array, 0, array.length - 1);
		for (int element : array) System.out.print(element);
	}
	public static int[] MergeSortMethod(int[] array, int low, int high)
	{
		if (high > low)
		{
			int middle = (high + low)/2;
			MergeSortMethod(array, low, middle);
			MergeSortMethod(array, middle + 1, high);
			//Merge(array, low, middle, high);
			AltMerge(array, low, middle, high);
		}
		return array; //just for testing purposes
	}
	
	public static void Merge(int[] array, int low, int middle, int high)
	{
		int LSize = middle - low + 1 + 1;
		int RSize = high - middle + 1;
		int[] L = new int[LSize];
		int[] R = new int[RSize];
		
		for(int i = 0; i < (LSize - 1); i++)
			L[i] = array[low + i];
		for(int i = 0; i < (RSize - 1); i++)
			R[i] = array[middle + i + 1];
		
		L[L.length - 1] = SENTINEL;
		R[R.length - 1] = SENTINEL;
		
		int i = 0; int j = 0;
		for(int k = low; k <= high; k++)
		{
			if (R[i] >= L[j])
			{
				array[k] = L[j];
				j = j + 1;
			}
			else
			{
				array[k] = R[i];
				i = i + 1;
			}
		}
	}
	public static void AltMerge(int[] array, int low, int middle, int high)
	{
		int LSize = middle - low + 1;
		int RSize = high - middle;
		int[] L = new int[LSize];
		int[] R = new int[RSize];
		
		for(int i = 0; i < LSize; i++)
			L[i] = array[low + i];
		for(int i = 0; i < RSize; i++)
			R[i] = array[middle + i + 1];

		int i = 0; int j = 0; int k = low;
		while(i < RSize && j < LSize)
		{
			if (R[i] >= L[j])
			{
				array[k] = L[j];
				j++;
				k++;
			}
			else
			{
				array[k] = R[i];
				i++;
				k++;
			}
		}
		while(i < RSize)
		{
			array[k] = R[i];
			i++;
			k++;
		}
		while(j < LSize)
		{
			array[k] = L[j];
			j++;
			k++;
		}
	}
}