import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class MergeSortTest
{
  @Test
  public void testOne() 
  {
    MergeSort function = new MergeSort();
	int[] array = {5,3,2,2,1};
	int[] result = {1,2,2,3,5};
    assertArrayEquals(result, function.MergeSortMethod(array, 0, array.length - 1));
  }
  @Test
  public void testTwo() 
  {
    MergeSort function = new MergeSort();
	int[] array = {3,4,1,2};
	int[] result = {1,2,3,4};
    assertArrayEquals(result, function.MergeSortMethod(array, 0, array.length - 1));
  }
  @Test
  public void testThree() 
  {
    MergeSort function = new MergeSort();
	int[] array = {};
	int[] result = {};
    assertArrayEquals(result, function.MergeSortMethod(array, 0, array.length - 1));
  }
}