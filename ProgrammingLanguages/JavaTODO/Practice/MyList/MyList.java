public final class MyList
{
	private int LENGTH = 0;
	private MyListElement lastElement = null;
	
	public int AddLast(Object o)
	{
		MyListElement newElement = new MyListElement();
		newElement.data = o;
		newElement.nextElement = lastElement;
		lastElement = newElement;
		LENGTH = LENGTH + 1;
		return LENGTH;
	}
	public Object RemoveAt(int index)
	{
		int depthCounter = LENGTH - 1;
		LENGTH -= 1;
		MyListElement currentElement = lastElement;
		if (index == depthCounter)
		{
			lastElement = lastElement.nextElement;
			return currentElement.data;
		}
		
		MyListElement previousElement;
		do
		{
			previousElement = currentElement;
			currentElement = currentElement.nextElement;
			depthCounter -= 1;
		}while(index < depthCounter);
		previousElement.nextElement = currentElement.nextElement;
		return currentElement.data;
	}
	public Object ElementAt(int index)
	{
		int depthCounter = LENGTH - 1;
		MyListElement currentElement = lastElement;
		while (index < depthCounter)
		{
			currentElement = currentElement.nextElement;
			depthCounter -= 1;
		}
		return currentElement.data;
	}
	public int Size()
	{
		return new Integer(LENGTH);
	}
	public MyListElement getLastElement()
	{
		//not encapsulated!
		return lastElement;
	}
	//Works!
	/*public static void main(String[] args)
	{
		MyList list = new MyList();
		System.out.println(list.Size()); //-> 0
		list.AddLast("first");
		MyListElement element = list.getLastElement();
		System.out.println(element.data); //-> first
		System.out.println(element.nextElement); //-> null
		System.out.println(list.Size()); //-> 1
		
		list.AddLast("second");
		list.AddLast("third");
		element = list.getLastElement();
		System.out.println(element.data); //-> third
		System.out.println(element.nextElement); //-> nonsence
		System.out.println(element.nextElement.data); //-> second
		
		System.out.println(list.RemoveAt(1)); //-> second
		element = list.getLastElement();
		System.out.println(element.data); //-> third
		System.out.println("- - - - -");
		System.out.println(list.ElementAt(1)); //-> third
		list.AddLast("fourth");
		System.out.println(list.ElementAt(2)); //-> fourth
	}*/
}
class MyListElement
{
	Object data;
	MyListElement nextElement;
}