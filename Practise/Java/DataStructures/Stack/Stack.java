/**
	Problems: "Implement a stack"
	Discussion: first in last out; pop and push;
				implemented using an array (the alternative is a linked list)
	*/
public class Stack
{
	private int[] array;
	private int head = (-1);
	
	public Stack(int capacity)
	{
		array = new int[capacity];
	}
	
	public int Pop()
	{
		if(head > (-1))
		{
			head--;
			array[head + 1] = 0;
			return array[head + 1];
		}
		return (-4321);
	}
	
	public void Push(int element)
	{
		if((array.length - 1) > head)
		{
			head++;
			array[head] = element;
		}
	}
	
	public void PrintOut()
	{
		System.out.print("Head: ");
		System.out.println(head);
		System.out.print("Stack: ");
		for (int element : array) System.out.print(element);
		System.out.println();
	}
}