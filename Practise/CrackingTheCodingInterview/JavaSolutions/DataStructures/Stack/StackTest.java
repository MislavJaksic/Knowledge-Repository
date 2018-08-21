import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StackTest
{
  @Test
  public void testOne() 
  {
    Stack stack = new Stack(3);
	stack.PrintOut();
	
	stack.Push(1);
	stack.Push(2);
	stack.Push(3);
	stack.Push(4);
	stack.PrintOut();
	
	stack.Pop();
	stack.Pop();
	stack.Pop();
	stack.Pop();
	stack.PrintOut();
  }
}