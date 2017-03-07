import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringPermTest
{
  @Test
  public void testOne() 
  {
    StringPerm function = new StringPerm();
	
    assertEquals(true, function.CheckStringPerm("hello", "lloeh"));
  }
  @Test
  public void testTwo() 
  {
    StringPerm function = new StringPerm();
	
    assertEquals(false, function.CheckStringPerm("hell", "  "));
  }
  @Test
  public void testThree() 
  {
    StringPerm function = new StringPerm();
	
    assertEquals(false, function.CheckStringPerm("help", "helping"));
  }
  @Test
  public void testFour() 
  {
    StringPerm function = new StringPerm();
	
    assertEquals(false, function.CheckStringPerm("eeee", "eeeeeeeeeeee"));
  }
}