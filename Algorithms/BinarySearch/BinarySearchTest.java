import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BinarySearchTest
{
  @Test
  public void testOne() 
  {
    BinarySearch function = new BinarySearch();
	int[] array = {1,2};
	
    assertEquals(-1, function.BinarySearchMethod(array, -5, 0, array.length - 1));
  }
  @Test
  public void testTwo() 
  {
    BinarySearch function = new BinarySearch();
	int[] array = {1,2,3,4,5,6,7,8,9};
	
    assertEquals(0, function.BinarySearchMethod(array, 1, 0, array.length - 1));
  }
  @Test
  public void testThree() 
  {
    BinarySearch function = new BinarySearch();
	int[] array = {1,2,3,4,5,6,7,8,9};
	
    assertEquals(8, function.BinarySearchMethod(array, 9, 0, array.length - 1));
  }
  @Test
  public void testFour() 
  {
    BinarySearch function = new BinarySearch();
	int[] array = {};
	
    assertEquals(-1, function.BinarySearchMethod(array, 10, 0, array.length - 1));
  }
}