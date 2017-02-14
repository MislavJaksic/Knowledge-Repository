import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FunctionsTest 
{
  @Test
  public void testAdd() 
  {
    Functions function = new Functions();
	
    assertEquals(11, function.add(5, 6));
  }
  @Test
  public void testTransform() 
  {
    Functions function = new Functions();
	
    assertEquals("5", function.transformIntoString(5));
  }
}