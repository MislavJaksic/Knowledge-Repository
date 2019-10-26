public class Child extends Parent {
    // Child inherits from a Parent; keyword extends
    
    public Child() {
        super(); // super(<paramaters>) calls a constructor of the parent class; must be the first statement in a constructor
        System.out.println("CHILD contructor");

    }

    @Override
    public void NoModifiers() {
        System.out.println("CHILD no modifiers");
    }

    public static void Static() {
        System.out.println("CHILD static");
    }

    // Final methods cannot be overridden
    /*
    public final void Final() {
        System.out.println("PARENT final");
    }
    */
    
    public void ChildMethod() {
        super.ParentMethod(); // super.<parent_method> can be used to invoke methods of the parent class
        System.out.println("CHILD method");
    }
}
