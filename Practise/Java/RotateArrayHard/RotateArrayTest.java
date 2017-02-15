import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class RotateArrayTest
{
  @Test
  public void testOne() 
  {
    RotateArray function = new RotateArray();
	int[] picture = {1,2,3,4};
	int[] result = {2,4,1,3};
    assertArrayEquals(result, function.RotateArrayMethod(picture, 2));
  }
  @Test
  public void testTwo() 
  {
    RotateArray function = new RotateArray();
	int[] picture = {1,2,3,4,5,6,7,8,9};
	int[] result = {3,6,9,2,5,8,1,4,7};
    assertArrayEquals(result, function.RotateArrayMethod(picture, 3));
  }
  @Test
  public void testThree() 
  {
    RotateArray function = new RotateArray();
	int[] picture = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
	int[] result = {4,8,12,16,3,7,11,15,2,6,10,14,1,5,9,13};
    assertArrayEquals(result, function.RotateArrayMethod(picture, 4));
  }
}