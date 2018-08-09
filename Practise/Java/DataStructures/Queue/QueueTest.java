import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class QueueTest
{
  @Test
  public void testOne() 
  {
    Queue function = new Queue();
	function.Enqueue(1);
	function.PrintOut();
	function.Enqueue(2);
	function.PrintOut();
	function.Dequeue();
	function.PrintOut();
	function.Dequeue();
	function.PrintOut();
	function.Dequeue();
	function.PrintOut();
  }
}