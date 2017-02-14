import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UniqueStringTest 
{
  @Test
  public void testOne() 
  {
    UniqueString function = new UniqueString();
	
    assertEquals(false, function.UniqueCharsMap("hello"));
  }
  @Test
  public void testTwo() 
  {
    UniqueString function = new UniqueString();
	
    assertEquals(false, function.UniqueCharsMap("hell"));
  }
  @Test
  public void testThree() 
  {
    UniqueString function = new UniqueString();
	
    assertEquals(true, function.UniqueCharsMap("help"));
  }
  @Test
  public void testFour() 
  {
    UniqueString function = new UniqueString();
	
    assertEquals(true, function.UniqueCharsMap(" "));
  }
  
  
  @Test
  public void testFive() 
  {
    UniqueString function = new UniqueString();
	
    assertEquals(true, function.UniqueChars(""));
  }
  @Test
  public void testSix() 
  {
    UniqueString function = new UniqueString();
	
    assertEquals(false, function.UniqueChars("hellllllllll"));
  }
  @Test
  public void testSeven() 
  {
    UniqueString function = new UniqueString();
	
    assertEquals(true, function.UniqueChars("no"));
  }
}