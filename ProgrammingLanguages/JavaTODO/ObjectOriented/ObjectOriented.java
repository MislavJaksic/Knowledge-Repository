//Class models an object in the real world
//Class is a data structure which has function assosiated with it
//Classes have attributes and methods
public class ObjectOriented
{
	//Attribute
	int number;
	
	//Method
	public static void main(String[] args)
	{
		//Which method to invoke is decided based upon the reference type and the object stored in it
		Parent parent = new Parent(); //->PARENT; parent object and reference
		parent.NonStatic(); //->PARENT
		parent.Static(); //->PARENT
		parent.Final(); //->PARENT
		parent.FinalStatic(); //->PARENT
		parent.ParentMethod(); //->PARENT
		System.out.println("- - - - -");
		
		//Inheritors can access their paraent's methods and attributes
		Child child = new Child(); //-> PARENT then CHILD; child object and reference
		child.NonStatic(); //->CHILD, overridden
		child.Static(); //->CHILD
		child.Final(); //->PARENT, inherited
		child.FinalStatic(); //->PARENT, inherited
		child.ParentMethod(); //->PARENT, inherited
		child.ChildMethod(); //->CHILD
		System.out.println("- - - - -");
		//!!!
		//When the reference and the object don't match the following applies:
		//references hide the child's static methods,
		//while objects override parent's non-static methods
		//!!!
		//child = parent; //-> cannot convert to a more specialised class
		parent = child; //-> Parent reference, new Child() object
		parent.NonStatic(); //->CHILD, invoke based on object, nonstatic overridden by object
		parent.Static(); //->PARENT, invoke based on reference, static hidden by reference
		parent.Final(); //->PARENT, inherited
		parent.FinalStatic(); //->PARENT, inherited
		parent.ParentMethod(); //->PARENT, inherited
		//parent.ChildMethod(); //-> not possible
		System.out.println("- - - - -");
		
		Parent.Static();
		Child.Static();
		System.out.println("- - - - -");
		
		GrandChild grand = new GrandChild(); //-> GRANDCHILD then CHILD then PARENT
		grand.NonStatic(); //->GRANDCHILD, overridden
		grand.Static(); //->GRANDCHILD
		grand.Final(); //->PARENT, inherited
		grand.FinalStatic(); //->PARENT, inherited
		grand.ParentMethod(); //->PARENT, inherited
		grand.ChildMethod(); //->CHILD, inherited
		grand.GrandChildMethod(); //-> GRANDCHILD
		System.out.println("- - - - -");
		
		child = grand; //Child reference, new GrandChild() object
		child.NonStatic(); //->GRANDCHILD, overridden by object
		child.Static(); //->CHILD, hidden by reference
		child.Final(); //->PARENT, inherited
		child.FinalStatic(); //->PARENT, inherited
		child.ParentMethod(); //->PARENT, inherited
		child.ChildMethod(); //->CHILD, inherited
		//child.GrandChildMethod(); //-> not possible
		System.out.println("- - - - -");
		
		parent = grand; //Parent reference, new GrandChild() object
		parent.NonStatic(); //->GRANDCHILD, overridden by object
		parent.Static(); //->PARENT, hidden by reference
		parent.Final(); //->PARENT, inherited
		parent.FinalStatic(); //->PARENT, inherited
		parent.ParentMethod(); //->PARENT, inherited
		//parent.ChildMethod(); //->not possible
		//parent.GrandChildMethod(); //-> not possible
		System.out.println("- - - - -");
		
		//Arrays can have both parent and child objects store in them at the same time
		//Children references cannot have parent object in them
		Parent[] family = {new Child(), new GrandChild(), new Parent()};
		
		if (new Child() instanceof Parent)
		{
			System.out.println("Child is instance of parent"); //-> and so is new Parent()
		}
		
		//Abstract abstractobject = new Abstract(); //-> cannot be instantiated
		AbstractInheritor object = new AbstractInheritor();
		object.AbstractMethod(); //-> ABSTRACT method
	}
}