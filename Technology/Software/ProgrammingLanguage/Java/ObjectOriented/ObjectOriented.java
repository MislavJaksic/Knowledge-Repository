public class ObjectOriented {
    // Class name and <file_name>.java have to match

    // Fields
    int number;

    // Methods
    public static void main(String[] args) {
        // Which method will be executed?
        // It is based on reference type and object instance

        Parent parent_ref_and_object = new Parent();  // -> PARENT; parent object and reference
        // Children inherit methods and attributes from their parents
        Child child_ref_and_object = new Child();  // -> PARENT then CHILD; child object and reference
        // When there is a mismatch between a reference and an object the following rules apply:
        //    reference will "hide" the child's static methods
        //    object will "override" the parent's non-static methods
        // child = parent;  // -> cannot cast into a more specialised class
        Parent parent_ref_child_object = new Child();

        parent_ref_and_object.NoModifiers();     // -> PARENT
        parent_ref_and_object.Static();          // -> PARENT
        parent_ref_and_object.Final();           // -> PARENT
        parent_ref_and_object.FinalStatic();     // -> PARENT
        parent_ref_and_object.ParentMethod();    // -> PARENT
        System.out.println("- - - - -");

        child_ref_and_object.NoModifiers();     // -> CHILD, overridden
        child_ref_and_object.Static();          // -> CHILD, owner
        child_ref_and_object.Final();           // -> PARENT, inherited
        child_ref_and_object.FinalStatic();     // -> PARENT, inherited
        child_ref_and_object.ParentMethod();    // -> PARENT, inherited
        child_ref_and_object.ChildMethod();     // -> CHILD, owner
        System.out.println("- - - - -");

        parent_ref_child_object.NoModifiers();    // -> CHILD, invoke based on object, non-static overridden by object
        parent_ref_child_object.Static();         // -> PARENT, invoke based on reference, static hidden by reference
        parent_ref_child_object.Final();          // -> PARENT, inherited
        parent_ref_child_object.FinalStatic();    // -> PARENT, inherited
        parent_ref_child_object.ParentMethod();   // -> PARENT, inherited
        // parent_ref_child_object.ChildMethod();  // -> not possible, parent doesen't have child methods
        System.out.println("- - - - -");

        // Statics method can be invoked without instantiation
        Parent.Static();
        Parent.FinalStatic();
        Child.Static();
        Child.FinalStatic();
        System.out.println("- - - - -");



        GrandChild grand_ref_and_object = new GrandChild();  // -> GRANDCHILD then CHILD then PARENT
        Child child_ref_grand_object = new GrandChild();
        Parent parent_ref_grand_object = new GrandChild();

        grand_ref_and_object.NoModifiers();       // -> GRANDCHILD, overridden
        grand_ref_and_object.Static();            // -> GRANDCHILD, owner
        grand_ref_and_object.Final();             // -> PARENT, inherited
        grand_ref_and_object.FinalStatic();       // -> PARENT, inherited
        grand_ref_and_object.ParentMethod();      // -> PARENT, inherited
        grand_ref_and_object.ChildMethod();       // -> CHILD, inherited
        grand_ref_and_object.GrandChildMethod();  // -> GRANDCHILD, owner
        System.out.println("- - - - -");

        child_ref_grand_object.NoModifiers();         // -> GRANDCHILD, overridden by object
        child_ref_grand_object.Static();              // -> CHILD, hidden by reference
        child_ref_grand_object.Final();               // -> PARENT, inherited
        child_ref_grand_object.FinalStatic();         // -> PARENT, inherited
        child_ref_grand_object.ParentMethod();        // -> PARENT, inherited
        child_ref_grand_object.ChildMethod();         // -> CHILD, inherited
        // child_ref_grand_object.GrandChildMethod();  // -> not possible, child doesen't have grandchild methods
        System.out.println("- - - - -");

        parent_ref_grand_object.NoModifiers();         // -> GRANDCHILD, overridden by object
        parent_ref_grand_object.Static();              // -> PARENT, hidden by reference
        parent_ref_grand_object.Final();               // -> PARENT, inherited
        parent_ref_grand_object.FinalStatic();         // -> PARENT, inherited
        parent_ref_grand_object.ParentMethod();        // -> PARENT, inherited
        // parent_ref_grand_object.ChildMethod();       // -> not possible, parent doesen't have child methods
        // parent_ref_grand_object.GrandChildMethod();  // -> not possible, parent doesen't have grandchild methods
        System.out.println("- - - - -");

        Parent[] family = {new Parent(), new Child(), new GrandChild()};
        // GrandChild[] family = {new Parent(), new Child(), new GrandChild()};  // -> doesen't work

        if (new Child() instanceof Parent) {
            System.out.println("Child is instance of parent");  // -> True!
        }



        // Abstract abstractobject = new Abstract();  // -> cannot be instantiated
        AbstractInheritor concrete = new AbstractInheritor();
        concrete.AbstractMethod();  // -> ABSTRACT method implemented

        InterfaceImplementor implementor = new InterfaceImplementor();
        implementor.setNumber(8);
        System.out.println(implementor.getNumber());  // -> 8
    }
}
