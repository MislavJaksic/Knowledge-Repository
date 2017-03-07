public class test
{
	public static void main(String[] args)
	{
		int[] array = {1,2,3,4};
		Swap(array);
		System.out.println(array[3]);
	}
	
	public static void Swap(int[] array)
	{
		int swapper = array[0];
		array[0] = array[array.length-1];
		array[array.length-1] = swapper;
	}
}