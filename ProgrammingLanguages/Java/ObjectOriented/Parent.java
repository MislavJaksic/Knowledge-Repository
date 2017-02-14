// Class name and <file_name>.java have to match
public class Parent
{
	//Visibility modifiers
	private String priString = "Private"; //-> seen by the same class
	String nmString = "No modifier"; //-> seen by classes in the same package
	protected String proString = "Protected"; //-> seen by the classes in the same package and classes inheritor classes
	public String pubString = "Public"; //-> seen by everyone
	//The above are called instance variables
	
	//Static attrbiutes are shared between all objects
	static String staString = "Static"; //-> called class variable
	//Final attributes cannot be changed
	final String finString = "Final";
	//Static and final are shared and cannot be changed
	static final String staFinString = "Static and final";
	//Static block is executed after attribute declaration
	static
	{
		staString = "Static"; //same as assigment at declaration
	}
	
	//Getters and setters are methods that control access to attributes
	public String getPriString()
	{
		//Never reutrn a reference to a private attribute, always create a new one
		return new String(this.priString);
		//this keyword references the class attribute
	}
	
	//Constructors are invoked upon object creation
	//Has the same name as the class, no return type
	public Parent()
	{
		System.out.println("PARENT contructor");
	}
	
	//Overloading is when methods have the same name, but different signatures
	public Parent(int number)
	{
		//this(<paramaters>) calls another constructor in the same class
		this();
	}
	
	public void NonStatic()
	{
		System.out.println("PARENT nonstatic");
	}
	
	//Classes can invoke static methods with <class_name>.<static_method_name>(<arguments>)
	public static void Static()
	{
		System.out.println("PARENT static");
	}
	
	//Methods marked with final cannot be overridden or hidden
	public final void Final()
	{
		System.out.println("PARENT final");
	}
	
	public final static void FinalStatic()
	{
		System.out.println("PARENT final and static");
	}
	
	public void ParentMethod()
	{
		System.out.println("PARENT method");
	}
}

//Child inherits from a Parent; keyword extends
class Child extends Parent
{
	public Child()
	{
		//super(<paramaters>) calls a constructor of the parent class
		super(); //-> must be the first statement in a constructor
		System.out.println("CHILD contructor");
		
	}
	
	//@Override of Parent's NonStatic
	public void NonStatic()
	{
		System.out.println("CHILD nonstatic");
	}
	
	public static void Static()
	{
		System.out.println("CHILD static");
	}
	
	//Final methods cannot be overridden 
	/*public final void Final()
	{
		System.out.println("CHILD final");
	}
	//Final methods cannot be hidden
	public final static void FinalStatic()
	{
		System.out.println("CHILD final and static");
	}*/
	
	public void ChildMethod()
	{
		//super.<parent_method> can be used to invoke methods of the parent class
		super.ParentMethod();
		System.out.println("CHILD method");
	}
}


//Classes marked with final cannot be inherited
final class GrandChild extends Child
{
	public GrandChild()
	{
		super(); //-> must be the first statement in a constructor
		System.out.println("GRANDCHILD contructor");
		
	}
	
	//@Override of Child's NonStatic
	public void NonStatic()
	{
		System.out.println("GRANDCHILD nonstatic");
	}
	
	public static void Static()
	{
		System.out.println("GRANDCHILD static");
	}
	
	public void GrandChildMethod()
	{
		System.out.println("GRANDCHILD method");
	}
}

//Objects cannot be created from abstract classes
//Can be inherited by another abstract class
abstract class Abstract
{
	//Has to be implemented by an inheritor class
	public abstract void AbstractMethod();
}

class AbstractInheritor
{
	public void AbstractMethod()
	{
		System.out.println("ABSTRACT method");
	}
}

interface Interface
{
	public void setNumber (int number);
	
	public int getNumber();
}

//Class has to implement all interface methods, it cannot leave them abstract
class Implements implements Interface
{
	private int number = 0;
	
	public void setNumber (int number)
	{
		this.number = number;
	}
	
	public int getNumber()
	{
		return new Integer (number);
	}
}
	