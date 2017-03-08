import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class QuickSortTest
{
  @Test
  public void testOne() 
  {
    QuickSort function = new QuickSort();
	int[] array = {5,3,2,2,1};
	int[] result = {1,2,2,3,5};
    assertArrayEquals(result, function.QuickSortMethod(array, 0, array.length - 1));
  }
  @Test
  public void testTwo() 
  {
    QuickSort function = new QuickSort();
	int[] array = {8,7,6,5,4,3,2,1};
	int[] result = {1,2,3,4,5,6,7,8};
    assertArrayEquals(result, function.QuickSortMethod(array, 0, array.length - 1));
  }
  @Test
  public void testThree() 
  {
    QuickSort function = new QuickSort();
	int[] array = {};
	int[] result = {};
    assertArrayEquals(result, function.QuickSortMethod(array, 0, array.length - 1));
  }
}