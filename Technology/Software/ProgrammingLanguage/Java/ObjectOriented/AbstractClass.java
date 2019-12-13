// Abstract classes cannot be instantiated
public abstract class AbstractClass {
    // Inheritor wil either also be abstract or will implement the methods

    public abstract void abstractMethod();

    public void concreteMethod() {
        System.out.println("CONCRETE method in abstract class");
    }
}
