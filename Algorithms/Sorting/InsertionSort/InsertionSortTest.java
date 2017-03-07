import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class InsertionSortTest
{
  @Test
  public void testOne() 
  {
    InsertionSort function = new InsertionSort();
	int[] array = {5,3,2,2,1};
	int[] result = {1,2,2,3,5};
    assertArrayEquals(result, function.InsertionSortMethod(array));
  }
  @Test
  public void testTwo() 
  {
    InsertionSort function = new InsertionSort();
	int[] array = {3,4,1,2};
	int[] result = {1,2,3,4};
    assertArrayEquals(result, function.InsertionSortMethod(array));
  }
  @Test
  public void testThree() 
  {
    InsertionSort function = new InsertionSort();
	int[] array = {};
	int[] result = {};
    assertArrayEquals(result, function.InsertionSortMethod(array));
  }
}