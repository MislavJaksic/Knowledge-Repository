/**
	Problems: "Implement a queue"
	Discussion: can be implemented as an array or a linked list (implementing it as an array as a ciclical buffer is fiddly)
				first in first out; head adds, tail pops;
				there is no way to deconstruct an object manually
	*/
public class Queue
{
	private Node head = null;
	private Node tail = null;
	
	public void Enqueue(int element)
	{
		Node node = new Node();
		node.element = element;
		node.next = null;
		if(head == null)
		{
			head = node;
			tail = node;
		}
		else
		{
			head.next = node;
			head = node;
		}
	}
	
	public int Dequeue()
	{
		if(tail != null)
		{
			Node node = tail;
			if(tail == head)
				head = null;
			tail = tail.next;
			node.next = null;
			return node.element;
		}
		return (-4321);
	}
	
	public void PrintOut()
	{
		System.out.print("Head: ");
		if(head != null)
			System.out.println(head.element);
		else
			System.out.println(head);
		System.out.print("Tail: ");
		if(tail != null)
			System.out.println(tail.element);
		else
			System.out.println(tail);
	}
}

class Node
{
	public int element;
	public Node next;
}