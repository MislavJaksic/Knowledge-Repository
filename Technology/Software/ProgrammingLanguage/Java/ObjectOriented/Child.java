public class Child extends Parent {
    // Child inherits from a Parent; keyword extends

    public Child() {
        super(); // super(<paramaters>) calls a constructor of the parent class; must be the first statement in a constructor
        System.out.println("CHILD contructor");

    }

    @Override
    public void noModifiersMethod() {
        System.out.println("CHILD no modifiers");
    }

    public static void staticMethod() {
        System.out.println("CHILD static");
    }

    // final methods cannot be overridden
    /*
    public final void finalMethod() {
        System.out.println("PARENT final");
    }
    */

    public void childMethod() {
        super.Parent(); // super.<parent_method> can be used to invoke methods of the parent class
        System.out.println("CHILD method");
    }
}
