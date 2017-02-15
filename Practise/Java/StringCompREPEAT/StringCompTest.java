import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringCompTest
{
  @Test
  public void testOne() 
  {
    StringComp function = new StringComp();
	
    assertEquals("abc", function.StringCompMethod("abc"));
  }
  @Test
  public void testTwo() 
  {
    StringComp function = new StringComp();
	
    assertEquals("a2b3c4", function.StringCompMethod("aabbbcccc"));
  }
  @Test
  public void testThree() 
  {
    StringComp function = new StringComp();
	
    assertEquals("", function.StringCompMethod(""));
  }
  @Test
  public void testFour() 
  {
    StringComp function = new StringComp();
	
    assertEquals(" ", function.StringCompMethod(" "));
  }
}