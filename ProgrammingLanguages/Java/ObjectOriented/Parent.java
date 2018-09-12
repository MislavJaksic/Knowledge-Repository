public class Parent {
    //Instance fields
    private String private_string = "Private";       //-> seen by the same class
    String no_mod_string = "No modifier";            //-> seen by classes in the same package
    protected String protected_string = "Protected"; //-> seen by the classes in the same package and classes inheritor classes
    public String public_string = "Public";          //-> seen by everyone

    //Class fields
    //Static fields belong to a class; shared among all objects
    static String static_string = "Static";
    //Final fields cannot be changed
    final String final_string = "Final";
    static final String static_final_string = "Static and final";
    
    static {
        //Static block is executed after field declaration
        static_string = "Static";
    }
    
    
    
    //Constructors are invoked upon object creation
    //Same name as the class, no return type
    public Parent() {
        System.out.println("PARENT contructor");
    }

    //Overloading is when methods have the same name, but different method signatures
    public Parent(int number) {
        this(); //this(<parm1, param2, ...>) calls another constructor in same class
    }

    
    
    //Getters and setters are methods that control access to fields
    public String getPrivate_string() {
        //Never reutrn a reference to a private field; always create a new one
        return this.private_string; //"this." references the object's field
    }
    
    public void setPrivate_string(String private_string) {
        this.private_string = private_string;
    }

    
    
    public void NoModifiers() {
        System.out.println("PARENT no modifiers");
    }

    //Classes can invoke static methods with <class_name>.<static_method_name>(<arguments>)
    public static void Static() {
        System.out.println("PARENT static");
    }

    //Methods marked with final cannot be overridden or hidden
    public final void Final() {
        System.out.println("PARENT final");
    }

    public final static void FinalStatic() {
        System.out.println("PARENT final and static");
    }

    public void ParentMethod() {
        System.out.println("PARENT method");
    }
}