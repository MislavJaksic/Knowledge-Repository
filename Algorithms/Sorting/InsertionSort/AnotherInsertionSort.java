import java.util.Arrays;

public class AnotherInsertionSort {
  
  public static void main(String[] args){
		int[] array = {5,4,3,2,1};
    System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(Sort(array)));
	}
  
  public static int[] Sort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      for (int j = i; j > 0; j--) {
        if (array[j - 1] > array[j]) {
          Swap(array, j - 1, j);
        }
      }
    }
    return array;
  }
  
  private static void Swap(int[] array, int a, int b) {
    int sentinel = array[a];
    array[a] = array[b];
    array[b] = sentinel;
  }
}