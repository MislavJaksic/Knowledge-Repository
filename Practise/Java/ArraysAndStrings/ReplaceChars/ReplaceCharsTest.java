import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ReplaceCharsTest
{
  @Test
  public void testOne() 
  {
    ReplaceChars function = new ReplaceChars();
	
    assertEquals("Mr%20John%20Smith", function.ReplaceCharsMethod("Mr John Smith   "));
  }
  @Test
  public void testTwo() 
  {
    ReplaceChars function = new ReplaceChars();
	
    assertEquals("mellow", function.ReplaceCharsMethod("mellow"));
  }
  @Test
  public void testThree() 
  {
    ReplaceChars function = new ReplaceChars();
	
    assertEquals("", function.ReplaceCharsMethod("  "));
  }
  @Test
  public void testFour() 
  {
    ReplaceChars function = new ReplaceChars();
	
    assertEquals("h%20%20e%20l%20o", function.ReplaceCharsMethod(" h  e l o "));
  }
}